package dbDemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicStatementTest {
  public static void main(String[] args) {
    callExecute();
    callExecuteQuery();
    callExecuteUpdate();
    callExecute2();
  }

  public static void callExecute() {
    final String jdbcURL = "jdbc:derby:musicDB";
    try (Connection connection = DriverManager.getConnection(jdbcURL);
         Statement statement = connection.createStatement();) {      // Obtain a Statement object.
      String sql = "select * from compositions";                     // SELECT query: select all rows.
      boolean isSelectStmt = statement.execute(sql);                 // (1) Execute the query
      System.out.println("SELECT statement? " + isSelectStmt);       // (2) SELECT statement? true
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public static void callExecuteQuery() {
    final String jdbcURL = "jdbc:derby:musicDB";
    try (Connection connection = DriverManager.getConnection(jdbcURL);
         Statement statement = connection.createStatement();) {     // Obtain a Statement object.
      String sql = "select * from compositions";                    // SQL query: select all rows.
      ResultSet resultSet = statement.executeQuery(sql);
      try (resultSet) {                                             // (1) Nested try-with-resources
        System.out.println("Processing ResultSet");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void callExecuteUpdate() {
    final String jdbcURL = "jdbc:derby:musicDB";
    try (Connection connection = DriverManager.getConnection(jdbcURL);
        Statement statement = connection.createStatement();) {
      String sql = "update compositions set duration = duration * 2";
      int count = statement.executeUpdate(sql);                     // Number of rows affected.
      System.out.println("Rows modified: " + count);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void callExecute2() {
    final String jdbcURL = "jdbc:derby:musicDB";
    try (Connection connection = DriverManager.getConnection(jdbcURL);
        Statement statement = connection.createStatement();) {      // Obtain a Statement object.
      String sql = "select * from compositions";                    // SQL query
      boolean isSelectStmt = statement.execute(sql);
      if (isSelectStmt) {
        try (ResultSet resultSet = statement.getResultSet();) { // SELECT statement: retrieve ResultSet.
          System.out.println("SELECT statement: processing ResultSet");
        }
      } else {                                                  // Update statement:
        int rowCount = statement.getUpdateCount();              // Retrieve the number of rows affected.
        System.out.println("Update statement: Rows affected " + rowCount);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}