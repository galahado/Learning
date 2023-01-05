/** Test the Line class. */
public class TestLine {
  public static void main(String[] args) {

    Line line1 = new Line(new Point2D(5,6), new Point2D(7,8));
    System.out.println(line1.toString());            // Line[(5,6),(7,8)]
    line1.setEndPoint1(new Point2D(11, 12));
    line1.setEndPoint2(new Point2D(13, 14));
    System.out.println(line1.toString());            // Line[(11,12),(13,14)]
    System.out.println("Length: " + line1.length()); // Length: 2.8284271247461903
    System.out.println("End1 point, x-coord: " + line1.getEndPoint1().getX());
    System.out.println("End1 point, y-coord: " + line1.getEndPoint1().getY());
    System.out.println("End2 point, x-coord: " + line1.getEndPoint2().getX());
    System.out.println("End2 point, y-coord: " + line1.getEndPoint2().getY());
  }
}