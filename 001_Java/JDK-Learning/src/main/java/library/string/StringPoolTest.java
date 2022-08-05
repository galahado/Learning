package library.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class StringPoolTest {

    @Test
    void stringInPool() {
        String a = "Hello World!";
        String b = "Hello World!";
        assertSame(a, b);
    }

    @Test
    void stringUsingConstructorNotInPool() {
        var a = "Hello world!";
        var b = new String("Hello world!");
        assertNotSame(a, b);
    }

    @Test
    void stringUsingMethodNotInPool() {
        String a = "Hello World!";
        String b = " Hello World!".trim(); // not same literal or constant
        assertNotSame(a, b);
    }

    @Test
    void stringUsingPlusNotInPool() {
        var a = "Hello world";
        var b = "Hello" + " world";
        assertSame(a, b);

        var c = "Hello";
        c += " world";
        assertNotSame(a, c);
    }

    @Test
    void intern() {
        var a = "Hello World";
        var b = new String("Hello World").intern();
        assertSame(a, b);
    }
}
