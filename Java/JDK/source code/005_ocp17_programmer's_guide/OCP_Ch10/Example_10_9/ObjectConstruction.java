// File: ObjectConstruction.java
class SuperclassA {
  public SuperclassA() {                     // (1) Superclass constructor
    System.out.println("Constructor in SuperclassA");
  }
}
//_______________________________________________________________________________
class SubclassB extends SuperclassA {

  SubclassB() {                              // (2) No-argument constructor
    this(3);
    System.out.println("No-argument constructor in SubclassB");
  }

  SubclassB(int i) {                         // (3) Non-zero argument constructor
    System.out.println("Non-zero argument constructor in SubclassB");
    value = i;
  }

  {                                          // (4) Instance initializer block
    System.out.println("Instance initializer block in SubclassB");
    value = 2;                               // (5)
  }

  int value = initializerExpression();       // (6) Instance field declaration

  private int initializerExpression() {      // (7)
    System.out.println("Instance initializer expression in SubclassB");
    return 1;
  }
}
//_______________________________________________________________________________
public class ObjectConstruction {
  public static void main(String[] args) {
    SubclassB objRef = new SubclassB();         // (8)
    System.out.println("value: " + objRef.value);
  }
}