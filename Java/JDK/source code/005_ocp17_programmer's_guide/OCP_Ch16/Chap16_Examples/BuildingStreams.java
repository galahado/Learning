import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class BuildingStreams {
  public static void main(String[] args) {
    List<CD> cdList = CD.cdList;
    CD[] cdArray = CD.cdArray;

    //    The Empty Stream
    System.out.println("==>The Empty Stream");
    {
      Stream<CD> cdStream = Stream.empty();
      System.out.println("Count: " + cdStream.count());      // Count: 0
      IntStream iStream = IntStream.empty();
      System.out.println("Count: " + iStream.count());       // Count: 0
      System.out.println("Parallel: " + iStream.isParallel());       // Count: 0

    }

    //    Streams from specified Values
    System.out.println("==>Streams from specified Values");

    {
      // From specified objects.
      Stream<CD> cdStream1 = Stream.of(CD.cd0);                     // (1) Single-argument call.
      Stream<CD> cdStream2 = Stream.of(CD.cd0, CD.cd1, CD.cd2);     // (2) Varargs call.
      cdStream2.filter(CD::isPop)                                   // (3)
      .forEach(cd -> System.out.println(cd.title()));   // (4)
      // Output: Java Jive Lambda Dancing

      // From specified numeric values.
      Stream<Integer> integerStream1 = Stream.of(2017, 2018, 2019);        // (1)
      Stream<? extends Number> numStream = Stream.of(100, 3.14D, 5050L);   // (2)
      IntStream intStream1 = IntStream.of(2017, 2018, 2019);               // (3)
      DoubleStream doubleStream = DoubleStream.of(100, 3.14D, 5050L);      // (4)

      // From an array of CDs.
      Stream<CD> cdStream3 = Stream.of(CD.cdArray);                 // (1)
      Stream<CD> cdStream4 = Arrays.stream(CD.cdArray);             // (2)

      // From an array of Integer.
      Integer[] integerArray = {2017, 2018, 2019};                  // (3)
      Stream<Integer> integerStream2 = Stream.of(integerArray);     // (4)
      Stream<Integer> integerStream3 = Arrays.stream(integerArray); // (5)

      // From an array of int.
      int[] intArray = {2017, 2018, 2019};                          // (6)
      Stream<int[]> intArrayStream = Stream.of(intArray);           // (7) Size is 1.
      IntStream intStream2 = IntStream.of(intArray);                // (8)
      IntStream intStream3 = Arrays.stream(intArray);               // (9)
    }

    //    Using Generator Functions to Build Infinite Streams
    // Generate
    System.out.println("==>Generate");

    {
      IntSupplier supplier = () -> (int) (6.0 * Math.random()) + 1;  // (1)
      IntStream diceStream = IntStream.generate(supplier);           // (2)
      diceStream.limit(5)                                            // (3)
      .forEach(i -> System.out.print(i + " "));            // (4)
      System.out.println();
    }

    // Iterate
    System.out.println("==>Iterate");

    {  // Odd numbers
      IntUnaryOperator uop = n -> n + 2;                // (1)
      IntStream oddNums = IntStream.iterate(1, uop);    // (2)
      oddNums.limit(5)                                  // (3)
      .forEach(i -> System.out.print(i + " "));  // (4) 1 3 5 7 9
      System.out.println();
    }

    {  // Odd numbers
      IntStream.iterate(1,  n -> n + 2)
      .limit(5)
      .forEach(System.out::println);
    }

    {
      Stream.iterate("ba", b -> b + "na")
      .limit(5)
      .forEach(System.out::println);
    }

    //    Concatenating Streams
    System.out.println("==>Concatenating Streams");

    { // Unordered resulting stream
      Set<String> strSet1                                                     // (1)
      = Set.of("All", " objects", " are", " equal");
      Set<String> strSet2                                                     // (2)
      = Set.of(" but", " some", " are", " more", " equal", " than", " others.");

      Stream<String> unorderedStream1 = strSet1.stream();                         // (3)
      Stream<String> unorderedStream2 = strSet2.stream();                         // (4)
      Stream.concat(unorderedStream1, unorderedStream2)                           // (5)
      .forEachOrdered(System.out::print);
      // All are equal objects but more are than equal some others.
      System.out.println();

      // Ordered resulting streams
      Stream<String> orderedStream1 = Stream.of("All", " objects",                // (1)
          " are", " equal");
      Stream<String> orderedStream2 = Stream.of(" but", " some", " are", " more", // (2)
          " equal", " than", " others.");
      Stream.concat(orderedStream1, orderedStream2)                               // (3)
      .forEachOrdered(System.out::print);
      // All objects are equal but some are more equal than others.
      System.out.println();

      // Resulting stream is parallel.
      Stream<String> pStream1 = strSet1.stream().parallel();                // (1)
      System.out.println("pStream1 is parallel: " + pStream1.isParallel()); // (2) true
      Stream<String> rStream = Stream.concat(pStream1, strSet2.stream());   // (3)
      System.out.println("rStream is parallel: " + pStream1.isParallel());  // (4) true
      rStream.forEachOrdered(System.out::print);                                   // (5)
      //are equal but more some others. than equalAll are objects
      System.out.println();

    }

    // Streams from Collections
    System.out.println("==>Streams from Collections");
    {
      Set<CD> cdSet = new HashSet<>(CD.cdList);                            // (1)
      long noOfElements = cdSet.stream().count();                          // (2) 5
      System.out.println(noOfElements);

      long noOfJazzCDs = cdList
          .stream()                                                        // (1)
          .filter(CD::isJazz)                                              // (2)
          .count();                                                        // (3) 3
      System.out.println(noOfJazzCDs);
    }

    {
      List<CD> listOfCDS = new ArrayList<>(List.of(CD.cd0, CD.cd1)); // (1)
      Stream<CD> cdStream = listOfCDS.stream();                            // (2)
      listOfCDS.add(CD.cd2);                                               // (3)
      System.out.println(cdStream.count());                                // (4) 3
      //System.out.println(cdStream.count());                                // (4) 3
    }

    { // Stream on a Map.
      Map<Integer, String> dataMap = new HashMap<>();                     // (1)
      dataMap.put(1, "en"); dataMap.put(2, "to");
      dataMap.put(3, "tre"); dataMap.put(4, "fire");
      long numOfEntries = dataMap
          .entrySet()                                                     // (2)
          .stream()                                                       // (3)
          .count();                                                       // (4) 4
      System.out.println("Map: " + numOfEntries);                         // (5)
    }

    //    Streams from Arrays
    System.out.println("==>Streams from Arrays");

    {
      Stream<CD> cdStream = Arrays.stream(cdArray, 1, 4);          // (1)
      long noOfElements = cdStream.count();                        // (2) 3
      System.out.println(noOfElements);
    }
    //    Building a Numeric Stream with a Range
    System.out.println("==>Building a Numeric Stream with a Range");

    {
      //Compare to for(;;) loop.
      int startInclusive = 10, endExclusive = 20;
      for (int i = startInclusive; i < endExclusive; ++i) {
        // Loop body.
      }
    }

    {
      int[] intArray = {30, 15, 45, 10, 55};

      for (int i = 0; i < intArray.length; i++) {
        if (intArray[i] % 2 == 0) {
          System.out.println(intArray[i]);
        }
      }
      System.out.println();

      Arrays.stream(intArray, 0, intArray.length)
      .filter(v -> v % 2 == 0)
      .forEach(v -> System.out.println(v));
      System.out.println();

      IntStream.range(0, intArray.length)
      .map(i -> intArray[i])
      .filter(n -> n % 2 == 0)
      .forEach(System.out::println);
      System.out.println();
    }

    {
      IntStream.range(0, CD.cdArray.length)
      .forEach(i -> System.out.println(cdArray[CD.cdArray.length - 1 - i]));
      System.out.println();
    }

    {
      int divisor = 5;
      int start = 2000, end = 3000;
      long divisables = IntStream
          .rangeClosed(start, end)                                            // (1)
          .filter(number -> number % divisor == 0)                            // (2)
          .count();                                                           // (3)
      System.out.println(divisables);                                         // 201
    }

    { // Fill with increment values.
      int first = 10, len = 8;
      int[] intArray = IntStream.range(first, first + len).toArray();         // (1)
      System.out.println(intArray.length + ": " + Arrays.toString(intArray));
      //8: [10, 11, 12, 13, 14, 15, 16, 17]
    }

    {
      IntStream.rangeClosed(1, 10)                            // Outer range.
      .forEach(i -> IntStream.rangeClosed(1, 10)     // Inner range.
          .forEach(j -> System.out.printf("%2d * %2d = %2d%n",
              i, j, i * j)));
    }

    //    Numeric Streams using Random Class
    System.out.println("Numeric Streams using Random Class");
    {
      Random rng = new Random();                        // (1)

      IntStream iStream = rng.ints();                   // (2) Unlimited, any int value
      int[] intArray = iStream.limit(3).toArray();      // Limits size to 3
      //[-1170441471, 1070948914, 264046613]
      System.out.println(Arrays.toString(intArray));

      intArray = rng.ints(3).toArray();                 // (3) Size 3, any int value
      //[1011448344, -974832344, 816809715]
      System.out.println(Arrays.toString(intArray));

      intArray = rng
          .ints(1, 7)                                   // (4) Unlimited, [1, 6]
          .limit(3)                                     // Limits size to 3
          .toArray();                                   // [5, 2, 4]
      System.out.println(Arrays.toString(intArray));

      intArray = rng
          .ints(3, 1, 7)                                // (5) Size 3, [1, 6]
          .toArray();                                   // [1, 4, 6]
      System.out.println(Arrays.toString(intArray));

      DoubleStream dStream = rng.doubles(3);            // (6) Size 3, [0.0, 1.0)
      double[] dArray = dStream.toArray();
      System.out.println(Arrays.toString(dArray));
      //[0.9333794789872794, 0.7037326827186609, 0.2839257522887708]
    }

    //    Streams from a String/CharSequence
    System.out.println("==>Streams from a String/CharSequence");
    {
      String strSource = "banananana";
      IntStream iStream = strSource.chars();                     // (1)
      iStream.forEach(i -> System.out.print(i + " "));
      // 98 97 110 97 110 97 110 97 110 97

      iStream = strSource.chars();
      iStream.mapToObj(i -> (char)i).forEach(System.out::print);    // (2)
      // banananana
      System.out.println();
    }

    //    Streams to extract lines from a String
    System.out.println("==>Streams to extract lines from a String");
    {
      String inputLines = "Wise men learn from their mistakes.\n"                 // (1)
          + "But wiser men learn from the mistakes of others.\n"
          + "And fools just carry on.";
      Stream<String> lStream = inputLines.lines();                                // (2)
      lStream.filter(l -> l.contains("mistakes")).forEach(System.out::println);   // (3)

      System.out.println();
    }


    //    Stream of Lines from a BufferedReader
    System.out.println("==>Stream of Lines from a BufferedReader");
    {
      try ( FileReader fReader = new FileReader("CD_Data.txt");         // (1)
          BufferedReader bReader = new BufferedReader(fReader);       // (2)
          Stream<String> lStream = bReader.lines()){                  // (3)
        System.out.println("Number of lines: " + lStream.count());      // (4) 13
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    {
      // Stream decl must be in the ARM.
      try ( FileReader fReader = new FileReader("CD_Data.txt");         // (1)
          BufferedReader bReader = new BufferedReader(fReader);       // (2)
          ){                  // (3)
        Stream<String> lStream = bReader
            .lines().
            onClose(()-> System.out.println("Def Closed."));            // Not closed.
        System.out.println("No. of lines: " + lStream.count());         // (4) 13
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }


    //    Streams from Files
    System.out.println("==>Streams from Files");
    {
      // Read all lines from a file as a Stream.
      // Bytes from the file are decoded into characters using the UTF-8 charset
      Path path = Paths.get("CD_Data.txt");                             // (1)
      try (Stream<String> lStream = Files.lines(path)) {                // (2)
        System.out.println("Number of lines: " + lStream.count());      // (3) 13
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }


    {
      // Read all lines from a file as a Stream.
      // Bytes from the file are decoded into characters using the UTF-8 charset
      Path path = Paths.get("CD_Data.txt");
      try (Stream<String> lStream = Files.lines(path)) {
        System.out.println(lStream
            .onClose(()-> System.out.println("Closed: "))
            .count());
        System.out.println(Files
            .lines(path)
            .onClose(()-> System.out.println("Me too closed: "))
            .count());
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    {
      //When ARM is closed, it closes underlying stream as well as underlying file.

      Path path = Paths.get("CD_Data.txt");
      try (Stream<String> lStream = Files
          .lines(path)
          .onClose(()-> System.out.println("I am closed"))) {
        System.out.println(lStream.count());
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    { // Usage of a method that returns a Stream can be disastrous.(Not completed.)
      Path path = Paths.get("CD_Data.txt");
      try (
          BufferedReader bReader = Files.newBufferedReader(path);
          Stream<String> lStream = bReader.lines()) {
        System.out.println(lStream.count());
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    // Using a Stream Builder
    System.out.println("==>Using a Stream Builder");

    {
      Stream.Builder<String> streamBuilder =
          Stream.<String>builder().add("J").add("a").add("v");
      streamBuilder.accept("a");
      Stream<String> strStream = streamBuilder.build();
      strStream.forEach(System.out::print);
    }
  }
}