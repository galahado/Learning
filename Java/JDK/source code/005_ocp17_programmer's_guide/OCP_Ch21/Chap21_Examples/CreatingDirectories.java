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

public class CreatingDirectories {

  public static void main(String[] args) {

    Set<PosixFilePermission> dPerms = PosixFilePermissions.fromString("rwxrwxrwx");
    FileAttribute<Set<PosixFilePermission>> dirFileAttr =
        PosixFilePermissions.asFileAttribute(dPerms);

    //Creating regular directories.
    try {
      Path regularDir  = Path.of("project", "bin");

      if (Files.deleteIfExists(regularDir)) {
        System.out.printf("Directory deleted: %s%n", regularDir);
      }

      Path createdDir = Files.createDirectory(regularDir);                    // (1)
      FileUtils.printDirEntryInfo(createdDir);

      if (Files.deleteIfExists(regularDir)) {                                 // (2)
        System.out.printf("Directory deleted: %s%n", regularDir);
      }
      Path newDir = Files.createDirectory(regularDir, dirFileAttr);           // (3)
      FileUtils.printDirEntryInfo(newDir);

      Files.setPosixFilePermissions(newDir, dPerms);                          // (4)
      FileUtils.printDirEntryInfo(newDir);
    } catch (NoSuchFileException | FileAlreadyExistsException fe) {
      fe.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    try {
      Path regularDir2  = Path.of("project", "branches", "maintenance", "versions");
      Path createdDir2 = Files.createDirectories(regularDir2, dirFileAttr);  // (5)
      FileUtils.printDirEntryInfo(createdDir2);
    } catch (FileAlreadyExistsException fe) {                                // (6)
      fe.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    // Creating temporary directories.
    try  {
      // Create under the default temporary-file directory.                     (7)
      Path tmpDirPath1 = Files.createTempDirectory("log_dir", dirFileAttr);
      FileUtils.printDirEntryInfo(tmpDirPath1);

      // Create under a specific location:                                      (8)
      Path tmpDirLoc = Path.of("project");
      Path tmpDirPath2 = Files.createTempDirectory(tmpDirLoc, "log_dir", dirFileAttr);
      Path tmpDirPath3 = Files.createTempDirectory(tmpDirLoc, null, dirFileAttr);
      FileUtils.printDirEntryInfo(tmpDirPath2);
      FileUtils.printDirEntryInfo(tmpDirPath3);

      Files.setPosixFilePermissions(tmpDirPath3, dPerms);                    // (9)
      FileUtils.printDirEntryInfo(tmpDirPath3);
    } catch (NoSuchFileException nsfe) {
      nsfe.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

  }
}