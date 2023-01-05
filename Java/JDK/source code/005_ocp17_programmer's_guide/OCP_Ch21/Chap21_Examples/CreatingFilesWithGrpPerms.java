import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.EnumSet;
import java.util.Set;

public class CreatingFilesWithGrpPerms {

  public static void main(String[] args) {

    try {
      Path path = Path.of("./event.log");

      if (Files.deleteIfExists(path)) {
        System.out.printf("File deleted: %s%n", path);
      }
      //      Set<PosixFilePermission> perms = EnumSet.of(
      //          PosixFilePermission.OWNER_READ,
      //          PosixFilePermission.OWNER_WRITE,
      //          PosixFilePermission.OWNER_EXECUTE,
      //          PosixFilePermission.GROUP_READ,
      //          PosixFilePermission.GROUP_WRITE,
      //          PosixFilePermission.GROUP_EXECUTE,
      //          PosixFilePermission.OTHERS_READ,
      //          PosixFilePermission.OTHERS_WRITE,
      //          PosixFilePermission.OTHERS_EXECUTE
      //          );

      Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxrwxrwx");
      Path createdFile = Files.createFile(path,
          PosixFilePermissions.asFileAttribute(perms));
      System.out.printf("File created: %s%n", createdFile);
      System.out.println("After creation:    "
          + PosixFilePermissions.toString(Files.getPosixFilePermissions(path)));
      Files.setPosixFilePermissions(createdFile, perms);
      System.out.println("After reinstating: "
          + PosixFilePermissions.toString(Files.getPosixFilePermissions(path)));
    } catch (FileAlreadyExistsException faee) {
      faee.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}