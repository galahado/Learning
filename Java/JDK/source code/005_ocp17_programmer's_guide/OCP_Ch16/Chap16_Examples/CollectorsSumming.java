import java.util.Map;
import java.util.stream.Collectors;

public final class CollectorsSumming {
  public static void main(String[] args) {

    Integer sumTracks = CD.cdList.stream()
        .collect(Collectors.summingInt(CD::noOfTracks)); // (1)
    System.out.println(sumTracks);                          // 42

    // Group CDs by genre, and count the number of tracks on the CDs in each group.
    Map<Genre, Integer> grpByGenre = CD.cdList.stream()
        .collect(Collectors.groupingBy(
            CD::genre,
            Collectors.summingInt(CD::noOfTracks))); // (2) Downstream collector
    System.out.println(grpByGenre);                      // {POP=18, JAZZ=24}
    System.out.println(grpByGenre.get(Genre.JAZZ));      // 24

    int sumTracks2 = CD.cdList.stream()                  // (3)
        .mapToInt(CD::noOfTracks)
        .sum();
    System.out.println(sumTracks2);                      // 42
  }
}
