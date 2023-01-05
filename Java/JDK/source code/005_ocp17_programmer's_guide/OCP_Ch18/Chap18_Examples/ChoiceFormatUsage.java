import java.text.*;
import java.util.*;

public class ChoiceFormatUsage {

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

    // Create the limits and the formats arrays:                              (3)
    double[] limits = {0,1,2};                                             // (3a)
    String [] grammarFormats = {                                           // (3b)
        bundle.getString("none"),       // none = are no bananas
        bundle.getString("singular"),   // singular = is only one banana
        bundle.getString("plural")      // plural = are {1,number,integer} bananas
    };

    // Create the choice format:                                              (4)
    ChoiceFormat choiceForm = new ChoiceFormat(limits, grammarFormats);

    // Create the formats:                                                    (5)
    Format[] formats = {choiceForm};

    // Set the formats in the formatter:                                      (6)
    mf.setFormats(formats);                                                // (6a)
//  messageForm.setFormatsByArgumentIndex(formats);                        // (6b)
//  mf.setFormat(0, choiceForm);                                           // (6c)

    // Create the arguments arrays:                                           (7)
    Object[][] messageArguments = { {0.5}, {1.5}, {2.5, 2} };

    // Test the formatter with arguments:                                     (8)
    for (int choiceNumber = 0;
         choiceNumber < messageArguments.length; choiceNumber++) {
      String result = mf.format(messageArguments[choiceNumber]);           // (9)
      System.out.printf("Arguments:%-10sResult: %s%n",
          Arrays.toString(messageArguments[choiceNumber]),result);    }
  }

  public static void main(String[] args)   {
    displayMessages(new Locale("en", "US"));
    System.out.println();
    displayMessages(new Locale("es", "ES"));
  }
}