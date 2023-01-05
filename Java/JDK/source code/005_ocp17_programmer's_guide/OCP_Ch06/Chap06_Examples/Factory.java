// File: Factory.java (in unnamed package)
import mypkg.State;                  // (1) Single type import

import static mypkg.State.*;         // (2) Static import on demand
import static java.lang.System.out;  // (3) Single static import

public class Factory {
  public static void main(String[] args) {
    State[] states = {               // (4) Using type import implied by (1)
        IDLE, BUSY, IDLE, BLOCKED    // (5) Using static import implied by (2)
    };
    for (State s : states)           // (6) Using type import implied by (1)
      out.print(s + " ");            // (7) Using static import implied by (3)
  }
}