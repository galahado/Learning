// File: Clown.java
package wizard.pandorasbox;                  // Package declaration

import wizard.pandorasbox.artifacts.Ailment; // Importing class Ailment

public class Clown implements Magic {        // (1)
  LovePotion tlc;                            // Class in same package
  Ailment problem;                           // Simple class name
  Clown() {
    tlc = new LovePotion("passion");
    problem = new Ailment("flu");            // Simple class name
  }
  @Override public void levitate()  {        // (2)
    System.out.println("Levitating");
  }
  public void mixPotion()   { System.out.println("Mixing " + tlc); }
  public void healAilment() { System.out.println("Healing " + problem); }

  public static void main(String[] args) {
    Clown joker = new Clown();
    joker.levitate();
    joker.mixPotion();
    joker.healAilment();
  }
}

interface Magic { void levitate(); }         // (3)