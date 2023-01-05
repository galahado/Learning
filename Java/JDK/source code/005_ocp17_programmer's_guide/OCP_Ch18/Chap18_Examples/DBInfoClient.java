import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class DBInfoClient {

  public static void main(String[] s) {

    String propFilename = "resources/dbConfig.properties";           // (1)

    try (FileReader inProps = new FileReader(propFilename)) {        // (2)
      // Create an empty Properties table.
      Properties dbProps = new Properties();                         // (3)

      // Load the property list from the text file into the Properties table.
      dbProps.load(inProps);                                         // (4)

      // Get some properties:                                           (5)
      System.out.println("Some properties from the Properties table:");
      System.out.println("db.name" + " = "
                         + dbProps.getProperty("db.name"));
      System.out.println("db.vendor" + " = "
                         + dbProps.getProperty("db.vendor"));
      System.out.println("java.mascot" + " = "                       // (6)
                         + dbProps.getProperty("java.mascot", "The Duke"));
      System.out.println();

      // Put new property in the Properties table.
      dbProps.setProperty("java.mascot", "The Duke");                // (7)

      // Print the property list loaded from the property file:
      System.out.println("All properties loaded from the "
                         + propFilename + " file:");
      dbProps.stringPropertyNames()                                  // (8)
           .stream()
           .sorted()
           .forEachOrdered(p -> System.out.println(p + " = "
                                                   + dbProps.getProperty(p)));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}