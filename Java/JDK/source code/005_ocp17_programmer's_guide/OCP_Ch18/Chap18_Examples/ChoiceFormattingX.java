import java.util.*;
import java.text.*;

public class ChoiceFormattingX {

  public static void main(String[] args) {
    // Create the choice formats:                                             (1)
    double[] limits = {0,1,2};                                             // (2a)
    String [] grammarFormats = {                                           // (2b)
        "There are no bananas.",
        "There is only one banana",
        "There are {0} bananas"
    };
    ChoiceFormat choiceForm = new ChoiceFormat(limits, grammarFormats);    // (3)

    // Test the formatter with different message arguments:                // (4)
    Object[] messageArguments = { 0, 1, 2, 3};                             // (5)
    for (int choiceNumber = 0;
         choiceNumber < messageArguments.length; choiceNumber++) {         // (6)
      String result = choiceForm.format(messageArguments[choiceNumber]);
      System.out.println(result);
    }
  }
}