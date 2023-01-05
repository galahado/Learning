import java.time.*;

public class DefaultFormattingParsing {
  public static void main(String[] args) {

    System.out.printf("%60s%n", "Default formatting|Default parsing");
    // LocalTime
    LocalTime time = LocalTime.of(12, 30, 15, 99);
    String strTime = time.toString();                 // (1) 12:30:15.000000099
    LocalTime parsedTime = LocalTime.parse(strTime);  // (2)
    System.out.printf("LocalTime: %33s|%s%n", strTime, parsedTime);

    // LocalDate
    LocalDate date = LocalDate.of(2021, 4, 28);
    String strDate = date.toString();                 // 2021-04-28
    LocalDate parsedDate = LocalDate.parse(strDate);
    System.out.printf("LocalDate: %33s|%s%n", strDate, parsedDate);

    // LocalDateTime
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    String strDateTime = dateTime.toString();   // 2021-04-28T12:30:15.000000099
    LocalDateTime parsedDateTime = LocalDateTime.parse(strDateTime);
    System.out.printf("LocalDateTime: %23s|%s%n", strDateTime, parsedDateTime);

    // ZonedDateTime
    ZoneId zID = ZoneId.of("US/Central");
    ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zID);
    String strZonedDateTime = zonedDateTime.toString();
    // 2021-04-28T12:30:15.000000099-05:00[US/Central]
    ZonedDateTime parsedZonedDateTime = ZonedDateTime.parse(strZonedDateTime);
    System.out.printf("ZonedDateTime: %23s|%s%n", strZonedDateTime,
                                                  parsedZonedDateTime);
  }
}