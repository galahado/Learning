import java.util.*;
import java.text.*;

public class ChoiceFormattingY {

  static void displayMessages(Locale requestedLocale)  {
    System.out.println("Requested locale: " + requestedLocale);

    // Fetch the resource bundle:                                             (1)
    ResourceBundle bundle =
        ResourceBundle.getBundle("resources.ChoiceBundle", requestedLocale);

    // Create formatter for specified pattern and locale:                     (2)
    MessageFormat mf = new MessageFormat(
        bundle.getString("pattern"),       // pattern = There {0}.
        requestedLocale
        );

    // Create the choice formats:                                             (3)
    double[] limits = {0,1,2};                                             // (3a)
    String [] grammarFormats = {                                           // (3b)
        bundle.getString("none"),       // none = are no bananas
        bundle.getString("singular"),   // singular = is only one banana
        bundle.getString("plural")      // plural = are {1,number,integer} bananas
    };
    ChoiceFormat choiceForm = new ChoiceFormat(limits, grammarFormats);    // (4)

    // Create the formats for the pattern.                                    (5)
    Format[] formats = {choiceForm};

    // Set the formats for the arguments:                                     (6)
    mf.setFormats(formats);
//  messageForm.setFormatsByArgumentIndex(formats);

    // Create the message argument arrays:                                    (7)
    Object[][] messageArguments = { {0}, {1}, {2, 2} };

    // Test the formatter with message arguments:                             (8)
    for (int choiceNumber = 0; choiceNumber < 3; choiceNumber++) {
      String result = mf.format(messageArguments[choiceNumber]);
      System.out.println(result);
    }
  }

  public static void main(String[] args)  throws ParseException {
    displayMessages(new Locale("en", "US"));
    System.out.println();
    displayMessages(new Locale("es", "ES"));
    System.out.println();
  }
}