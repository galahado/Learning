import java.util.*;
import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class CompoundMessageFormattingWithDedicatedFormatters {

  static  void displayItemInfo(Locale requestedLocale) {
    System.out.println("Requested Locale: " + requestedLocale);

    ResourceBundle bundle =
        ResourceBundle.getBundle("resources.StockInfoBundle",requestedLocale);

    // Create a formatter, given the pattern and the locale:                 (2)
    MessageFormat formatter = new MessageFormat(bundle.getString("pattern"),
                                                requestedLocale);

    // Argument values:                                                      (3)
    String itemName = bundle.getString("item.name");
    double itemPrice = Double.parseDouble(bundle.getString("item.price"));
    int numOfItems = 5;
    LocalTime localTime = LocalTime.of(14,30);
    LocalDate localDate = LocalDate.of(2021,3,1);

    // Create argument array:                                                (4)
    Object[] messageArguments = {
        itemName,       // {0}
        itemPrice,      // {1,number,currency}
        numOfItems,     // {2,number,integer}
        localTime,      // {3,time,short}                                 // (5)
        localDate,      // {4,date,long}                                  // (6)
    };

    // Create the format for the LocalTime object:                           (7)
    DateTimeFormatter tf = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
                                            .withLocale(requestedLocale);
    Format tfmt = tf.toFormat();

    // Create the format for the LocalDate object:                           (8)
    DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
                                            .withLocale(requestedLocale);
    Format dfmt = df.toFormat();

//    Format[] formats = {tfmt, dfmt, null, NumberFormat.getCurrencyInstance(),
//                NumberFormat.getInstance()};
//    formatter.setFormats(formats);

    // Create the array with local-sensitive formats for the format elements:(9)
    Format[] formats = {null, NumberFormat.getCurrencyInstance(requestedLocale),
                       NumberFormat.getInstance(requestedLocale), tfmt, dfmt};

    // Set the formats in the formatter:                                     (10)
    formatter.setFormatsByArgumentIndex(formats);

    // Format the arguments:                                                 (11)
    String output = formatter.format(messageArguments);
    System.out.println(output);
  }

  public static void main(String[] args) {
    displayItemInfo(new Locale("en", "US"));
    System.out.println();
    displayItemInfo(new Locale("es", "ES"));
    System.out.println();
    displayItemInfo(new Locale("fr", "FR"));
    System.out.println();
    displayItemInfo(new Locale("no", "NO"));
  }
}