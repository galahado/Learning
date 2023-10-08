package enums;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class IterateEnum {

    enum MachineState {BUSY, IDLE, BLOCKED}

    @Test
    void iterateTest() {
        for (MachineState state : MachineState.values()) {
            System.out.println(state.name() + ": " + state.ordinal());
        }

        List<String> list = new ArrayList<>();
        list.stream();
    }
}
