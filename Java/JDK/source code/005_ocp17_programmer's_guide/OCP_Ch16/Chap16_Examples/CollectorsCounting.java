import java.util.Map;
import java.util.stream.Collectors;

public final class CollectorsCounting {
  public static void main(String[] args) {

    // Count the number of CDs that have Jazz music.
    Long numOfJazzCds1 = CD.cdList.stream().filter(CD::isJazz)
        .collect(Collectors.counting());                  // (1) Standalone collector
    System.out.println(numOfJazzCds1);                    // 3

    // Group CDs by genre, and count the number of CDs in each group.
    Map<Genre, Long> grpByGenre = CD.cdList.stream()
        .collect(Collectors.groupingBy(
            CD::genre,
            Collectors.counting()));             // (2) Downstream collector
    System.out.println(grpByGenre);                       // {POP=2, JAZZ=3}
    System.out.println(grpByGenre.get(Genre.JAZZ));       // 3

    long numOfJazzCds2 = CD.cdList.stream().filter(CD::isJazz)
        .count();                                         // (3) Stream.count()
    System.out.println(numOfJazzCds2);                    // 3
    System.out.println();
  }
}
