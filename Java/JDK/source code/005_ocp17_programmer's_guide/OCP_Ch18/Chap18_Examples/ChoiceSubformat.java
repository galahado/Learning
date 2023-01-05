import java.util.*;
import java.text.*;

public class ChoiceSubformat {

  static void displayMessages(Locale requestedLocale) {
    System.out.println("Requested Locale: " + requestedLocale);

    // Fetch the resource bundle:                                             (1)
    ResourceBundle bundle =
        ResourceBundle.getBundle("resources.ChoiceBundle", requestedLocale);

    // Create formatter for specified pattern and locale:                     (2)
    MessageFormat messageForm = new MessageFormat(
        bundle.getString("pattern"),       // pattern = There {0}.
        requestedLocale
        );

    // Create the choice formats based on the choice pattern:                 (3)
    // choice.pattern
    //     = "0#are no bananas|1#is only one banana|2<are {1} bananas"
    ChoiceFormat choiceForm
        = new ChoiceFormat(bundle.getString("choice.pattern"));            // (4)

    // Create the formats for the pattern.                                    (5)
    Format[] formats = {choiceForm, NumberFormat.getInstance(requestedLocale)};

    // Set the formats for the arguments:                                     (6)
    messageForm.setFormats(formats);

//  MessageFormat messageForm = new MessageFormat("");
//  messageForm.setLocale(requestedLocale);
//  messageForm.applyPattern(pattern);
//  messageForm.setFormats(formats);

    // Test the formatter with different message arguments:                   (7)
    Object[][] messageArguments = { {0.5}, {1.5}, {2.5, 2} };
    for (int choiceNumber = 0; choiceNumber < 3; choiceNumber++) {
      String result = messageForm.format(messageArguments[choiceNumber]);
      System.out.println(result);
    }
  }

  public static void main(String[] args) {
    displayMessages(new Locale("en", "US"));
    System.out.println();
    displayMessages(new Locale("es", "ES"));
    System.out.println();
    displayMessages(new Locale("fr", "FR"));
    System.out.println();
    displayMessages(new Locale("no", "NO"));
  }
}