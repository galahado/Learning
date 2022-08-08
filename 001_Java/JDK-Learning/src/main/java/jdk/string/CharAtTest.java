package jdk.string;

import org.junit.jupiter.api.Test;

public class CharAtTest {

    @Test
    void getSingleChar() {
        var name = "animals";
        System.out.println(name.charAt(0)); // a
        System.out.println(name.charAt(6)); // s
        System.out.println(name.charAt(7)); // StringIndexOutOfBoundsException
    }
}
