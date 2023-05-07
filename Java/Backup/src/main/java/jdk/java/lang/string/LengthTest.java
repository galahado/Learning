package jdk.java.lang.string;

import org.junit.jupiter.api.Test;

public class LengthTest {

    @Test
    void getLength() {
        var name = "animals";
        System.out.println(name.length()); // 7
    }
}
