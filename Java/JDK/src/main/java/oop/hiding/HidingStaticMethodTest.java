package oop.hiding;

import org.junit.jupiter.api.Test;

public class HidingStaticMethodTest {
    @Test
    void test() {
        SuperclassWithStaticMethod.test();
        SubclassHidingStaticMethod.test();
    }
}

class SuperclassWithStaticMethod {
    public static void test() {
        System.out.println("static method in the superclass");
    }
}

class SubclassHidingStaticMethod extends SuperclassWithStaticMethod {
    // will not work, cannot narrow accessibility
//    static void test() {
//        System.out.println("static method in the subclass");
//    }
}

class SuperclassWithStaticFinalMethod {
    public static final void test() {
        System.out.println("static final method in the superclass");
    }
}

class SubclassHidingStaticFinalMethod extends SuperclassWithStaticFinalMethod {
    // will not work, cannot hide final method
//    public static void test() {
//        System.out.println("static method in the subclass");
//    }
}