package jdk.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompareTest {

    @Test
    void simpleCompare() {
        assertTrue(Arrays.compare(new int[]{1}, new int[]{2}) < 0);
    }
}
