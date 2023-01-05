// File: Baldness.java
package wizard.spells;                       // Package declaration

import wizard.pandorasbox.*;                 // Redundant
import wizard.pandorasbox.artifacts.*;       // Import of subpackage

public class Baldness extends Ailment {      // Simple name for Ailment
  wizard.pandorasbox.LovePotion tlcOne;      // Fully qualified name
  LovePotion tlcTwo;                         // Class in same package
  Baldness(String name) {
    super(name);
    tlcOne = new wizard.pandorasbox.         // Fully qualified name
                 LovePotion("romance");
    tlcTwo = new LovePotion();               // Class in same package
  }
}

class LovePotion /* implements Magic */ {    // (5) Magic is not accessible
  // @Override public void levitate() {}     // (6) Cannot override method
}