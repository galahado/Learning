package dbDemo;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;

import static java.lang.System.out;

public class ResultSetProcessing {
  public static void main(String[] args) {
    final String jdbcURL = "jdbc:derby:musicDB";
    final String sql = "select * from compositions where duration > ?";    // (1)
    try (var connection = DriverManager.getConnection(jdbcURL);            // (2)
        var pStatement = connection.prepareStatement(sql);) {              // (3)
      pStatement.setInt(1, 0);                                             // (4)
      var resultSet = pStatement.executeQuery();
      try (resultSet) {                                                    // (5)
        while (resultSet.next()) {                                         // (6)
          String isrc = resultSet.getString(1);                            // (7)
          String title = resultSet.getObject(2, String.class);             // (8)
          int duration = resultSet.getInt("duration");                     // (9)
          out.println("[" + isrc + ", " + title + ", " + duration + "]");  // (10)
        }
      } // Closes the result set.
    } catch (SQLException e) {                                             // (11)
      e.printStackTrace();
    } // Closes the prepared statement and the connection.
  }
}