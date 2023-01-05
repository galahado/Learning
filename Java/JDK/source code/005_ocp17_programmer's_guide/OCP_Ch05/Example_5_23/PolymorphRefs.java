// File: PolymorphRefs.java
interface IDrawable {                                                     // (1)
  void draw();
}
//_______________________________________________________________________________
abstract class Shape implements IDrawable {
  abstract public void area();
}
//_______________________________________________________________________________
class Circle extends Shape {
  @Override public void draw() { System.out.println("Drawing a Circle."); }
  @Override public void area() {
    System.out.println("Computing area of a Circle.");
  }
}
//_______________________________________________________________________________
class Rectangle extends Shape {
  @Override public void draw() { System.out.println("Drawing a Rectangle."); }
  @Override public void area() {
    System.out.println("Computing area of a Rectangle.");
  }
}
//_______________________________________________________________________________
class Square extends Rectangle {
  @Override public void draw() { System.out.println("Drawing a Square."); }
  @Override public void area() {
    System.out.println("Computing area of a Square.");
  }
}
//_______________________________________________________________________________
class Graph implements IDrawable {
  @Override public void draw() { System.out.println("Drawing a Graph."); }
}
//_______________________________________________________________________________
public class PolymorphRefs {
  public static void main(String[] args) {
    IDrawable[] drawables
        = {new Square(), new Circle(), new Rectangle(), new Graph()};     // (2)

    System.out.println("Draw drawables:");
    for (IDrawable drawable : drawables) {                                // (3)
      drawable.draw();
    }

    System.out.println("Only draw shapes:");
    for (IDrawable drawable : drawables) {                                // (4)
      if (drawable instanceof Shape) {                                    // (5)
        drawable.draw();
      }
    }

    System.out.println("Only compute area of shapes:");
    for (IDrawable drawable : drawables) {                                // (6)
      if (drawable instanceof Shape shape) {                              // (7)
        shape.area();                                                     // (8)
      }
    }
  }
}
