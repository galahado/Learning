package jdk.java.time.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;

public class CreatingTest {

    @Test
    void now() {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());
    }

    @Test
    void createLocateDate() {
        System.out.println(LocalDate.of(2000, Month.JANUARY, 20));
        System.out.println(LocalDate.of(2000, 1, 20));
    }

    @Test
    void createLocalTime() {
        System.out.println(LocalTime.of(6, 15));
        System.out.println(LocalTime.of(6, 15, 30));
        System.out.println(LocalTime.of(6, 15, 30, 200));
    }

    @Test
    void createLocalDateTime() {
        System.out.println(LocalDateTime.of(2000, 1, 20, 6, 15, 30));

        LocalDate date = LocalDate.of(2000, 1, 20);
        LocalTime time = LocalTime.of(6, 15, 30);
        System.out.println(LocalDateTime.of(date, time));
    }

    @Test
    void createZonedDateTime() {
        ZoneId zone = ZoneId.of("US/Eastern");
        System.out.println(ZonedDateTime.of(2022, 1, 20, 6, 15, 30, 200, zone));
        LocalDate date = LocalDate.of(2000, 1, 20);
        LocalTime time = LocalTime.of(6, 15, 30, 200);
        System.out.println(ZonedDateTime.of(date, time, zone));
    }
}
