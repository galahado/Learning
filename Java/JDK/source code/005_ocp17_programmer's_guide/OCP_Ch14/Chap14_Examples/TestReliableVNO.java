import static java.lang.System.out;
import java.util.*;

public class TestReliableVNO {
  public static void main(String[] args) {
    // Print name of version number class:
    out.println(ReliableVNO.class);

    // An array of version numbers.
    ReliableVNO[] versions =  new ReliableVNO[] {                          // (1)
        new ReliableVNO( 3,49, 1), new ReliableVNO( 8,19,81),
        new ReliableVNO( 2,48,28), new ReliableVNO(10,23,78),
        new ReliableVNO( 9, 1, 1)};

    // Search key and its hash code:
    ReliableVNO searchKey = new ReliableVNO( 9, 1, 1);                     // (2)
    out.printf("Search key %s has hash code: %d%n", searchKey,
        searchKey.hashCode());                                             // (3)

    // Print hash values:
    out.println("Hash codes:");
    for (ReliableVNO element : versions) {                                 // (4)
      out.printf("  %10s: %s%n", element, element.hashCode());
    }
    out.println();

    // Searching in a set:
    Set<ReliableVNO> vnoSet = new HashSet<>(Arrays.asList(versions));      // (5)
    out.println("Set: " + vnoSet);
    out.printf("Search key %s contained in set: %s%n%n", searchKey,
                vnoSet.contains(searchKey));                               // (6)

    // Searching in a map:
    Map<ReliableVNO, Integer> versionStatistics = new HashMap<>();         // (7)
    versionStatistics.put(versions[0], 2000);
    versionStatistics.put(versions[1], 3000);
    versionStatistics.put(versions[2], 4000);
    versionStatistics.put(versions[3], 5000);
    versionStatistics.put(versions[4], 6000);
    out.println("Map: " + versionStatistics);                              // (8)
    out.printf("Search key %s contained in map: %s%n", searchKey,
               versionStatistics.containsKey(searchKey));                  // (9)
  }
}