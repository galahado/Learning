package dbDemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {
  public static void main(String[] args) {

    final String jdbcURL = "jdbc:derby:musicDB";
    try (Connection connection = DriverManager.getConnection(jdbcURL)) {
      /* use the connection. */
      System.out.println(connection);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void testConnection() {

    String jdbcURL = "jdbc:derby:localhost:1521:musicDB";
    String username = "joe";
    String password = "welcome1";
    try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
      /* use the connection. */
      System.out.println(connection);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void connectToMusicDB() {
    //final String jdbcURL = "jdbc:derby:"
    //   + "/Volumes/Local/mySvns/pgj8ocp/trunk"
    //   + "/JavaSE17_OCP_Book_2022/OCP_Ch24/Chap24_Examples/musicDB";

    final String jdbcURL = "jdbc:derby:musicDB";
    try (Connection connection = DriverManager.getConnection(jdbcURL)) {
      /* use the connection. */
      System.out.println(connection);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}