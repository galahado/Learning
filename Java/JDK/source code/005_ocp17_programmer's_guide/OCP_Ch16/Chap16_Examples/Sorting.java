import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {
  public static void main(String[] args) {

    System.out.println("(1) Positional order in the array:");
    CD[] cdArray = CD.cdArray;
    System.out.println(Arrays.toString(cdArray));              // (1)

    System.out.println("(2) Positional order in the stream:");
    List<CD> cdsByPositionalOrder =                            // (2)
      Arrays.stream(cdArray)
            .toList();
    System.out.println(cdsByPositionalOrder);

    System.out.println("(3) Natural order:");
    List<CD> cdsByNaturalOrder =                               // (3)
      Arrays.stream(cdArray)
            .sorted()
            .toList();
    System.out.println(cdsByNaturalOrder);

    System.out.println("(4) Reversed natural order:");
    List<CD> cdsByRNO =                                        // (4)
      Arrays.stream(cdArray)
//          .sorted((c1, c2) -> -c1.compareTo(c2))
            .sorted(Comparator.reverseOrder())
            .toList();
    System.out.println(cdsByRNO);

    System.out.println("(5) Only Jazz CDs, ordered by title:");
    List<String> jazzCDsByTitle =                              // (5)
      Arrays.stream(cdArray)
            .filter(CD::isJazz)
//          .sorted((c1, c2) -> c1.title().compareTo(c2.title()))
            .sorted(Comparator.comparing(CD::title))
            .map(CD::title)
            .toList();
    System.out.println(jazzCDsByTitle);

    System.out.println("(6) No. of tracks >= 8, ordered by number of tracks:");
    List<CD> cds =                                             // (6)
      Arrays.stream(cdArray)
            .filter(d -> d.noOfTracks() >= 8)
//          .sorted((c1, c2) -> c1.noOfTracks() - c2.noOfTracks())
            .sorted(Comparator.comparing(CD::noOfTracks))
            .toList();
    System.out.println(cds);
  }
}