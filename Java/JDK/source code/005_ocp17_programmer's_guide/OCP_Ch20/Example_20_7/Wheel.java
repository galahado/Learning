import java.io.Serializable;

// public class Wheel implements Serializable {                   // (1a)
public class Wheel {                                              // (1b)
  private int wheelSize;

  public Wheel(int ws) { wheelSize = ws; }

  @Override
  public String toString() { return "wheel size: " + wheelSize; }
}