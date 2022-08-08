package jdk.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortTest {

    @Test
    void sortNumbers() {
        int[] numbers = {6, 9, 1};
        Arrays.sort(numbers);
        assertEquals("[1, 6, 9]", Arrays.toString(numbers));
    }

    @Test
    void sortStrings() {
        String[] strings = {"10", "9", "100"};
        Arrays.sort(strings);
        assertEquals("[10, 100, 9]", Arrays.toString(strings));
    }
}
