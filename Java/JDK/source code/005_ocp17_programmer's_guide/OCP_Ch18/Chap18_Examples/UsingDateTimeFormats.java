import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

class UsingDateTimeFormats {
  public static void main(String[] args) {

    // Create some date/time formatters:
    DateFormat[] dtfs = new DateFormat[] {
        DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL,
                                       Locale.US),
        DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
                                       Locale.US),
        DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM,
                                       Locale.US),
        DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT,
                                       Locale.US)
    };
    // Style names:
    String[] styles = { "FULL", "LONG", "MEDIUM", "SHORT" };

    // Format current date/time using different date formatters:
    System.out.println("Formatting date according to locale: " +
        Locale.US.toString());
    System.out.println("Default time zone for date: " +
        TimeZone.getDefault().getDisplayName());
    Date date = new Date();                       // Current time and date.
    int i = 0;
    for (DateFormat dtf : dtfs) {
      System.out.printf("%-6s: %s%n", styles[i++], dtf.format(date));
    }
  }
}