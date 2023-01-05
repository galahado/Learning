import java.io.*;

public class TextFileStreams {
  public static void main(String[] args)
      throws FileNotFoundException, IOException {
    if (args.length != 1) {
      System.out.println("No text file specified.");
      return;
    }
    String filename = args[0];
    try(FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader)) {
      int maxLen = bufferedReader
          .lines()
          .mapToInt(String::length)
          .max()
          .orElse(0);
      System.out.println("Length of longest line: " + maxLen);
    }
  }
}