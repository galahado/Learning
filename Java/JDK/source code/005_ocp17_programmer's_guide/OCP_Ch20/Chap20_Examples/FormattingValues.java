import java.io.*;

public class FormattingValues {
  public static void main(String[] args) throws IOException {
    try(PrintWriter pw = new PrintWriter("formated_values.txt")) {
      pw.printf("Formatted values|%5d|%8.3f|%5s|%n", // Format string
          2018, Math.PI, "Hi");               // Values to format
    }

    try(BufferedReader br = new BufferedReader(new FileReader("formated_values.txt"))) {
      System.out.println(br.readLine());
    }
  }
}