// File: MultipleInheritance2.java
class Slogan {
  public void printSlogan() {                        // (1) Concrete method
    System.out.println("Superclass wins!");
  }
}
//_______________________________________________________________________________
interface ISlogan {
  default void printSlogan() {                       // (2) Default method
    System.out.println("Superinterface wins!");
  }
}
//_______________________________________________________________________________
class MySlogan extends Slogan implements ISlogan { } // (3)
//_______________________________________________________________________________
public class MultipleInheritance2 {                  // (4)
  public static void main(String[] args) {
    MySlogan slogan = new MySlogan();
    slogan.printSlogan();                            // (5)
  }
}