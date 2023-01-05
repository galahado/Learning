import static java.lang.System.out;
import java.util.*;

public class TestVersionNumber {
  public static void main(String[] args) {
    // Print name of version number class:
    out.println(VersionNumber.class);

    // Create an unsorted array of version numbers:
    VersionNumber[] versions =  new VersionNumber[] {                      // (1)
        new VersionNumber( 3,49, 1), new VersionNumber( 8,19,81),
        new VersionNumber( 2,48,28), new VersionNumber(10,23,78),
        new VersionNumber( 9, 1, 1)};
    out.println("Unsorted array: " + Arrays.toString(versions));

    // Create an unsorted list:
    List<VersionNumber> vnoList = Arrays.asList(versions);                 // (2)
    out.println("Unsorted list:  " + vnoList);

    // Create an unsorted map:
    Map<VersionNumber, Integer> versionStatistics = new HashMap<>();       // (3)
    versionStatistics.put(versions[0], 2000);
    versionStatistics.put(versions[1], 3000);
    versionStatistics.put(versions[2], 4000);
    versionStatistics.put(versions[3], 5000);
    versionStatistics.put(versions[4], 6000);
    out.println("Unsorted map: " + versionStatistics);

    // Sorted set:
    Set<VersionNumber> sortedSet = new TreeSet<>(vnoList);                 // (4)
    out.println("Sorted set: " + sortedSet);

    // Sorted map:
    Map<VersionNumber, Integer> sortedMap = new TreeMap<>(versionStatistics);//(5)
    out.println("Sorted map: " + sortedMap);

    // Sorted list:
    Collections.sort(vnoList);                                             // (6)
    out.println("Sorted list:    " + vnoList);

    // Searching in sorted list:
    VersionNumber searchKey = new VersionNumber( 9, 1, 1);                 // (7)
    int resultIndex = Collections.binarySearch(vnoList, searchKey);        // (8)
    out.printf("Binary search in sorted list found key %s at index: %d%n",
                searchKey, resultIndex);

    // Sorted array:
    Arrays.sort(versions);                                                 // (9)
    out.println("Sorted array:   " + Arrays.toString(versions));

    // Searching in sorted array:
    int resultIndex2 = Arrays.binarySearch(versions, searchKey);           // (10)
    out.printf("Binary search in sorted array found key %s at index: %d%n",
                searchKey, resultIndex2);
  }
}