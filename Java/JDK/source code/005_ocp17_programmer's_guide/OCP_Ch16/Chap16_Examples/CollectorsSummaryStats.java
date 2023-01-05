import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

public final class CollectorsSummaryStats {
  public static void main(String[] args) {

    IntSummaryStatistics stats1 = CD.cdList.stream()
        .collect(
            Collectors.summarizingInt(CD::noOfTracks)   // (1) Standalone collector
            );
    System.out.println(stats1);
    // IntSummaryStatistics{count=5, sum=42, min=6, average=8.400000, max=10}

    Map<Genre, IntSummaryStatistics> grpByGenre = CD.cdList.stream()
        .collect(Collectors.groupingBy(
            CD::genre,
            Collectors.summarizingInt(CD::noOfTracks))); // (2) Downstream collector
    System.out.println(grpByGenre);
    //{POP=IntSummaryStatistics{count=2, sum=18, min=8, average=9.000000, max=10},
    //JAZZ=IntSummaryStatistics{count=3, sum=24, min=6, average=8.000000, max=10}}

    System.out.println(grpByGenre.get(Genre.JAZZ));   // Summary stats for Jazz CDs.
    // IntSummaryStatistics{count=3, sum=24, min=6, average=8.000000, max=10}

    IntSummaryStatistics stats2 = CD.cdList.stream()
        .mapToInt(CD::noOfTracks)
        .summaryStatistics();
    System.out.println(stats2);
    // IntSummaryStatistics{count=5, sum=42, min=6, average=8.400000, max=10}
  }
}
