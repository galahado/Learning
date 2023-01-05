/** Test the Point2D class. */
public class TestPoint2D {
  public static void main(String[] args) {
    Point2D p2A = new Point2D(10, 20);
    System.out.println(p2A);
    System.out.println("x : " + p2A.getX());
    System.out.println("y : " + p2A.getY());

    Point2D p2B = new Point2D(5, 15);
    System.out.println(p2B);
    System.out.println("x : " + p2B.getX());
    System.out.println("y : " + p2B.getY());

    System.out.println(Point2D.distance(p2A, p2B));
    Point2D.showInfo();

    Point2D point = new Point2D(-1, -4); // Create a point with coordinates (-1,-4)
    point.setX(-2);             // (1) The x field is set to the value -2
    int yCoord = point.getY();  // (2) Returns the value -4 of the y field
    System.out.println(point.toString());  // (3) Prints: (-2,-4)
//  point.distanceFromOrigin(); // (4) Compile-time error: No such method.
  }
}