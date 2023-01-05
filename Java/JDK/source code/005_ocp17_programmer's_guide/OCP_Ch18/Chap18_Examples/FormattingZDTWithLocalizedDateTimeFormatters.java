import java.time.*;
import java.time.format.*;
import java.util.Locale;

public class FormattingZDTWithLocalizedDateTimeFormatters {
  public static void main(String[] args) {
    // Create some date-time formatters:
    DateTimeFormatter[] dtFormatters = {                                 // (1)
      DateTimeFormatter.ISO_ZONED_DATE_TIME,
      DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG),
      DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
    };
    String[] formatStyles = {"ISO", "LONG", "FULL"};

    // Temporal objects
    LocalTime time = LocalTime.of(14, 15, 30);
    LocalDate date = LocalDate.of(2021, 5, 17);
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime,
                                                   ZoneId.of("US/Central"));

    System.out.println("Locale: " + Locale.US);
    System.out.println("Style            Formatting of zoned date-time");
    int i = 0;
    for (DateTimeFormatter dtf : dtFormatters) {
      try {
        dtf = dtf.withLocale(Locale.US);
        String strZonedDateTime = zonedDateTime.format(dtf);             // (2)

        System.out.printf("%-7s", formatStyles[i++]);
        System.out.printf("%56s%n", strZonedDateTime);
      } catch (DateTimeException dte) {
        dte.printStackTrace();
        return;
      }
    }
    System.out.println();

    System.out.println("Style  Parsing of zoned date-time string"
                                + " to zoned date-time, date-time, date, time");
    i = 0;
    for (DateTimeFormatter dtf : dtFormatters) {
      try {
        dtf = dtf.withLocale(Locale.US);
        String strZonedDateTime = zonedDateTime.format(dtf); // String to parse.
        LocalTime parsedTime = LocalTime.parse(strZonedDateTime, dtf);   // (3)
        LocalDate parsedDate = LocalDate.parse(strZonedDateTime, dtf);   // (4)
        LocalDateTime parsedDateTime
                         = LocalDateTime.parse(strZonedDateTime, dtf);   // (5)
        ZonedDateTime parsedZonedDateTime
                         = ZonedDateTime.parse(strZonedDateTime, dtf);   // (6)

        System.out.printf("%-7s", formatStyles[i++]);
        System.out.printf("%56s|%n%52s|%s|%s%n",
                          parsedZonedDateTime.format(dtf),
                          parsedDateTime, parsedDate, parsedTime);
      } catch (DateTimeParseException pe) {
        pe.printStackTrace();
        return;
      } catch (DateTimeException dte) {
        dte.printStackTrace();
        return;
      }
    }
  }
}