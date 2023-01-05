// File: Point3D.java
public class Point3D extends Point2D {           // (1) Uses extends clause

  // Static variable:                                                   (2)
  private static String info = "A 3D point represented by (x,y,z)-coordinates.";

  // Instance variable:                                                 (3)
  private int z;

  // Constructor:                                                       (4)
  public Point3D(int xCoord, int yCoord, int zCoord) {
    super(xCoord, yCoord);                                           // (5)
    z = zCoord;
  }

  // Instance methods:                                                  (6)
  public int  getZ()           { return z; }
  public void setZ(int zCoord) { z = zCoord; }
  @Override
  public String toString() {
    return "(" + getX() + "," + getY() + "," + z + ")"; // Format: (x,y,z)
  }

  // Static methods:                                                    (7)
  public static double distance(Point3D p1, Point3D p2) {
    int xDiff = p1.getX() - p2.getX();
    int yDiff = p1.getY() - p2.getY();
    int zDiff = p1.getZ() - p2.getZ();
    return Math.sqrt(xDiff*xDiff + yDiff*yDiff + zDiff*zDiff);
  }
  public static void showInfo() { System.out.println(info); }
}