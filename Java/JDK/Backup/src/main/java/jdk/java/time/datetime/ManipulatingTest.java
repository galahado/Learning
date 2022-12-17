package jdk.java.time.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManipulatingTest {

    @Test
    void addTest() {
        var date = LocalDate.of(2022, Month.JANUARY, 20);
        assertEquals("2022-01-20", date.toString());

        date = date.plusDays(2);
        assertEquals("2022-01-22", date.toString());

        date = date.plusWeeks(1);
        assertEquals("2022-01-29", date.toString());

        date = date.plusMonths(1);
        // 2022-02-29 does not exist
        assertEquals("2022-02-28", date.toString());
    }
}
