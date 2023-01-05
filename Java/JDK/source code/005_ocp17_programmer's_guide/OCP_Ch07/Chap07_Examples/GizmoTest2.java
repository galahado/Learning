// File: GizmoTest2.java
public class GizmoTest2 {
  public static void main(String[] args) {
    try (var myGizmo = new Gizmo()) {
      myGizmo.compute();
    } catch (Exception ex) {                                        // (6)
      System.out.println("Exception caught in the catch clause of main():\n\t"
                       + ex);
      System.out.println("Printing suppressed exceptions "
                       + "in the catch clause of main():");
      Throwable[] supressedEx = ex.getSuppressed();                 // (7)
      for (Throwable t : supressedEx) {
        System.out.println("\t" + t);
      }
    } finally {
      System.out.println("Finally: Done in main()");
    }
  }
}