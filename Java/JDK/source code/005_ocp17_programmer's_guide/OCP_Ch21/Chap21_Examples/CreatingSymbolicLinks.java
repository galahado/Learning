import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class CreatingSymbolicLinks {

  public static void main(String[] args) throws IOException {

    // Creating symbolic links to files:
    try {
      Path symbLinkPath  = Path.of(".", "readme_link");                     // (1)
      Path targetPath    = Path.of(".", "project", "backup", "readme.txt"); // (2)

      if (Files.deleteIfExists(symbLinkPath)) {
        System.out.printf("Symbolic link deleted: %s%n", symbLinkPath);
      }

      Path symbLink = Files.createSymbolicLink(symbLinkPath, targetPath);   // (3a)
      //Path symbLink = Files.createSymbolicLink(symbLinkPath,
      //                                         targetPath.toAbsolutePath());// (3b)
      Path target = Files.readSymbolicLink(symbLink);                       // (4)

      FileUtils.printDirEntryInfo(symbLink);
      FileUtils.printDirEntryInfo(target);
    } catch (FileAlreadyExistsException fe) {
      fe.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    // lrwxr-xr-x   1 khalid  admin    24 Jul 27 15:09 manifest_alias -> project/src/manifest.txt
    //    Path symbLinkPath2  = Path.of("project", "readme_alias");
    //    Path target2        = Path.of("project", "archive", "readme.txt");  // Exists.
    //
    //    if (Files.deleteIfExists(symbLinkPath2)) {
    //      System.out.printf("Symbolic link deleted: %s%n", symbLinkPath2);
    //    }
    //    Path symbLink2 = Files.createSymbolicLink(symbLinkPath2, target2);                    // Relative path
    //    Path readPath2 = Files.readSymbolicLink(symbLink2);
    //    System.out.println(symbLink2);
    //    System.out.println(readPath2);
    //    FileUtils.printDirEntryInfo(symbLink2);
    //    FileUtils.printDirEntryInfo(readPath2);

    // Creating symbolic links to directories.
    //   try {
    //      Path symbLinkDir  = Path.of("project", "src_alias");
    //      Path targetDir = Path.of("project", "archive", "src");
    //      if (Files.deleteIfExists(symbLinkDir)) {
    //        System.out.printf("Symbolic link deleted: %s%n", symbLinkDir);
    //      }
    //      Path symbLinktoDir = Files.createSymbolicLink(symbLinkDir, targetDir.toAbsolutePath());
    //      Path symbLinktoDir = Files.createSymbolicLink(symbLinkDir, targetDir);
    //      Path readPathtoDir = Files.readSymbolicLink(symbLinktoDir);
    //      FileUtils.printDirEntryInfo(symbLinktoDir.toAbsolutePath());
    //      FileUtils.printDirEntryInfo(readPathtoDir.toAbsolutePath());
    //    } catch (FileAlreadyExistsException fe) {
    //      fe.printStackTrace();
    //    } catch (IOException ioe) {
    //      ioe.printStackTrace();
    //    }
  }
}