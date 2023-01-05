import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsFlatMapping {
  public static void main(String[] args) {
    // Some lists of CDs:                                                     (2)
    List<CD> cdList1 = List.of(CD.cd0, CD.cd1, CD.cd1, CD.cd2);
    List<CD> cdList2 = List.of(CD.cd0, CD.cd0, CD.cd3);
    List<CD> cdList3 = List.of(CD.cd0, CD.cd4);

    // Some radio playlists:                                                  (3)
    RadioPlaylist pl1 = new RadioPlaylist("Radio JVM", cdList1);
    RadioPlaylist pl2 = new RadioPlaylist("Radio JRE", cdList2);
    RadioPlaylist pl3 = new RadioPlaylist("Radio JAR", cdList3);

    // List of radio playlists:                                               (4)
    List<RadioPlaylist> radioPlaylists = List.of(pl1, pl2, pl3);

    // Map of radio station names and set of CD titles they played:           (5)
    Map<String, Set<String>> map = radioPlaylists.stream()                 // (6)
        .collect(Collectors.groupingBy(RadioPlaylist::getRadioStationName, // (7)
             Collectors.flatMapping(rpl -> rpl.getPlaylist().stream(),     // (8)
                 Collectors.mapping(CD::title,                             // (9)
                     Collectors.toSet()))));                               // (10)
    System.out.println(map);
  }
}