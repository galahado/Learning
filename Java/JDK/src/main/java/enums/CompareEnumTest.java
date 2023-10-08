package enums;

import org.junit.jupiter.api.Test;

public class CompareEnumTest {
    enum MachineState {BUSY, IDLE, BLOCKED}

    @Test
    void compareEnumTest() {
        MachineState state1 = MachineState.BUSY;
        MachineState state2 = state1;
        MachineState state3 = MachineState.BLOCKED;

        // all true for the following 3
        System.out.println(state1 == state2);
        System.out.println(state1.equals(state2));
        System.out.println(state1.compareTo(state3) < 0);
    }
}
