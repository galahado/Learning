
public class InstanceOF {
  public static void main(String[] args) {
    IDrawable d1 = new Rectangle();
    System.out.println(d1 instanceof IDrawable); // true
    System.out.println(d1 instanceof Shape);     // true
    System.out.println(d1 instanceof Rectangle); // true
    System.out.println(d1 instanceof Circle);    // false
    System.out.println(d1 instanceof Graph);     // false
    // System.out.println(d1 instanceof String);    // Unrelated. Compile-time error

    IDrawable d2 = new Square();
    // d2.area();  // Method not defined for type IDrawable. Compile-time error!
    ((Square) d2).area();  // Prints "Computing area of a Square."
    ((Shape) d2).area();   // Prints "Computing area of a Square."

    IDrawable d3 = new Graph();
    // ((Shape) d3).area();   // Throws a ClassCastException

    if (d2 instanceof Shape shape) {                 // true
      shape.area();                                  // Prints "Computing area of a Square."
    } else {
      System.out.println(d3 + " is not a Shape" );
    }

    if (d3 instanceof Shape shape) {                 // false
      shape.area();
    } else {
      System.out.println(d3.getClass().getName() +
          " is not a Shape." ); // Prints "Graph is not a Shape."
    }

  }
}
