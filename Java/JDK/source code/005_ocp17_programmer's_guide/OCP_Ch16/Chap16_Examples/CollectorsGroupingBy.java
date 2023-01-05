import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public final class CollectorsGroupingBy {
  public static void main(String[] args) {

    // Query: Group by number of tracks.
    Map<Integer, List<CD>> map11 = CD.cdList.stream()
        .collect(Collectors.groupingBy(CD::noOfTracks));
    System.out.println(map11);

    Map<Integer, List<CD>> map22 = CD.cdList.stream()
        .collect(Collectors.groupingBy(CD::noOfTracks, Collectors.toList()));
    System.out.println(map22);

    Map<Integer, List<CD>> map33 = CD.cdList.stream()
        .collect(Collectors.groupingBy(CD::noOfTracks,
            TreeMap::new,
            Collectors.toList()));
    System.out.println(map33);

    Map<Integer, Set<CD>> map44 = CD.cdList.stream()
        .collect(Collectors.groupingBy(CD::noOfTracks, Collectors.toSet()));
    System.out.println(map44);

    Map<Integer, Long> map55 = CD.cdList.stream()
        .collect(Collectors.groupingBy(CD::noOfTracks, Collectors.counting()));
    //{6=1, 8=2, 10=2}
    System.out.println(map55);

    ConcurrentMap<Integer, Long> map66 = CD.cdList.parallelStream()
        .collect(Collectors.groupingByConcurrent(CD::noOfTracks,
            Collectors.counting()));
    //{6=1, 8=2, 10=2}
    System.out.println(map66);

    //__________________________ Multi-level grouping
    // Query: Grouping by number of tracks, followed by grouping by genre.
    Map<Integer, Map<Genre, List<CD>>> twoLevelGrp = CD.cdList.stream()
        .collect(Collectors.groupingBy(CD::noOfTracks,          // (1)
            Collectors.groupingBy(CD::genre)));            // (2)
    System.out.println(twoLevelGrp);

    //__________________________
    //Query: Grouping by number of tracks, followed by grouping by genre, counting CDs in each genre.
    Map<Integer, Map<Genre, Long>> twoLevelGrp2 = CD.cdList.stream()
        .collect(Collectors.groupingBy(CD::noOfTracks,
            Collectors.groupingBy(CD::genre,
                Collectors.counting())));   // (3)
    System.out.println(twoLevelGrp2);

    //_____________ mapping()
    // Query: Grouping by number of tracks, followed by mapping to CD title.
    Map<Integer, List<String>> map77 = CD.cdList.stream()
        .collect(Collectors.groupingBy(
            CD::noOfTracks,
            TreeMap::new,
            Collectors.mapping(CD::title, Collectors.toList())));
    System.out.println(map77);

    // Query: Grouping by title length, followed by mapping to first char of title.
    Map<Integer, Optional<Character>> map3 = CD.cdList.stream().collect(
        Collectors.groupingBy(
            cd -> cd.title().length(),
            Collectors.mapping(
                cd -> cd.title().charAt(0),
                Collectors.minBy(Comparator.naturalOrder()))));
    System.out.println(map3);
    // {19=Optional[G], 8=Optional[J], 9=Optional[J], 14=Optional[L], 15=Optional[K]}
  }
}
