import java.io.EOFException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NaiveResourceUse {
  public static void main(String[] args)
      throws FileNotFoundException, EOFException, IOException {

    // Open the resource:
    var fis = new FileReader(args[0]);             // (1) FileNotFoundException
    var br = new BufferedReader(fis);

    // Use the resource:
    String textLine = br.readLine();               // (2) IOException
    if (textLine != null) {
      System.out.println(textLine);
    } else {
      throw new EOFException("Empty file.");       // (3) EOFException
    }

    // Close the resource:
    System.out.println("Closing the resource.");
    br.close();                                    // (4) IOException
  }
}