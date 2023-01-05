import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MorePreciseRethrow {
  public static void main(String[] args) {                        // (1)
    try {
      checkIt(1);
    } catch (FileNotFoundException fnfe) {
      System.out.println("Check that the file exits.");
    } catch (EOFException eofe) {
      System.out.println("Check the contents of the file.");
    } catch (IOException ioe) { // (2) mandatory with (3a), but compiler warning
                                //     that clause is unreachable with (3b).
      System.out.println("This should never occur.");
    }
  }

  public static void checkIt(int value) throws IOException {      // (3a)
//public static void checkIt(int value)                           // (3b)
//    throws FileNotFoundException, EOFException {
    try {                                                         // (4)
      switch (value) {
        case 1:
          throw new FileNotFoundException("File not found");
        case 2:
          throw new EOFException("End of file");
        default:
          System.out.println("OK");
      }
    } catch (IOException e) {                                      // (5)
      System.out.println(e.getMessage());
      e = new EOFException("End of file");         // (6) not effectively final,
                                                   //     requires (3a).
                                                   //     When commented out,
                                                   //     can use (3b).
      throw e;
    }
  }
}