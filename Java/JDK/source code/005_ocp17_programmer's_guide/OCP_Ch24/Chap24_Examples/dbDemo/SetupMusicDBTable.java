package dbDemo;
import static java.lang.System.out;

import java.sql.*;

public class SetupMusicDBTable {
  public static void main(String[] args) throws SQLException {
//    createTable();
//    deleteAllRows();
    insertRows();
    selectAll();
  }

  public static void createTable() throws SQLException {
    final String jdbcURL = "jdbc:derby:musicDB";
    try (Connection connection = DriverManager.getConnection(jdbcURL);
        var createTable = connection.createStatement(); ) {
      var createTableQuery = "create table compositions ("
          + "isrc varchar(12) PRIMARY KEY, "
          + "title varchar(40) not null, "
          + "duration int not null"
          + ")";
      createTable.executeUpdate(createTableQuery);
    }
  }

  public static void insertRows() throws SQLException {
    final String jdbcURL = "jdbc:derby:musicDB";
    final var insertQuery = "insert into compositions values (?, ?, ?)";
    try (Connection connection = DriverManager.getConnection(jdbcURL);
        var insertComposition = connection.prepareStatement(insertQuery); ) {
      insertComposition.setString(1, "ushm91736697");
      insertComposition.setString(2, "Vacation");
      insertComposition.setInt(3, 231);
      insertComposition.executeUpdate();
      insertComposition.setString(1, "ushm91736698");
      insertComposition.setString(2, "Rage");
      insertComposition.setInt(3, 308);
      insertComposition.executeUpdate();
      insertComposition.setString(1, "ushm91736699");
      insertComposition.setString(2, "Why Don't");
      insertComposition.setInt(3, 178);
      insertComposition.executeUpdate();
      insertComposition.close();
    }
  }

  public static void deleteAllRows() {
    final var delSql = "delete from compositions";

    final var jdbcURL = "jdbc:derby:musicDB";
    try (var connection = DriverManager.getConnection(jdbcURL);
        var pStatement3 = connection.prepareStatement(delSql)) {
      var result3 = pStatement3.executeUpdate();
      System.out.println(result3);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void selectAll() {
    final var jdbcURL = "jdbc:derby:musicDB";
    final var sql = "select * from compositions";                          // (1)
    try (var connection = DriverManager.getConnection(jdbcURL);            // (2)
        var pStatement = connection.prepareStatement(sql);                 // (3)
        var resultSet = pStatement.executeQuery();) {                      // (5)
      while (resultSet.next()) {                                           // (6)
        var isrc = resultSet.getString(1);                                 // (7)
        var title = resultSet.getObject(2, String.class);                  // (8)
        var duration = resultSet.getInt("duration");                       // (9)
        out.println("[" + isrc + ", " + title + ", " + duration + "]");    // (10)
      }
    } catch (SQLException e) {                                             // (11)
      e.printStackTrace();
    }
  }
}