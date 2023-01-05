// File: HiddenAndInheritedAccess.java
class Superclass {
  protected int value = 3;                 // (1) Instance field in superclass
}
//_____________________________________________________________________________
class TopLevelClass {                       // (2) Top-level Class
  private double value = 3.14;              // (3) Hidden by the instance field
                                            //     at (1) in the inner subclass

  class InnerSubclass extends Superclass {  // (4) Non-static member subclass
    public void printHidden() {             // (5)
      // (6) value from superclass:
      System.out.println("this.value: " + this.value);

      // (7) value from enclosing context:
      System.out.println("TopLevelClass.this.value: "
                        + TopLevelClass.this.value);
    }
  } // InnerSubclass
} // TopLevelClass
//_____________________________________________________________________________
public class HiddenAndInheritedAccess {
  public static void main(String[] args) {
    TopLevelClass.InnerSubclass ref = new TopLevelClass().new InnerSubclass();
    ref.printHidden();
  }
}