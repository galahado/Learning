package jdk.string;

import org.junit.jupiter.api.Test;

public class InitializationTest {

    @Test
    void stringInitialize() {
        String s1 = "Fluffy";
        String s2 = new String("Fluffy");
        // Text Block
        // Added in JDK15

        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    void textBlock() {
        String s1 = """
                Hello
                World
                !
                 """;

        String s2 = """
                Hello, my name is Hal. \
                Please enter your name:""";

        System.out.println(s1);
        System.out.println(s2);
    }

}
