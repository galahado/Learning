import java.util.Arrays;
import static java.lang.System.out;

class Light {                                    // (1)
  // Static final variables:
  public static final double KWH_PRICE = 3.25;   // (2) Constant static variable
  public static final String MANUFACTURER;       // (3) Blank final static field

  static {                                       // Static initializer block
    MANUFACTURER = "Ozam";                       // (4) Initializes (3)
  }

  // Instance variables:
  int noOfWatts;                                 // (5)
  final String color;                            // (6) Blank final instance field
  final String energyRating;                     // (7) Blank final instance field

  {                                              // Instance initializer block
    color = "off white";                         // (8) Initializes (6)
  }

  // Constructor:
  Light() {
    energyRating = "A++";                        // (9) Initializes (7)
  }

  public final void setWatts(int watt) {         // (10) Final instance method
    this.noOfWatts = watt;
  }

  public static void setKWH(double rate) {
//  KWH_PRICE = rate;                            // (11) Not OK. Final field.
  }
}
//______________________________________________________________________________
class TubeLight extends Light {                  // (12)
  static StringBuilder color = new StringBuilder("green");      // (13) Hiding (6)

//@Override
//public void setWatts(int watt) {   // (14) Cannot override final method at (10)!
//  noOfWatts = 2*watt;
//}
}
//______________________________________________________________________________
public class Warehouse {
  public static void main(final String[] args) { // (15) Final parameter

    final Light workLight = new Light(); // (16) Non-blank final local variable.
    workLight.setWatts(100);             // (17) OK. Changing object state.
//  workLight.color = "pink";            // (18) Not OK. Final instance field.
//  workLight = new Light();             // (19) Not OK. Changing final reference.

    final Light alarmLight;              // (20) Blank final local variable.
//  alarmLight.setWatts(200);            // (21) Not OK. Not initialized.

    Light carLight;                      // (22) Non-final local variable.
//  carLight.setWatts(10);               // (23) Not OK. Not initialized.

    out.println("Accessing final static fields in class Light:");
    out.println("KWH_PRICE:    " + Light.KWH_PRICE);
    out.println("MANUFACTURER: " + Light.MANUFACTURER);

    out.println("Accessing final instance fields in an object of class Light:");
    out.println("noOfWatts:    " + workLight.noOfWatts);
    out.println("color:        " + workLight.color);
    out.println("energyRating: " + workLight.energyRating);

    out.println("Fun with final parameter args:");
    out.println(Arrays.toString(args));  // Print array.
    out.println("args length: " + args.length);
    args[0] = "1";                       // (24) OK. Modifying array state.
    out.println(Arrays.toString(args));  // Print array.
//  args = null;                         // (25) Not OK. Final parameter.
//  args.length = 10;                    // (26) Not OK. Final instance field.
  }
}