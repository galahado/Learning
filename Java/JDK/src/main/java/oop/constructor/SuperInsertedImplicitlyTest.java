package oop.constructor;

public class SuperInsertedImplicitlyTest {
    public static void main(String[] args) {
        Subclass1 sub = new Subclass1();
    }
}

class Superclass1 {
    Superclass1() {
        System.out.println("from superclass");
    }
}

class Subclass1 extends Superclass1 {
    Subclass1() {
        System.out.println("from subclass");
    }
}
