/*
 * This class should not be executed, as no stored procedure or function has been
 * implemented on the database side.
 */

package dbDemo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class StoredProceduresAndFunctions {

  public static void main(String[] args) {
    final String jdbcURL = "jdbc:derby:musicDB";
    try (Connection connection = DriverManager.getConnection(jdbcURL)) {
      var spf = new StoredProceduresAndFunctions();
      spf.storedProcedureCall(connection);
      spf.storedFunctionCall(connection);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  /*
   * Both the stored procedure longCompositionsProc and the stored function
   * longCompositionsFunc compute the number of rows whose duration is
   * greater than the duration specified as the lower limit.
   */
  public void storedProcedureCall(Connection connection) {
    final String callProc
        = "{call longCompositionsProc(?, ?)}";             // (1) 1: IN 2:OUT
    try (CallableStatement cStmt = connection.prepareCall(callProc)) { // (2)
      int duration = 100;                                              // (3)
      cStmt.setInt(1, duration);                                       // (4)
      cStmt.registerOutParameter(2, Types.INTEGER);                    // (5)
      cStmt.execute();                                                 // (6)
      int returnedValue = cStmt.getInt(2);                             // (7)
      System.out.println("Compositions with duration greater than "
          + duration + ": " + returnedValue);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void storedFunctionCall(Connection connection) {
    final String callFunc
        = "? = {call longCompositionsFunc(?)}";              // (8) 1:OUT 2:IN
    try (CallableStatement cStmt = connection.prepareCall(callFunc)) {
      cStmt.registerOutParameter(1, Types.INTEGER);                     // (9)
      int duration = 100;
      cStmt.setInt(2, duration);                                        // (10)
      cStmt.execute();
      int returnedValue = cStmt.getInt(1);                              // (11)
      System.out.println("Compositions with duration greater than "
          + duration + ": " + returnedValue);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
