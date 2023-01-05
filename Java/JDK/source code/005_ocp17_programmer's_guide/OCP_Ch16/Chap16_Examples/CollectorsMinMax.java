import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public final class CollectorsMinMax {
  public static void main(String[] args) {

    Comparator<CD> natCmp = Comparator.naturalOrder(); // (1)

    Optional<CD> maxCD = CD.cdList.stream()
        .collect(Collectors.maxBy(natCmp));          // (2) Standalone collector
    System.out.println("Max CD: "
        + maxCD.map(CD::title).orElse("No CD.")); // Max CD: Java Jive

    // Group CDs by genre, and max CD in each group.
    Map<Genre, Optional<CD>> grpByGenre = CD.cdList.stream()
        .collect(Collectors.groupingBy(
            CD::genre,
            Collectors.maxBy(natCmp)));       // (3) Downstream collector
    System.out.println(grpByGenre);
    //{JAZZ=Optional[<Jaav, "Java Jam", 6, 2017, JAZZ>],
    // POP=Optional[<Jaav, "Java Jive", 8, 2017, POP>]}

    System.out.println("Title of max Jazz CD: "
        + grpByGenre.get(Genre.JAZZ)
        .map(CD::title)
        .orElse("No CD."));       // Title of max Jazz CD: Java Jam

    // Compare to Stream methods: min(Comparator), max(Comparator)
    // Compare to numeric stream methods: min(), max()
    Optional<CD> maxCD1 = CD.cdList.stream()
        .max(natCmp);                         // (4) max() on Stream<CD>.
    System.out.println("Title of max CD: "
        + maxCD1.map(CD::title)
        .orElse("No CD."));           // Title of max CD: Java Jive

    OptionalInt maxNoOfTracks = CD.cdList.stream()
        .mapToInt(CD::noOfTracks)
        .max();                               // (5) max() on IntStream.
    System.out.println("Max number of tracks: "
        + maxNoOfTracks.orElse(0));           // Max number of tracks: 10
  }
}
