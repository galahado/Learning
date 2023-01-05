import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class CollectorsFiltering {
  public static void main(String[] args) {

    // Query: Group by number of tracks.
    Map<Integer, List<CD>> map11 = CD.cdList.stream()
        .collect(Collectors.groupingBy(CD::noOfTracks));
    System.out.println(map11);

    System.out.println("_____________");

    Map<Integer, List<CD>> grpByTracksFilterByPopCD = CD.cdList.stream()
        .collect(Collectors.groupingBy(CD::noOfTracks,
            Collectors.filtering(CD::isPop, Collectors.toList())));
    System.out.println(grpByTracksFilterByPopCD);

    Map<Integer, List<CD>> filterByPopCDGrpByTracks = CD.cdList.stream()
        .filter(CD::isPop)
        .collect(Collectors.groupingBy(CD::noOfTracks, Collectors.toList()));
    System.out.println(filterByPopCDGrpByTracks);

    Map<Boolean, List<CD>> partbyPopCDsFilterByYear = CD.cdList.stream()
        .collect(Collectors.partitioningBy(CD::isPop,
            Collectors.filtering(cd -> cd.year().equals(Year.of(2018)),
                Collectors.toList()))); // (2)
                System.out.println(partbyPopCDsFilterByYear);

    Map<Boolean, List<CD>> filterByYearPartbyPopCDs = CD.cdList.stream()
        .filter(cd -> cd.year().equals(Year.of(2018)))
        .collect(Collectors.partitioningBy(CD::isPop, Collectors.toList())); // (2)
    System.out.println(filterByYearPartbyPopCDs);

    System.out.println("_____________");
  }
}
