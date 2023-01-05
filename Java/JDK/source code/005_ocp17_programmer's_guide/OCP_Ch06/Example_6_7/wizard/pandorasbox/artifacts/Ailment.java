// File: Ailment.java
package wizard.pandorasbox.artifacts;        // Package declaration

public class Ailment {                       // Accessible outside package
  String ailmentName;
  public Ailment(String name) { ailmentName = name; }
  public String toString() { return ailmentName; }
}