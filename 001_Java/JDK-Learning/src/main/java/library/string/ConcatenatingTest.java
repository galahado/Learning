package library.string;

import org.junit.jupiter.api.Test;

public class ConcatenatingTest {

    @Test
    void usingPlus() {
        System.out.println(1 + 2);           // 3
        System.out.println("a" + "b");       // ab
        System.out.println("a" + "b" + 3);   // ab3
        System.out.println(1 + 2 + "c");     // 3c
        System.out.println("c" + 1 + 2);     // c12
        System.out.println("c" + null);      // cnull


        int three = 3;
        String four = "4";
        System.out.println(1 + 2 + three + four);
    }
}
