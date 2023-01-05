import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class UsingTemporals {

  public static void main(String[] args) {
    // Date-Time: 1945-08-06T08:15
    LocalDateTime doomsday = LocalDateTime.of(1945, 8, 6, 8, 15);
    LocalDate date = doomsday.toLocalDate();                   // 1945-08-06
    LocalTime time = doomsday.toLocalTime();                   // 08:15
    System.out.println("Date-Time: " + doomsday);
    System.out.println();

    // Time: 08:15
    int hourOfDay      = time.getHour();                       // 8
    int minuteOfHour1  = time.getMinute();                     // 15
    int minuteOfHour2  = time.get(ChronoField.MINUTE_OF_HOUR); // 15
    int secondOfMinute = time.getSecond();                     // 0
    System.out.println("Time of day:      " + time);
    System.out.println("Hour-of-day:      " + hourOfDay);
    System.out.println("Minute-of-hour 1: " + minuteOfHour1);
    System.out.println("Minute-of-hour 2: " + minuteOfHour2);
    System.out.println("Second-of-minute: " + secondOfMinute);
    System.out.println();

    // Date: 1945-08-06
    int year       = date.getYear();                           // 1945
    int monthVal1  = date.getMonthValue();                     // 8
    int monthVal2  = date.get(ChronoField.MONTH_OF_YEAR);      // 8
    Month month    = date.getMonth();                          // AUGUST
    DayOfWeek dow  = date.getDayOfWeek();                      // MONDAY
    int day        = date.getDayOfMonth();                     // 6
    System.out.println("Date:  " + date);
    System.out.println("Year:  " + year);
    System.out.println("Month value 1: " + monthVal1);
    System.out.println("Month value 2: " + monthVal2);
    System.out.println("Month-of-year: " + month);
    System.out.println("Day-of-week:   " + dow);
    System.out.println("Day-of-month:  " + day);
    System.out.println();

    // Ordering
    LocalDate d1 = LocalDate.of(1948, 2, 28);                  // 1948-02-28
    LocalDate d2 = LocalDate.of(1949, 3, 1);                   // 1949-03-01
    boolean result1 = d1.isBefore(d2);                         // true
    boolean result2 = d2.isAfter(d1);                          // true
    boolean result3 = d1.isAfter(d1);                          // false
    boolean result4 = d1.isEqual(d2);                          // false
    boolean result5 = d1.isEqual(d1);                          // true
    boolean result6 = d1.isLeapYear();                         // true

    System.out.println("Ordering:");
    System.out.println(d1 + " is before "   + d2 + ": " + result1);
    System.out.println(d2 + " is after "    + d1 + ": " + result2);
    System.out.println(d1 + " is after "    + d1 + ": " + result3);
    System.out.println(d1 + " is equal to " + d2 + ": " + result4);
    System.out.println(d1 + " is equal to " + d1 + ": " + result5);
    System.out.println(d1.getYear() + " is a leap year: " + result6);
    System.out.println();

    System.out.println("Using absolute adjusters:");
    LocalDate date2 = LocalDate.of(2021, 3, 1);
    System.out.println("Date before adjusting: " + date2);     // 2021-03-01
    date2 = date2.withYear(2024).withMonth(2).withDayOfMonth(28);
    System.out.println("Date after adjusting:  " + date2);     // 2024-02-28
    System.out.println();

    System.out.println("Using temporal fields:");
    LocalDate date3 = LocalDate.of(2021, 3, 1);
    System.out.println("Date before adjusting: " + date3);     // 2021-03-01
    date3 = date3
        .with(ChronoField.YEAR, 2024L)
        .with(ChronoField.MONTH_OF_YEAR, 2L)
        .with(ChronoField.DAY_OF_MONTH, 28L);
    System.out.println("Date after adjusting:  " + date3);     // 2024-02-28
  }
}