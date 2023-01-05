package dbDemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementTest {
  public static void main(String[] args) {
    callExecute();
    callExecute2();
    callExecuteQuery();
    callExecuteUpdate();
  }

  public static void callExecute() {
    final String jdbcURL = "jdbc:derby:musicDB";
    String sql = "select * from compositions where duration > 200";
    try (Connection connection = DriverManager.getConnection(jdbcURL);
        PreparedStatement pStatement = connection.prepareStatement(sql);) { // (1) Prepare statement
      boolean result = pStatement.execute();                                // (2)
      System.out.println(result);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void callExecute2() {
    final String jdbcURL = "jdbc:derby:musicDB";
    String sql = "select * from compositions where duration > ?";
    try (Connection connection = DriverManager.getConnection(jdbcURL);
        PreparedStatement pStatement = connection.prepareStatement(sql);) { // (1) Prepare statement
      pStatement.setInt(1, 200);
      boolean result = pStatement.execute();                                // (2)
      System.out.println(result);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void callExecute3() {
    final String jdbcURL = "jdbc:derby:musicDB";
    final String sql = "select * from compositions where title like ?";
    try (var connection = DriverManager.getConnection(jdbcURL);
        var pStatement = connection.prepareStatement(sql); ) {
      pStatement.setString(1, "%V");
      boolean result = pStatement.execute();
      System.out.println("SELECT statement? " + result);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void callExecuteQuery() {
    final String jdbcURL = "jdbc:derby:musicDB";
    final String sql = "select * from compositions where duration > ?";
    try (var connection = DriverManager.getConnection(jdbcURL);
        var pStatement = connection.prepareStatement(sql);) {
      pStatement.setInt(1, 100);
      try (var resultSet = pStatement.executeQuery();) {
        while (resultSet.next()) {
          String title = resultSet.getString("title");
          System.out.println(title);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void callExecuteUpdate() {
    final String jdbcURL = "jdbc:derby:musicDB";
    final String sql = "update compositions set duration = duration + ?";
    try (var connection = DriverManager.getConnection(jdbcURL);
        var pStatement = connection.prepareStatement(sql);) {
      pStatement.setInt(1,10);
      int count = pStatement.executeUpdate();
      System.out.println("Rows modified: " + count);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}