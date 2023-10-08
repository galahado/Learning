package oop.overloading;

public class AmbiguousCallTest {
    public void test(long x, int y) {
        System.out.println("long , int");
    }

    public void test(int x, long y) {
        System.out.println("int, long");
    }

    public static void main(String[] args) {
        AmbiguousCallTest test = new AmbiguousCallTest();

        // will not work, ambiguous call
//        test.test(1, 1);

        test.test(1L, 1);
        test.test(1, 1L);
    }
}
