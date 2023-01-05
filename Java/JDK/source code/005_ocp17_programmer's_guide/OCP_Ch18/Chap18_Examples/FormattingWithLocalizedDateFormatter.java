import java.time.*;
import java.time.format.*;
import java.util.Locale;

public class FormattingWithLocalizedDateFormatter {
  public static void main(String[] args) {
    // Create some date formatters:
    DateTimeFormatter[] dateFormatters =                         {        // (1)
        DateTimeFormatter.ISO_LOCAL_DATE,
        DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT),
        DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM),
        DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG),
        DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
    };
    String[] formatStyles = {"ISO", "SHORT", "MEDIUM", "LONG", "FULL"};

    // Temporal objects:
    LocalTime time = LocalTime.of(14, 15, 30);
    LocalDate date = LocalDate.of(2021, 5, 17);
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime,
                                                   ZoneId.of("US/Central"));

    System.out.println("Locale: " + Locale.GERMANY);
    System.out.println("Style   Formatting of date, date-time, zoned date-time");
    int i = 0;
    for (DateTimeFormatter dtf : dateFormatters) {
      try {
        dtf = dtf.localizedBy(Locale.GERMANY);
        String strDate1 = date.format(dtf);                       // (2)
        String strDate2 = dateTime.format(dtf);                   // (3)
        String strDate3 = zonedDateTime.format(dtf);              // (4)

        System.out.printf("%-6s", formatStyles[i++]);
        System.out.printf("%25s|%25s|%25s%n", strDate1, strDate2, strDate3);
      } catch (DateTimeException dte) {
        dte.printStackTrace();
        return;
      }
    }
    System.out.println();

    System.out.println("Style   Parsing of date string to date");
    i = 0;
    for (DateTimeFormatter dtf : dateFormatters) {
      try {
        dtf = dtf.withLocale(Locale.GERMANY);
        String strDate = date.format(dtf);              // Date string to parse.
        LocalDate parsedDate = LocalDate.parse(strDate, dtf);             // (5)

        System.out.printf("%-6s", formatStyles[i++]);
        System.out.printf("%25s%n", parsedDate.format(dtf));
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