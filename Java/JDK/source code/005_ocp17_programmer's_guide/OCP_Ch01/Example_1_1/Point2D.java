// File: Point2D.java
public class Point2D {             // Class name
  // Class Member Declarations

  // Fields:                                                         (1)
  private int x;     // The x-coordinate
  private int y;     // The y-coordinate

  // Constructor:                                                    (2)
  public Point2D(int xCoord, int yCoord) {
    x = xCoord;
    y = yCoord;
  }

  // Methods:                                                        (3)
  public int  getX()           { return x; }
  public int  getY()           { return y; }
  public void setX(int xCoord) { x = xCoord; }
  public void setY(int yCoord) { y = yCoord; }
  public String toString() { return "(" + x + "," + y + ")"; } // Format: (x,y)
}