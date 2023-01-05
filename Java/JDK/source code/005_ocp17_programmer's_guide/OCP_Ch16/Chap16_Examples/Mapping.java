import java.time.Year;
import java.util.List;
import java.util.stream.IntStream;

public final class Mapping {
  public static void main(String[] args) {

    {
      //Query: Create a list of CD titles released in 2018.
      List<String> listOfCDNames = CD.cdList
          .stream()                                            // Stream<CD>
          .filter(cd -> cd.year().equals(Year.of(2018)))    // Stream<CD>
          .map(CD::title)                                   // Stream<String>
          .toList();                       // List<String>
      System.out.println("CDs released in 2018: " + listOfCDNames);
    }

    {
      //Query: In which years were CDs released?
      CD.cdList.stream()                                   // Stream<CD>
      .map(CD::year)                           // Stream<Year>
      .distinct()                                 // Stream<Year>
      .mapToInt(Year::getValue)                   // IntStream
      .forEach(System.out::println);              // 2017
      // 2018
    }

    {
      int from = 0, to = 5;
      IntStream.range(from, to)                   // [0, 5)
      .map(i -> to + from - 1 - i)       // Reverse the stream values
      .forEach(System.out::print);       // 43210
      System.out.println();
    }

    {
      long sixes = IntStream
          .generate(() -> (int) (6.0 * Math.random()) + 1) // [1, 6]
          .limit(2000)                                     // Number of throws.
          .map(i -> i == 6 ? 1 : 0)             // Dice value mapped to 1 or 0.
          .sum();
      System.out.println("No. of 6's: " + sixes);
    }

    {
      //Query: Create a list of cd titles released in 2018 (loop fusion) -- peek() -- redundant?
      List<CD> cdList = List.of(CD.cd0, CD.cd1, CD.cd2, CD.cd3, CD.cd4);
      List<String> listOfCDNames = cdList
          .stream()                                               // Stream<CD>
          .peek(cd -> System.out.println("Filterinng: " + cd.title()))
          .filter(cd -> cd.year().equals(Year.of(2018)))       // Stream<CD>
          .peek(cd -> System.out.println("Mapping: " + cd.title()))
          .map(CD::title)                                      // Stream<String>
          .toList();                          // List<String>
      System.out.println(listOfCDNames);
    }
  }
}