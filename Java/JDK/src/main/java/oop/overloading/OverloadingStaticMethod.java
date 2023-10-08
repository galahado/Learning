package oop.overloading;

public class OverloadingStaticMethod {
}

class SuperclassWithStaticMethod {
    protected static void test() {
    }

    private static void test(int input) {
    }
}

class SubclassOverloadingStaticMethod extends SuperclassWithStaticMethod {
    private static void test(String s) {
    }

    public void test(String s, int i) {
    }
}
