package jdk.java.lang.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubStringTest {

    @Test
    void getSubstring() {
        var name = "animals";
        assertEquals("mals", name.substring(3));
        assertEquals("mals", name.substring(name.indexOf('m')));
        assertEquals("m", name.substring(3, 4));
        assertEquals("mals", name.substring(3, 7));
        assertEquals("", name.substring(3, 3));
    }

    @Test
    void substringException() {
        var name = "animals";

        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            name.substring(3, 2);
        });

        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            name.substring(3, 8);
        });
    }
}
