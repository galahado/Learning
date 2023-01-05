import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CopyingDirectoryEntries {

  public static void main(String[] args) throws IOException {

    //    Copy and Replace Files
    {
      Path source = Path.of("project", "src", "pkg", "Main.java");               // (1)
      Path parentDestinationPath = Path.of("project", "archive", "src", "pkg");  // (2)
      Path destination = parentDestinationPath.resolve(source.getFileName());    // (3)

      //Files.copy(source, destination); // (4) OK. Destination file does not exist.
      //Files.copy(source, destination,  // (5) OK. Destination file replaced.
      //           StandardCopyOption.REPLACE_EXISTING);
      //Files.copy(source, destination); // (6) FileAlreadyExistsException

    }
    {
      // Copying a directory -- creates an empty directory.
      Path srcDir  = Path.of("project", "src");
      Path destDir = Path.of("project", "backup");
      //    Files.copy(srcDir, destDir);
      //Files.copy(srcDir, destDir, StandardCopyOption.REPLACE_EXISTING);   // (1) DirectoryNotEmptyException.

    }
    {
      //    Copy Files into a Directory
      //      Path srcFile = Path.of("project", "src", "pkg", "Main.java");
      //      Path destDir = Path.of("project", "classes");
      //      Files.copy(srcFile, destDir, StandardCopyOption.REPLACE_EXISTING);
    }

    //  Copy Files using I/O Streams
    {
      //      String inputFileName  = "project/src/pkg/Util.java";
      //      Path outputFilePath = Path.of("project", "backup", "Util.java");
      //      try (var fis = new FileInputStream(inputFileName);
      //           var bis = new BufferedInputStream(fis)) {
      //        long bytesCopied = Files.copy(bis, outputFilePath,
      //                                      StandardCopyOption.REPLACE_EXISTING);
      //        System.out.println("Bytes copied: " + bytesCopied);      // Bytes copied: 103
      //      }

      //      Path inputFilePath  = Path.of("project", "backup", "Util.java");
      //      String outputFileName = "project/archive/src/pkg/Util.java";
      //      try (var fos = new FileOutputStream(outputFileName);
      //           var bos = new BufferedOutputStream(fos)) {
      //        long bytesCopied = Files.copy(inputFilePath, bos);
      //        System.out.println("Bytes copied: " + bytesCopied);      // Bytes copied: 103
      //      }
      //      Files.copy(inputFilePath, System.out);
      //      System.out.println();
    }


    // Rename file
    {
      Path oldFileName  = Path.of("project", "backup", "Util.java");
      Path newFileName  = Path.of("project", "backup", "UX.java");
      Files.move(oldFileName, newFileName);
    }
    // Rename directory
    {
      Path oldDirName  = Path.of("project", "backup");
      Path newDirName  = Path.of("project", "bkup");
      Files.move(oldDirName, newDirName);
    }

    // Move a file
    {
      Path srcFile = Path.of("project", "src", "manifest.txt");
      Path destDir = Path.of("project", "bkup", "manifest.txt");
      Files.move(srcFile, destDir, StandardCopyOption.REPLACE_EXISTING);
    }

    // Move a directory
    {
      Path srcDir = Path.of("project", "bkup");
      Path destDir = Path.of("project", "archive", "backup");
      Files.move(srcDir, destDir);
    }

    // Atomic move
    {
      Path srcFile = Path.of("project", "src", "pkg", "Util.java");
      Path destFile = Path.of("project", "archive", "src", "pkg", "Main2.java");
      Files.move(srcFile, destFile, StandardCopyOption.REPLACE_EXISTING,
          StandardCopyOption.ATOMIC_MOVE);
    }

  }
}