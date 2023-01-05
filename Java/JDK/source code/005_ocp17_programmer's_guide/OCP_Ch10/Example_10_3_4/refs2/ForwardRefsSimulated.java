package refs2;

public class ForwardRefsSimulated {

  // Declaration of static fields:
  static int sf1;             // (1) Initialized to default value: 0
  static int sf2;             // (2) Initialized to default value: 0

  static {                    // (3) Static initializer block
    // Code from static block 1:
    System.out.printf("Enter static block 1: sf1=%s, sf2=%s%n",
        sf1, sf2);            // Enter static block 1: sf1=0, sf2=0

    sf1 = 10;                 // (4) sf1 gets the value 10
    var b = sf1 = 20;         // (5) b and sf1 get the value 20
    int c = sf1;              // (6) c gets the value 20

    System.out.printf("Exit static block 1:  sf1=%s, sf2=%s%n",
        sf1, sf2);            // Exit static block 1:  sf1=20, sf2=0

    // Initializer expressions for field declaration:
    sf1 = sf2 = 30;           // (7) sf1 and sf2 get the value 30

    // Code from static block 2:
    System.out.printf("Enter static block 2: sf1=%s, sf2=%s%n",
        sf1, sf2);            // Enter static block 2: sf1=30, sf2=30

    int d = 2 * sf1;          // (8) d gets the value 60
    var e = sf1 = 50;         // (9) e and sf1 get the value 50

    System.out.printf("Exit static block 2:  sf1=%s, sf2=%s%n",
        sf1, sf2);            // Exit static block 2:  sf1=50, sf2=30
  }

  public static void main(String[] args) {
  }
}