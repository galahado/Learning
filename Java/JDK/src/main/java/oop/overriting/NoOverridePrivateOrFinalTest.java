package oop.overriting;

public class NoOverridePrivateOrFinalTest {
}

class SuperClassWithPrivateMethod {
    private void test() {
    }
}

class SubClassOverridePrivateMethod extends SuperClassWithPrivateMethod {
    // the private method is not inherited, so it's not overriding
    //    @Override
    public void test() {
    }
}

class SuperClassWithFinalMethod {
    public final void test() {
    }
}

class SubClassOverrideFinalMethod extends SuperClassWithFinalMethod {
    // will not work, cannot override final method
    //    @Override
    //    public void test() {
    //    }
}
