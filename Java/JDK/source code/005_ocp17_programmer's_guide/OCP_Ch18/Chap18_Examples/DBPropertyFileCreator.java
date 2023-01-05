import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyFileCreator {

  public static void main(String[] s) {

    String propFilename = "resources/dbConfig.properties";           // (1)

    try (FileWriter outProps = new FileWriter(propFilename)) {       // (2)
      // Create an empty Properties table.
      Properties dbProps = new Properties();                         // (3)

      // Set properties:                                                (4)
      dbProps.setProperty("db.driver", "com.mysql.jdbc.Driver");
      dbProps.setProperty("db.protocol", "jdbc");
      dbProps.setProperty("db.vendor", "mysql");
      dbProps.setProperty("db.host", "localhost");
      dbProps.setProperty("db.port", "3306");
      dbProps.setProperty("db.name", "salesDB");

      // Store property list from the Properties table to a text file.
      dbProps.store(outProps, "File: " +  propFilename               // (5)
                  + "\nThis is a property list for DB configuration.");

      // List the properties.
      dbProps.list(System.out);                                      // (6)

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}