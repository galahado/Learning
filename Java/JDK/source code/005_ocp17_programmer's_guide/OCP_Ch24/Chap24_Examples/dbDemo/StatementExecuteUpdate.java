package dbDemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StatementExecuteUpdate {
  public static void main(String[] args) {

    final String jdbcURL = "jdbc:derby:musicDB";
    try (Connection connection = DriverManager.getConnection(jdbcURL);
        var statement = connection.createStatement()) {

      var insSql = "INSERT INTO compositions VALUES('ushm91736800', 'Unplugged', 300)";
      var updSql = "UPDATE compositions SET title = 'Jazz' WHERE title = 'Java Jazz'";
      var delSql = "DELETE FROM compositions WHERE duration = 50";

      int result = statement.executeUpdate(insSql);
      System.out.println(result);

      result = statement.executeUpdate(updSql);
      System.out.println(result);

      result = statement.executeUpdate(delSql);
      System.out.println(result);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}