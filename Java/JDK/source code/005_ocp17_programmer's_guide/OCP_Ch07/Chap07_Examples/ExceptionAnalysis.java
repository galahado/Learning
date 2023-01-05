import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionAnalysis {
  public static void main(String[] args) throws IOException {
    try {                                // (1)
      throw new FileNotFoundException(); // (2)
    } catch (IOException ex) {           // (3)
      try {                        // (4) Nested try statement
        throw ex;                  // (5) Can only rethrow FileNotFoundException
      } catch (EOFException se) {  // (6) Compile-time error: clause unreachable
        System.out.println("I am unreachable.");
      }
    }
  }
}