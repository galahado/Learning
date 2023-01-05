import java.time.Year;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public final class CollectorsReducing {
  public static void main(String[] args) {
    // Comparator to compare CDs by title.
    Comparator<CD> cmpByTitle = Comparator.comparing(CD::title);     // (1)
    // Comparator to compare strings by their length.
    Comparator<String> byLength = Comparator.comparing(String::length); // (2)

    Optional<String> longestTitle1 = CD.cdList.stream()
        .map(CD::title)
        .collect(Collectors.reducing(
            BinaryOperator.maxBy(byLength)));         // (3) Standalone collector
    System.out.println(longestTitle1.orElse("No title"));// Keep on Erasing

    Optional<String> longestTitle2 = CD.cdList.stream()  // Stream<CD>
        .map(CD::title)                               // Stream<String>
        .reduce(BinaryOperator.maxBy(byLength));      // (4) Stream.reduce(bop)

    Map<Year, Optional<CD>> cdWithMaxTitleByYear = CD.cdList.stream()
        .collect(Collectors.groupingBy(
             CD::year,
             Collectors.reducing(                        // (5) Downstream collector
                 BinaryOperator.maxBy(cmpByTitle))
             ));
    System.out.println(cdWithMaxTitleByYear);
    // {2017=Optional[<Jaav, "Java Jive", 8, 2017, POP>],
    //  2018=Optional[<Funkies, "Lambda Dancing", 10, 2018, POP>]}
    System.out.println(cdWithMaxTitleByYear.get(Year.of(2018))
                           .map(CD::title).orElse("No title")); // Lambda Dancing

    Map<Year, String> longestTitleByYear = CD.cdList.stream()
        .collect(Collectors.groupingBy(
             CD::year,
             Collectors.reducing("", CD::title,       // (6) Downstream collector
                 BinaryOperator.maxBy(byLength))
             ));
    System.out.println(longestTitleByYear);   // {2017=Java Jive, 2018=Keep on Erasing}
    System.out.println(longestTitleByYear.get(Year.of(2018)));      // Keep on Erasing

    Map<Year, Optional<String>> longestTitleByYear2 = CD.cdList.stream()
        .collect(Collectors.groupingBy(
             CD::year,
             Collectors.mapping(CD::title,            // (7) Downstream collector
                 Collectors.maxBy(byLength))
             ));
    System.out.println(longestTitleByYear2);
    // {2017=Optional[Java Jive], 2018=Optional[Keep on Erasing]}
    System.out.println(longestTitleByYear2.get(Year.of(2018))
                           .orElse("No title."));        // Keep on Erasing

    Map<Year, Integer> noOfTracksByYear = CD.cdList.stream()
        .collect(Collectors.groupingBy(
             CD::year,
             Collectors.reducing(                        // (8) Downstream collector
                 0, CD::noOfTracks, Integer::sum)));
    System.out.println(noOfTracksByYear);                   // {2017=14, 2018=28}
    System.out.println(noOfTracksByYear.get(Year.of(2018)));// 28

    Map<Year, Integer> noOfTracksByYear2 = CD.cdList.stream()
        .collect(Collectors.groupingBy(
             CD::year,
             Collectors.summingInt(CD::noOfTracks))); // (9) Special case collector
  }
}