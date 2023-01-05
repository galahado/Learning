
public class Name {

  Name() {                      // (1) No-argument constructor
    System.out.println("Constructor");
  }

  void Name() {                 // (2) Instance method
    System.out.println("Method");
  }

  public static void main(String[] args) {
    new Name().Name();          // (3) Constructor call followed by method call
  }
}