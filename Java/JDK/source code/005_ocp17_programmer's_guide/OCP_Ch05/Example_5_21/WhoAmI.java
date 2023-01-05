class Light { /* ... */ }
class LightBulb extends Light { /* ... */ }
class SpotLightBulb extends LightBulb { /* ... */ }
class TubeLight extends Light { /* ... */ }
class NeonLight extends TubeLight { /* ... */ }

public class WhoAmI {
  public static void main(String[] args) {
    boolean result1, result2, result3, result4;
    Light light1 = new LightBulb();                    // (1)
    //  String str = (String) light1;                  // (2) Compile-time error!
    //  result1 = light1 instanceof String;            // (3) Compile-time error!

    result2 = light1 instanceof TubeLight;             // (4) false: peer class.
    //  TubeLight tubeLight1 = (TubeLight) light1;     // (5) ClassCastException!

    result3 = light1 instanceof SpotLightBulb;         // (6) false: superclass.
    //  SpotLightBulb spotRef = (SpotLightBulb) light1;// (7) ClassCastException!

    light1 = new NeonLight();                          // (8)
    if (light1 instanceof TubeLight) {                 // (9) true.
      TubeLight tubeLight2 = (TubeLight) light1;       // (10) OK.
      // Can now use tubeLight2 to access an object of the class NeonLight,
      // but only those members that the object inherits or overrides
      // from the superclass TubeLight.
    }

    SpotLightBulb light2 = new SpotLightBulb();        // (11)
    result4 = light2 instanceof Light;                 // (12) true.
    Light light = (Light) light2;                      // (13) OK. Redundant cast.
  }
}