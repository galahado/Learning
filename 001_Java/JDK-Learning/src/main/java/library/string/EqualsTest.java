package library.string;

import org.junit.jupiter.api.Test;

public class EqualsTest {

    @Test
    void checkingEquality() {
        System.out.println("abc".equals("ABC"));            // false
        System.out.println("ABC".equals("ABC"));            // true
        System.out.println("abc".equalsIgnoreCase("ABC"));  // true
    }
}
