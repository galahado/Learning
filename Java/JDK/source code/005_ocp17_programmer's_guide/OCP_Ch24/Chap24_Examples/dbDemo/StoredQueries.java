package dbDemo;
import static java.lang.System.out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class StoredQueries {

  public static void main(String[] args) {
    final String jdbcURL = "jdbc:derby:musicDB";
    try (Connection connection = DriverManager.getConnection(jdbcURL)) {
      //      storedProc1(connection);
      //      storedProc2(connection);
      //      storedProc3(connection);
      //      storedFunction(connection);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void storedProc1(Connection connection) {

    // "select * from compositions where duration > ?"
    final String storedQuery = "{call findRows(?)}";     // 1: IN
    try (CallableStatement cStmt = connection.prepareCall(storedQuery)) {
      cStmt.setInt(1, 100);
      try(ResultSet resultSet = cStmt.executeQuery()) {         // ???
        while (resultSet.next()) {
          var isrc = resultSet.getString(1);
          var title = resultSet.getObject(2, String.class);
          var duration = resultSet.getInt("duration");
          out.println("[" + isrc + ", " + title + ", " + duration + "]");
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void storedProc2(Connection connection) {

    // "select title from compositions where isrc = ?"
    final String storedQuery = "{call findTitle(?, ?)}";     // 1: IN  2: OUT
    try (CallableStatement cStmt = connection.prepareCall(storedQuery)) {
      String isrc = "ushm91736697";
      cStmt.setString(1, isrc);
      cStmt.registerOutParameter(2, Types.VARCHAR);
      cStmt.execute();
      System.out.println(isrc + " has title " + cStmt.getString(2));
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void storedProc3(Connection connection) {

    // "update compositions set title = ? where title = ?"
    final String callFunc = "{call updateProc(?, ?)}";     // 1:IN 2:IN
    try (CallableStatement cStmt = connection.prepareCall(callFunc)) {
      cStmt.setString(1, "Java Jive");
      cStmt.setString(2, "Rage");
      int updCount = cStmt.executeUpdate();               // ???
      System.out.println("UPDATE: " + updCount);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void storedFunction(Connection connection) {

    // "select count(*) from compositions where duration > ?"
    final String callFunc = "? = {call countFunc(?)}"; // 1:OUT  2: IN

    try (CallableStatement cStmt = connection.prepareCall(callFunc)) {
      cStmt.registerOutParameter(1, Types.INTEGER);
      int duration = 100;
      cStmt.setInt(2, duration);
      cStmt.execute();
      System.out.println("Compositions with duration greater than "
          + duration + ": " + cStmt.getInt(1));
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
