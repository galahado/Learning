package oop.overloading;

public class OverloadInstanceMethodTest {
}

class OverloadingPrivateMethod {
    private void test(String s) {
    }

    private void test() {
    }

    // will not work, it's not overloading, compiler will return error: test() already exist
    //    public String test() {
    //        return "hello";
    //    }
}

class OverloadingPrivateMethodFromSuperClass extends OverloadingPrivateMethod {

    // it's not inherited, so it's not overloading but creating a new one
    private void test() {
    }
}