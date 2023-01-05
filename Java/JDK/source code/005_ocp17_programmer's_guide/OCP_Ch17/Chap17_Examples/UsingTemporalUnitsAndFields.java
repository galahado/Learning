import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.List;

public class UsingTemporalUnitsAndFields {

  public static void main(String[] args) {

    System.out.println(ChronoUnit.DAYS.getDuration());                      // PT24H
    System.out.println(ChronoUnit.HOURS.isDateBased());                     // false
    System.out.println(ChronoUnit.SECONDS.isTimeBased());                   // true
    System.out.println(ChronoUnit.YEARS.isSupportedBy(LocalTime.MIDNIGHT)); // false

    // TemporalAmounts:
    Duration duration = Duration.ofDays(7);
    Period period = Period.ofYears(10);

    LocalDate date = LocalDate.of(2021, 10, 23);
    System.out.print("Date " + date);
    date = date.minus(10, ChronoUnit.MONTHS).minus(3, ChronoUnit.DAYS);
    System.out.println(" minus 10 months and 3 days: " + date);
    // Date 2021-10-23 minus 10 months and 3 days: 2020-12-20

    LocalTime time = LocalTime.of(14, 15);
    System.out.print("Time " + time);
    time = time.plus(70, ChronoUnit.MINUTES).plus(9, ChronoUnit.HOURS);
    System.out.println(" plus 70 minutes and 9 hours is " + time);
    // Time 14:15 plus 70 minutes and 9 hours is 00:25

    LocalDate fromDate = LocalDate.of(2021, 3, 1);
    LocalDate xmasDate = LocalDate.of(2021, 12, 25);
    long tilChristmas = fromDate.until(xmasDate, ChronoUnit.DAYS);
    System.out.println("From " + fromDate + ", days until Xmas: " + tilChristmas);
    // From 2021-03-01, days until Xmas: 299

    {
      System.out.println(ChronoField.DAY_OF_MONTH.getBaseUnit());             // Days
      System.out.println(ChronoField.HOUR_OF_DAY.isDateBased());              // false
      System.out.println(ChronoField.SECOND_OF_MINUTE.isTimeBased());         // true
      System.out.println(ChronoField.YEAR.isSupportedBy(LocalTime.MIDNIGHT)); // false
    }

    {
      date = LocalDate.of(2021, 6, 18);
      System.out.print("Date " + date);
      int monthValue = date.get(ChronoField.MONTH_OF_YEAR);
      System.out.println(" has month of the year: " + monthValue);
      // Date 2021-06-18 has month of the year: 6
    }

    {
      LocalDateTime dateTime = LocalDateTime.of(2021, 6, 18, 20, 20);
      System.out.print("Date-time " + dateTime);
      dateTime = dateTime.with(ChronoField.DAY_OF_MONTH, 20)
          .with(ChronoField.MONTH_OF_YEAR, 2)
          .with(ChronoField.YEAR, 2020);
      System.out.println(" changed to: " + dateTime);
      // Date-time 2021-06-18T20:20 changed to: 2020-02-20T20:20
    }
  }
}