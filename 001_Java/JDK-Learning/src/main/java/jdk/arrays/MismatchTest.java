package jdk.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MismatchTest {

    @Test
    void simpleMismatch() {
        int a = Arrays.mismatch(new int[]{1}, new int[]{1});
        assertEquals(-1, a);

        int b = Arrays.mismatch(new int[]{1, 2}, new int[]{1});
        assertEquals(1, b);

        int c = Arrays.mismatch(new String[]{"a"}, new String[]{"A"});
        assertEquals(0, c);
    }
}
