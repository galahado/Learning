import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class MappingBetweenStreams {
  public static void main(String[] args) {

    List<CD> cdList = CD.cdList;

    //    Mapping between Object Streams -- see mapping and flattening

    //    Mapping an Object Stream to a Numeric Stream
    {
      //Query: Sum number of tracks.
      int totalNumOfTracks = CD.cdList
          .stream()                                         // (1) Stream<CD>
          .mapToInt(CD::noOfTracks)                      // (2) IntStream
          .sum();                                           // (3) 42
      System.out.println(totalNumOfTracks);
    }

    {
      List<CD> cdList1 = List.of(CD.cd0, CD.cd1);
      List<CD> cdList2 = List.of(CD.cd2, CD.cd3, CD.cd4);
      int totalNumOfTracks =
          Stream.of(cdList1, cdList2)                       // (1) Stream<List<CD>>
          .flatMapToInt(                              // (2)
              lst -> lst.stream()                     // (3) Stream<CD>
              .mapToInt(CD::noOfTracks)) // (4) IntStream
          // (5) Stream<IntStream>,
          // flattened to IntStream.
          .sum();                                     // (5) 42
      System.out.println(totalNumOfTracks);
    }

    //    Mapping a Numeric Stream to an Object Stream
    {
      IntStream.rangeClosed(1, 3)               // IntStream
      //         .map(n -> List.of(n, n*n))        // IntUnaryOperator expected. Compile-time error!
      .forEach(pair -> System.out.print(pair + " "));
      System.out.println();
    }

    {
      IntStream.rangeClosed(1, 3)                        // (1) IntStream
      .mapToObj(n -> List.of(n, n*n))     // (2) Stream<List<Integer>>
      .forEach(p -> System.out.print(p + " ")); // [1, 1] [2, 4] [3, 9]
      System.out.println();

      IntStream.rangeClosed(1, 3)                        // (3) IntStream
      .boxed()                                  // (4) Stream<Integer>
      .map(n -> List.of(n, n*n))          // (5) Stream<List<Integer>>
      .forEach(p -> System.out.print(p + " ")); // [1, 1] [2, 4] [3, 9]
      System.out.println();
    }

    {
      List<String> subListTitles = IntStream
          .rangeClosed(2, 3)                               // (1) IntStream
          .mapToObj(i -> CD.cdList.get(i).title())      // (2) Stream<String>
          .toList();        // (3) [Lambda Dancing, Keep on Erasing]System.out.println(subListTitles);
      System.out.println(subListTitles);
    }

    {
      List<Integer> intList = List.of(30, 15, 45, 10, 55);
      int from = 2, to = 4;
      List<Integer> intSublist = IntStream
          .rangeClosed(from, to)                         // IntStream
          .mapToObj(i -> intList.get(i))                 // Stream<Integer>
          .toList();                 // List<Integer>
      System.out.println(intSublist);
    }
    //    Mapping between Numeric Streams

    {
      IntStream.rangeClosed(1, 3)                          // (1) IntStream
      .map(i -> i * i)                            // (2) IntStream
      .forEach(n -> System.out.printf("%d ", n)); // 1 4 9
      System.out.println();
    }

    {
      IntStream.rangeClosed(1, 3)                          // (1) IntStream
      .flatMap(i -> IntStream.rangeClosed(1, 4))  // (2) IntStream <== No such thing as IntStream<IntStream>
      .forEach(n -> System.out.printf("%d ", n)); // 1 2 3 4 1 2 3 4 1 2 3 4
      System.out.println();
    }

    {
      IntStream.rangeClosed(1, 3)                           // (1) IntStream
      .mapToDouble(i -> Math.sqrt(i))              // (2) DoubleStream
      .forEach(d -> System.out.printf("%.2f ", d));// 1.00 1.41 1.73
      System.out.println();
    }

    {
      IntStream.rangeClosed(1, 3)                           // (1) IntStream: Create a range of double values.
      .asDoubleStream()                            // (2) DoubleStream
      .map(d -> Math.sqrt(d))                      // (3) DoubleStream
      .forEach(d -> System.out.printf("%.2f ", d));// 1.00 1.41 1.73
    }

    {
      IntStream.rangeClosed(1, 3)                           // (1) IntStream
      .boxed()                                     // (2) Stream<Integer>
      .map(n -> Math.sqrt(n))                      // (3) Stream<Double>: Boxing/Unboxing.
      .forEach(d -> System.out.printf("%.2f ", d));// 1.00 1.41 1.73
      System.out.println();
    }
  }
}