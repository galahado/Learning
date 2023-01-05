// File: AnonClient.java
abstract class Base {           // (1) Superclass
  protected int nsf1;
  abstract void printValue();
}
//_____________________________________________________________________________
class TLCWithAnonClasses {      // (2) Top level Class
  private int nsf1;             // Non-static field
  private int nsf2;             // Non-static field
  private static int sf = 5;    // Static field

  public void nonStaticMethod(final int fp) { // (3) Non-static Method
    // Local variables:
    int flv = 10;               // (4) Effectively final local variable
    final int hlv = 20;         // (5) Final local variable (constant variable)
    int nflv1 = 30;             // (6) Non-final local variable
    int nflv3;                  // (7) Non-final local variable declaration

    nflv1 = 40;                 // (8) Not effectively final local variable

    Base baseRef = new Base() { // (9) Non-static anonymous class
      // Static fields: Accessing local declarations in the enclosing block:
      static int sff1 = fp;   // (10) Final param from enclosing method
      static int sff2 = flv;  // (11) Effect. final variable from enclosing method
//    static int sf1 = nflv1; // (12) Not effect. final from enclosing method

      // Instance fields: Accessing local declarations in the enclosing block:
      int f1 = fp;       // (13) Final param from enclosing method
      int f2 = flv;      // (14) Effectively final variable from enclosing method
//    int f3 = nflv1;    // (15) Not effectively final from enclosing method

//    int f4 = nflv2;    // (16) nflv2 cannot be resolved: not decl-before-use
//    int f5 = nflv3;    // (17) Not definitely assigned: not initialized
      int hlv;           // (18) Shadows local variable at (5)

      // Accessing member declarations inherited from superclass:
      int f6 = nsf1;                   // (19) Inherited from superclass
      int f7 = this.nsf1;              // (20) Inherited from superclass
      int f8 = super.nsf1;             // (21) Inherited from superclass

      // Accessing (hidden) member declarations in the enclosing class:
      int f9 = TLCWithAnonClasses.this.nsf1;          // (22) In enclosing object
      int f10 = nsf2;                  // (23) Instance field in enclosing object
      int f11 = sf;                    // (24) Static field from enclosing class

      { nsf1 = fp; }                   // (25) Non-static initializer block

      @Override void printValue() {                        // (26) Instance method
        System.out.println("Instance field nsf1: " + nsf1);// (27)
      }
    };

    int nflv2 = 70;
    nflv3 = 80;
    baseRef.printValue();              // (28) Invoke method on anonymous object
  }

  public static final Base baseField = new Base() { // (29) Static anonymous class
    // Accessing (hidden) member declarations in the enclosing class:
//  int f1 = TLCWithAnonClasses.this.nsf1; // (30) Not OK. No enclosing object
//  int f2 = nsf2;                         // (31) Not OK. No enclosing object
    { nsf1 = sf; }                         // (32) Non-static initializer block

    @Override void printValue() {                        // (33) Instance method
      System.out.println("Instance field nsf1: " + nsf1);// (34)
    }
  };
}
//_____________________________________________________________________________
public class AnonClient {
  public static void main(String[] args) {
    new TLCWithAnonClasses().nonStaticMethod(100);                // (35)
    TLCWithAnonClasses.baseField.printValue();                    // (36)
  }
}