// File: LocalClient2.java
class TLCWithNSLClass {                // Top-level Class

  void nonStaticMethod(final int fp) { // (1) Non-static Method
    // Local variables:
    int flv = 10;              // (2) Effectively final local variable
    final int hlv = 20;        // (3) Final local variable (constant variable)
    int nflv1 = 30;            // (4) Non-final local variable
    int nflv3;                 // (5) Non-final local variable declaration

    nflv1 = 40;                // (6) Not effectively final local variable

    // Non-static local class
    class NonStaticLocal {// (7)
      int f1 = fp;        // (8) Final param from enclosing method
      int f2 = flv;       // (9) Effectively final variable from enclosing method
//    int f3 = nflv1;     // (10) Not effectively final from enclosing method
//    int f4 = nflv2;     // (11) Name nflv2 cannot be resolved: use-before-decl
//    int f5 = nflv3;     // (12) Not definitely assigned
      int hlv;            // (13) Shadows local variable at (3)
      NonStaticLocal (int value) {
        hlv = value;
        System.out.println("Instance field: " + hlv);// (14) Prints value from (13)
      }
    } // end NonStaticLocal

    NonStaticLocal nslRef = new NonStaticLocal(200);// (15) Implicit outer object
    int nflv2 = 50;                                 // (16) Attempted use in (11)
    nflv3 = 60;                                     // (17) Initializes (4)
    System.out.println("Local variable: " + hlv);   // (18) Prints value from (3)
  } // end nonStaticMethod
}

public class LocalClient2 {
  public static void main(String[] args) {
    new TLCWithNSLClass().nonStaticMethod(1000);    // (19)
  }
}