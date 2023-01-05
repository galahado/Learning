
public class ATOverride {
  @Override  public String toString() { return "Just using override"; }

  @Override  public int hasCode() { return 1234; }            // Wrong method name

  @Override  public int clone() { return 0; }                 // Wrong return type

  @Override  public boolean equals(String o) { return true; } // Wrong signature
}