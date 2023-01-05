package dbDemo;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;

public class Transactions {
  public static void main(String[] args) {
    final String jdbcURL = "jdbc:derby:musicDB";
    try (var connection = DriverManager.getConnection(jdbcURL)) {

      // SQL statements:
      final String insSql = "insert into compositions VALUES(?, ?, ?)";
      final String updSql = "update compositions set title = ? where title = ?";
      final String delSql = "delete from compositions where duration = ?";

      // Create statements:
      try (var insStatement = connection.prepareStatement(insSql);
          var updStatement = connection.prepareStatement(updSql);
          var delStatement = connection.prepareStatement(delSql);) {

        connection.setAutoCommit(false);            // (1) Auto-commit disabled.
        insStatement.setInt(3, 150);                // (2) Insert a new row.
        insStatement.setString(2, "Java Jazz");
        insStatement.setString(1, "ushm91736991");
        int insResult = insStatement.executeUpdate();
        System.out.println("INSERT: " + insResult);

        updStatement.setString(1, "Java Jive");     // (3) Update an existing row.
        updStatement.setString(2, "Rage");
        int updResult = updStatement.executeUpdate();
        System.out.println("UPDATE: " + updResult);

        Savepoint savePoint = connection.setSavepoint(); // (4) Set a savepoint.
        delStatement.setInt(1, 178);                     // (5) Delete a row.
        int delResult = delStatement.executeUpdate();
        System.out.println("DELETE: " + delResult);

        connection.rollback(savePoint);   // (6) Roll back to safepoint.
        connection.commit();              // (7) Commits only (2) and (3).
      } catch (SQLException e) {
        connection.rollback();            // (8) Roll back any changes.
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}