package dbDemo;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PreparedStatementExecuteUpdate2 {
  public static void main(String[] args) {

    final var jdbcURL = "jdbc:derby:musicDB";
    try (var connection = DriverManager.getConnection(jdbcURL)) {

      var insSql = "insert into compositions VALUES(?, ?, ?)";          // (1)
      try (var pStatement = connection.prepareStatement(insSql)) {      // (2)
        pStatement.setInt(3, 150);
        pStatement.setString(2, "Java Jazz");
        pStatement.setString(1, "ushm91736999");
        int result = pStatement.executeUpdate();
        System.out.println(result);
      }

      var updSql = "update compositions set title = ? where title = ?"; // (3)
      try (var pStatement = connection.prepareStatement(updSql)) {      // (4)
        pStatement.setString(1, "Java Jive");
        pStatement.setString(2, "Java Jazz");
        int result = pStatement.executeUpdate();
        System.out.println(result);
      }

      var delSql = "delete from compositions where duration = ?";       // (5)
      try (var pStatement = connection.prepareStatement(delSql)) {      // (6)
        pStatement.setInt(1, 200);
        int result = pStatement.executeUpdate();
        System.out.println(result);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}