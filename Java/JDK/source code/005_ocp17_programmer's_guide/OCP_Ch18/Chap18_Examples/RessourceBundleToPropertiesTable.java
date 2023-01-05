import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class RessourceBundleToPropertiesTable {

  public static void main(String[] s) {
    ResourceBundle resBundle =
        ResourceBundle.getBundle("resources.BasicResources", Locale.FRANCE); // (1)
    Properties propTable =  new Properties();                                // (2)
    resBundle.keySet()                                                       // (3)
             .stream()
             .forEach(key -> propTable.setProperty(key, resBundle.getString(key)));
    propTable.list(System.out);                                              // (4)
  }
}