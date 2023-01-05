import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ReadingWritingTextFiles {

  public static void main(String[] args) throws IOException {
    // List of strings:
    List<String> lines = List.of("Guess who got caught?", "Who?",
                                 "NullPointerException.",
                                 "Seriously?", "No. Finally.");
    // Text file:
    String filename = "project/linesOnly.txt";
    Path path = Path.of(filename);

    // Writing lines using buffered writer:                             (1)
    try (BufferedWriter writer =  Files.newBufferedWriter(path)) {   // (2)
      for(String str : lines) {
        writer.write(str);                  // Write a string.
        writer.newLine();                   // Terminate with a newline.
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    // Read lines using buffered reader:                                (3)
    lines = new ArrayList<>();
    try(BufferedReader reader= Files.newBufferedReader(path)) {      // (4)
      String line = null;
      while ((line = reader.readLine()) != null) {  // EOF when null is returned.
        lines.add(line);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    System.out.printf("Lines read from file \"%s\":%n%s%n", path, lines);

    // Write the list of strings in one operation:
    Files.write(path, lines);                                        // (5)

    // Write the joined lines in one operation:
    String joinedLines = String.join(System.lineSeparator(), lines);
    Files.writeString(path, joinedLines);                            // (6)

    // Read all contents into a String, including line separators:
    String allContent = Files.readString(path);                      // (7)
    System.out.printf("All lines read from file \"%s\":%n%s%n", path, allContent);

    // Read all lines into a list of String:
    lines = Files.readAllLines(path);                                // (8)
    System.out.printf("List of lines read from file \"%s\":%n%s%n", path, lines);
  }
}