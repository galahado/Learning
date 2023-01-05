import java.time.*;
import java.time.format.*;
import java.util.Locale;

public class FormattingWithLocalizedDateTimeFormatter {
  public static void main(String[] args) {
    // Create some date-time formatters:
    DateTimeFormatter[] dtFormatters =                         {     // (1)
        DateTimeFormatter.ISO_LOCAL_DATE_TIME,
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT),
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM),
    };
    String[] formatStyles = {"ISO", "SHORT", "MEDIUM"};

    // Temporal objects:
    LocalTime time = LocalTime.of(14, 15, 30);
    LocalDate date = LocalDate.of(2021, 5, 17);
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime,
        ZoneId.of("US/Central"));

    System.out.println("Locale: " + Locale.FRANCE);
    System.out.println("Style   Formatting of date-time, zoned date-time");
    int i = 0;
    for (DateTimeFormatter dtf : dtFormatters) {
      try {
        dtf = dtf.withLocale(Locale.FRANCE);
        String strDateTime1 = dateTime.format(dtf);                  // (2)
        String strDateTime2 = zonedDateTime.format(dtf);             // (3)
        
        System.out.printf("%-12s", formatStyles[i++]);
        System.out.printf("%25s|%25s%n", strDateTime1, strDateTime2);
      } catch (DateTimeException dte) {
        dte.printStackTrace();
        return;
      }
    }

    System.out.println();
    System.out.println("Style   Parsing of date-time string to "
                    + "date-time, date, time");
    i = 0;
    for (DateTimeFormatter dtf : dtFormatters) {
      try {
        dtf = dtf.withLocale(Locale.FRANCE);
        String strDateTime = dateTime.format(dtf);   // Date-time string to parse.
        LocalTime parsedTime = LocalTime.parse(strDateTime, dtf);        // (4)
        LocalDate parsedDate = LocalDate.parse(strDateTime, dtf);        // (5)
        LocalDateTime parsedDateTime
                         = LocalDateTime.parse(strDateTime, dtf);        // (6)

        System.out.printf("%-12s", formatStyles[i++]);
        System.out.printf("%25s|%11s|%9s%n",
                          parsedDateTime.format(dtf), parsedDate, parsedTime);
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