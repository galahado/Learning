import static java.lang.System.out;
import java.util.*;

public class TestUsableVNO {
  public static void main(String[] args) {
    // Print name of version number class:
    out.println(UsableVNO.class);

    // Three individual version numbers.
    UsableVNO svno1 = new UsableVNO(9,1,1);                               // (1)
    UsableVNO svno2 = new UsableVNO(9,1,1);                               // (2)
    UsableVNO svno3 = new UsableVNO(6,6,6);                               // (3)

    // An array of version numbers.
    UsableVNO[] versions =  new UsableVNO[] {                             // (4)
        new UsableVNO( 3,49, 1), new UsableVNO( 8,19,81),
        new UsableVNO( 2,48,28), new UsableVNO(10,23,78),
        new UsableVNO( 9, 1, 1)};

    out.printf ("  svno1: %s, svno2: %s, svno3: %s%n", svno1, svno2, svno3);
    out.println("Test object reference equality:");                       // (5)
    out.println("  svno1 == svno2:      " + (svno1 == svno2));            // (6)
    out.println("  svno1 == svno3:      " + (svno1 == svno3));            // (7)
    out.println("Test object value equality:");
    out.println("  svno1.equals(svno2): " + svno1.equals(svno2));         // (8)
    out.println("  svno1.equals(svno3): " + svno1.equals(svno3));         // (9)
    out.println();

    // Search key:
    UsableVNO searchKey = new UsableVNO(9,1,1);                           // (10)

    // Searching in an array:
    boolean found = false;
    for (UsableVNO version : versions) {
      found = searchKey.equals(version);                                  // (11)
      if (found) break;
    }
    out.println("Array: " + Arrays.toString(versions));                   // (12)
    out.printf("  Search key %s found in array:    %s%n%n",               // (13)
                searchKey, found);

    // Searching in a list:
    List<UsableVNO> vnoList = Arrays.asList(versions);                    // (14)
    out.println("List:  " + vnoList);
    out.printf("  Search key %s contained in list: %s%n%n", searchKey,
                vnoList.contains(searchKey));                             // (15)
  }
}