package oop.overriting;

import org.junit.jupiter.api.Test;

public class FinalParametersTest {
    @Test
    void test() {
        SubClassCanDetermineWhetherParametersFinal sub = new SubClassCanDetermineWhetherParametersFinal();
        sub.test(10, "test");
    }
}

class SuperClassWithFinalAndNonFinalParameters {
    public void test(int nonFinalParameter, final String finalParameter) {
        System.out.println("method in the superclass");
    }
}

class SubClassCanDetermineWhetherParametersFinal extends SuperClassWithFinalAndNonFinalParameters {
    @Override
    public void test(final int finalParameter, String nonFinalParameter) {
        System.out.println("method in the subclass");
    }
}
