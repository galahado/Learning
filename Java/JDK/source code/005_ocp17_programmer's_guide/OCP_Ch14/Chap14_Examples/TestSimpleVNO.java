import static java.lang.System.out;

public class TestSimpleVNO {
  public static void main(String[] args) {
    // Print name of version number class:
    out.println(SimpleVNO.class);

    // Three individual version numbers.
    SimpleVNO svno1 = new SimpleVNO(9,1,1);                        // (1)
    SimpleVNO svno2 = new SimpleVNO(9,1,1);                        // (2)
    SimpleVNO svno3 = new SimpleVNO(6,6,6);                        // (3)

    out.printf ("  svno1: %s, svno2: %s, svno3: %s%n", svno1, svno2, svno3);
    out.println("Test object reference equality:");                // (4)
    out.println("  svno1 == svno2:      " + (svno1 == svno2));     // (5)
    out.println("  svno1 == svno3:      " + (svno1 == svno3));     // (6)
    out.println("Test object value equality:");
    out.println("  svno1.equals(svno2): " + svno1.equals(svno2));  // (7)
    out.println("  svno1.equals(svno3): " + svno1.equals(svno3));  // (8)
  }
}