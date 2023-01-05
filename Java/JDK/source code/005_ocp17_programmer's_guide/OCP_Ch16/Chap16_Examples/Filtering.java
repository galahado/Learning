import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public final class Filtering {
  public static void main(String[] args) {

    // Query 1: Find CDs whose titles are in the set of popular CD titles.
    Set<String> popularTitles = Set.of("Java Jive", "Java Jazz", "Java Jam");

    // Using Stream.filter().
    List<CD> popularCDs1 = CD.cdList
        .stream()
        .filter(cd -> popularTitles.contains(cd.title()))
        .toList();
    System.out.println("Query 1a: " + popularCDs1);

    // Using Collection.removeIf().
    List<CD> popularCDs2 = new ArrayList<>(CD.cdList);
    popularCDs2.removeIf(cd -> !(popularTitles.contains(cd.title())));
    System.out.println("Query 1b: " + popularCDs2);

    // Query 2: Create a list of unique CDs with pop music.
    List<CD> miscCDList = List.of(CD.cd0, CD.cd0, CD.cd1, CD.cd0);
    List<CD> uniquePopCDs1 = miscCDList
        .stream()
        .filter(CD::isPop)
        .distinct()                                // distinct() after filter()
        .toList();
    System.out.println("Query 2: " + uniquePopCDs1);

    // Query 3a: Create a list of jazz CDs, after skipping the first two CDs.
    List<CD> jazzCDs1 = CD.cdList
        .stream()
        .skip(2)                                   // skip() before filter().
        .filter(CD::isJazz)
        .toList();
    System.out.println("Query 3a: " + jazzCDs1);

    // Query 3b: Create a list of jazz CDs, but skip the first two jazz CDs.
    List<CD> jazzCDs2 = CD.cdList                  // Not equivalent to Query 3
        .stream()
        .filter(CD::isJazz)
        .skip(2)                                   // skip() after filter().
        .toList();
    System.out.println("Query 3b: " + jazzCDs2);

    // Query 4: Create a list with the first 2 CDs that were released in 2018.
    List<CD> twoFirstCDs2018 = CD.cdList
        .stream()
        .filter(cd -> cd.year().equals(Year.of(2018)))
        .limit(2)
        .toList();
    System.out.println("Query 4: " + twoFirstCDs2018);

    // limit(n) and skip(n) are complementary.
    List<CD> resultList = Stream
        .concat(CD.cdList.stream().limit(2), CD.cdList.stream().skip(2))
        .toList();
    System.out.println(CD.cdList.equals(resultList));

    // Query 5: Process a substream by skipping 1 and limiting the size to 3.
    List<CD> substream = CD.cdList
        .stream()
        .skip(1)
        .limit(3)
        .toList();
    System.out.println("Query 5: " + substream);
  }
}