// File: Extending.java
class OuterA {                                   // (1)
  class InnerA { }                               // (2)
}
//_____________________________________________________________________________
class SubInnerA extends OuterA.InnerA {          // (3) Extends NSMC at (2)

  // (4) Mandatory non-zero argument constructor:
  SubInnerA(OuterA outerRef) {
    outerRef.super();                            // (5) Explicit super() call
  }
}
//_____________________________________________________________________________
class OuterB extends OuterA {                    // (6) Extends class at (1)
  class InnerB extends OuterA.InnerA { }         // (7) Extends NSMC at (2)
}
//_____________________________________________________________________________
public class Extending {
  public static void main(String[] args) {

    // (8) Outer instance passed explicitly in constructor call:
    SubInnerA obj1 = new SubInnerA(new OuterA());
    System.out.println(obj1.getClass());

    // (9) No outer instance passed explicitly in constructor call to InnerB:
    OuterB.InnerB obj2 = new OuterB().new InnerB();
    System.out.println(obj2.getClass());
  }
}