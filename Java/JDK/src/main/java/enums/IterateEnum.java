package enums;

import org.junit.jupiter.api.Test;

public class IterateEnum {

    enum MachineState {BUSY, IDLE, BLOCKED}

    @Test
    void iterateTest() {
        for (MachineState state : MachineState.values()) {
            System.out.println(state.name() + ": " + state.ordinal());
        }
    }
}
