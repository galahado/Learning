// File: LocalClient1.java
class TLCWithSLClass {                             // Top-level Class

  static void staticMethod(final int fp) {         // (1) Static Method
//  StaticLocal slRef = new StaticLocal(10);       // (2) Class cannot be resolved
//  System.out.println(StaticLocal.staticValue()); // (3) Class cannot be resolved


//  public static class StaticLocal { // (4) Not OK. Cannot be static,
                                      //             and no access modifier
    final class StaticLocal {                        // (5) Static local class
      public static final int sf1 = 10;              // (6) Static field
      private int if1;                               // (7) Instance field
      public StaticLocal(int val) {                  // (8) Constructor
        this.if1 = val;
      }
      public int getValue() { return if1; }          // (9) Instance method
      public static int staticValue() { return sf1; }// (10) Static method
    } // end StaticLocal

    StaticLocal slRef2 = new StaticLocal(100);                             // (11)
    System.out.println("Instance field: " + slRef2.if1);                   // (12)
    System.out.println("Instance method call: " + slRef2.getValue());      // (13)
    System.out.println("Static method call: " + StaticLocal.staticValue());// (14)
  } // end staticMethod
}

public class LocalClient1 {
  public static void main(String[] args) {
    TLCWithSLClass.staticMethod(100);                                      // (15)
  }
}