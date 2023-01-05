package record.nested;

class NestedClass {

  public record PointA(int x, int y) {};   // Implicitly static

  public static record PointB(int x, int y) {};

  // Anonymous record class not allowed.
  //   PointA pa = new PointA() {};

  public void instanceMethod() {
    record PointC(int x, int y) {};
    interface II {}
    PointC d = new PointC(0,0);
  }

  static PointA pA;

  public static void staticMethod() {
    record PointD(int x, int y) {
      public void nesteMethod() {
        System.out.println(pA);
      }
    };
    interface II {}

    PointD d = new PointD(0,0);
    PointA a = new PointA(0,0);

  }

}

public class NestedUser {
  public static void main(String[] args) {
    NestedClass.PointA pa = new NestedClass.PointA(0,0);
    NestedClass.PointB pb = new NestedClass.PointB(0,0);
  }
}