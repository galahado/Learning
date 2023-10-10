package oop.constructor;

public class ThisSuperNotTogetherTest {
}

class Superclass {
    public Superclass() {
    }
}

class SubClass extends Superclass {
    public SubClass() {
    }

    public SubClass(String s) {
        // will not work
        // both super() and this() must be the first statement, so they cannot be in one method together
//        super();
//        this();
    }
}
