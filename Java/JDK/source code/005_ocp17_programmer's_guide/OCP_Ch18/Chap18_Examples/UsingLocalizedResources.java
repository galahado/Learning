import java.util.Locale;
import java.util.ResourceBundle;
public class UsingLocalizedResources {

  // Create an array of locales:
  // Supported locales:
  public static final Locale[] locales = {
    Locale.getDefault(),                                // Default: US
    new Locale("no", "NO"),                             // Norway
    Locale.FRANCE,                                      // France
    Locale.CANADA_FRENCH                                // Canada (French)
  };

  public static void main(String[] args) {
    for (Locale locale : locales) {
      System.out.println("Supported locale: " + locale.getDisplayName());
      ResourceBundle labels
      = ResourceBundle.getBundle("resources.BasicResources", locale);
      System.out.println("Associated locale: " + labels.getLocale().getDisplayName());
      System.out.println(labels.keySet());

      ResourceBundle resources
      = ResourceBundle.getBundle("resources.AdditionalResources", locale);
      System.out.println("Associated locale: " + resources.getLocale().getDisplayName());
      System.out.println(resources.keySet());
    }

    ResourceBundle labels
    = ResourceBundle.getBundle("resources.NewResources");
    System.out.println("Associated locale: " + labels.getLocale().getDisplayName());
    System.out.println(labels.keySet());
    for (String key : labels.keySet()) {
      System.out.println("|" + labels.getString(key) + "|");
    }
    System.out.println("|" + labels.getString("aha") + "|");
  }
}