import java.io.*;
import java.nio.file.*;

public class ReadingWritingBytes {
  public static void main(String[] args) {
    // Source and destination files:
    Path srcPath  = Path.of("project", "source.dat");
    Path destPath = Path.of("project", "destination.dat");

    try (InputStream is = Files.newInputStream(srcPath);                    // (1)
         OutputStream os = Files.newOutputStream(destPath))  {
      byte[] buffer = new byte[1024];
      int length = 0;
      while((length = is.read(buffer, 0, buffer.length)) != -1) {
        os.write(buffer, 0, length);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    try {
      // Reads the file contents into an array of bytes:
      byte[] allBytes = Files.readAllBytes(srcPath);                        // (2)

      // Writes an array of bytes to a file:
      Files.write(destPath, allBytes);                                      // (3)
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}