// File: ObjectInitialization.java
class SuperclassA {
  protected int superValue;                              // (1)
  SuperclassA() {                                        // (2)
    System.out.println("Constructor in SuperclassA");
    this.doValue();                                      // (3)
  }
  void doValue() {                                       // (4)
    this.superValue = 911;
    System.out.println("superValue (from SuperclassA): " + this.superValue);
  }
}
//_______________________________________________________________________________
class SubclassB extends SuperclassA {
  private int value = 800;                               // (5)
  SubclassB() {                                          // (6)
    System.out.println("Constructor in SubclassB");
    this.doValue();
    System.out.println("superValue (from SuperclassA): " + this.superValue);
  }
  @Override
  void doValue() {                                       // (7)
    System.out.println("value (from SubclassB): " + this.value);
  }
}
//_______________________________________________________________________________
public class ObjectInitialization {
  public static void main(String[] args) {
    System.out.println("Creating an object of SubclassB.");
    new SubclassB();                                     // (8)
  }
}