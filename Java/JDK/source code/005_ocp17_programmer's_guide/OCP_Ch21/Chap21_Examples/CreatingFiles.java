import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class CreatingFiles {

  public static void main(String[] args) {


    Set<PosixFilePermission> fPerms = PosixFilePermissions.fromString("rw-r--r--");
    FileAttribute<Set<PosixFilePermission>> fileAttr =
        PosixFilePermissions.asFileAttribute(fPerms);

    // Creating regular files.
    try {
      Path regularFile  = Path.of("project", "docs", "readme.txt");

      if (Files.deleteIfExists(regularFile)) {
        System.out.printf("File deleted: %s%n", regularFile);
      }
      Path createdFile1 = Files.createFile(regularFile, fileAttr);
      FileUtils.printDirEntryInfo(createdFile1);

      if (Files.deleteIfExists(regularFile)) {
        System.out.printf("File deleted: %s%n", regularFile);
      }
      Path createdFile2 = Files.createFile(regularFile);
      FileUtils.printDirEntryInfo(createdFile2);
    } catch (NoSuchFileException | FileAlreadyExistsException fe) {
      fe.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    // Creating temporary files.
    try {
      // Property that defines the default temporary-file directory.             (1)
      String tmpdir = System.getProperty("java.io.tmpdir");
      System.out.println("Default temporary directory: " + tmpdir);

      // Create under the default temporary-file directory.                      (2)
      Path tmpFile1 = Files.createTempFile("events", ".log");
      FileUtils.printDirEntryInfo(tmpFile1);

      // Create under a specific directory:                                      (3)
      Path tmpFileDir = Path.of("project");
      Path tmpFile2 = Files.createTempFile(tmpFileDir, "proj_", ".dat", fileAttr);
      Path tmpFile3 = Files.createTempFile(tmpFileDir, "proj_", null,   fileAttr);
      Path tmpFile4 = Files.createTempFile(tmpFileDir, null,    ".dat", fileAttr);
      Path tmpFile5 = Files.createTempFile(tmpFileDir, null,    null,   fileAttr);
      FileUtils.printDirEntryInfo(tmpFile2);
      FileUtils.printDirEntryInfo(tmpFile3);
      FileUtils.printDirEntryInfo(tmpFile4);
      FileUtils.printDirEntryInfo(tmpFile5);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}