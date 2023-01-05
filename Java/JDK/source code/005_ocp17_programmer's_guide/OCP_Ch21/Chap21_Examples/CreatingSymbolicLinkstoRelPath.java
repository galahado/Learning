import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class CreatingSymbolicLinkstoRelPath {

  public static void main(String[] args) throws IOException {

    // Creating symbolic links to files:
    try {

      Path projDir  = Path.of(".", "project");
      Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxrwxrwx");
      Files.setPosixFilePermissions(projDir, perms);
      System.out.println("After reinstating: "
          + PosixFilePermissions.toString(Files.getPosixFilePermissions(projDir)));

      Path symbLinkPath  = Path.of(".", "project", "readme_link");
      Path targetPath = Path.of(".", "project", "backup", "readme.txt");         // Exists.
      System.out.printf("Symbolic link path: %s%n", symbLinkPath);
      System.out.println(Files.exists(symbLinkPath));
      System.out.printf("Target path: %s%n", targetPath);
      System.out.println(Files.exists(targetPath));

      if (Files.deleteIfExists(symbLinkPath)) {
        System.out.printf("Symbolic link deleted: %s%n", symbLinkPath);
      }
      Path symbLink1 = Files.createSymbolicLink(symbLinkPath, targetPath.toAbsolutePath());   // Absolute path
      Path targetPath1 = Files.readSymbolicLink(symbLink1);
      System.out.println(Files.exists(symbLink1));
      System.out.println(Files.exists(targetPath1));

//    FileUtils.printDirEntryInfo(symbLink1);
      FileUtils.printDirEntryInfo(symbLink1);
      FileUtils.printDirEntryInfo(targetPath1.toRealPath());
      System.out.println();
    } catch (FileAlreadyExistsException fe) {
      fe.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}