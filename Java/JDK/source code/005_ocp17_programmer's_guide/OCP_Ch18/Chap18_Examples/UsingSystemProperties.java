import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class UsingSystemProperties {

  public static void main(String[] s) {

    System.out.println("java.vendor" + " = "
                       + System.getProperty("java.vendor"));
    System.out.println("java.version" + " = "
                       + System.getProperty("java.version"));
    System.out.println();

    System.setProperty("java.cert", "OCP");
    System.out.println("java.cert" + " = " + System.getProperty("java.cert"));
    System.out.println();

    // Load System Properties into a Properties table.
    Properties props = System.getProperties();

    System.out.println("java.cert" + " = " + props.getProperty("java.cert"));

    // Print the property list from the Properties table:
    props.list(System.out);
    System.out.println();

    // Print the property list sorted by key from the Properties table:
    props.stringPropertyNames()
    .stream()
    .sorted()
    .forEachOrdered(p -> System.out.println(p + "=" + props.getProperty(p)));
    System.out.println();
  }
}