// File: MachineClient.java
public class MachineClient {
  public static void main(String[] args) {

    Machine machine = new Machine();
    machine.setState(MachineState.IDLE);            // (1) Passed as a value.
    // machine.setState(1);                         // (2) Compile error!

    MachineState state = machine.getState();        // (3) Declaring a reference.
    System.out.println(
        "Current machine state: " + state           // (4) Printing the enum name.
    );

    // MachineState newState = new MachineState();  // (5) Compile error!

    System.out.println("All machine states:");
    for (MachineState ms : MachineState.values()) { // (6) Traversing over enum
      System.out.println(ms + ":" + ms.ordinal());  //     contants.
    }

    System.out.println("Comparison:");
    MachineState state1 = MachineState.BUSY;
    MachineState state2 = state1;
    MachineState state3 = MachineState.BLOCKED;

    System.out.println(state1 + " == " + state2 + ": " +
                       (state1 == state2));                           // (7)
    System.out.println(state1 + " is equal to " + state2 + ": " +
                       (state1.equals(state2)));                      // (8)
    System.out.println(state1 + " is less than " + state3 + ": " +
                       (state1.compareTo(state3) < 0));               // (9)
  }
}