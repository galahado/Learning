package oop.overriting;

import org.junit.jupiter.api.Test;

public class AccessLevelTest {
    @Test
    void test() {
        SubClassProtected subClassProtected = new SubClassProtected();
        subClassProtected.test();

        SubClassPublic subClassPublic = new SubClassPublic();
        subClassPublic.test();

    }
}

class SuperClassDefault {
    void test() {
    }
}

class SubClassProtected extends SuperClassDefault {
    @Override
    protected void test() {
        System.out.println("test in protected method");
    }
}

class SubClassPublic extends SuperClassDefault {
    @Override
    public void test() {
        System.out.println("test in public method");
    }
}

class SubClassPrivate extends SuperClassDefault {
    // not working, cannot narrow the accessibility
//    @Override
//    private void test() {
//    }
}
