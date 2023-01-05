import static java.lang.System.out;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Stream;

public class FileUtils {

  public static void printBasicFileAttributes(BasicFileAttributes bfa) {
    out.println("Printing basic file attributes:");
    out.println("lastModifiedTime: " + bfa.lastModifiedTime());
    out.println("lastAccessTime:   " + bfa.lastAccessTime());
    out.println("creationTime:     " + bfa.creationTime());

    out.println("size:             " + bfa.size());
    out.println("isDirectory:      " + bfa.isDirectory());
    out.println("isRegularFile:    " + bfa.isRegularFile());
    out.println("isSymbolicLink:   " + bfa.isSymbolicLink());
    out.println("isOther:          " + bfa.isOther());
    out.println();
  }

  public static void printPosixFileAttributes(PosixFileAttributes pfa) {
    out.println("Printing POSIX-specific file attributes:");
    UserPrincipal user = pfa.owner();
    GroupPrincipal group = pfa.group();
    Set<PosixFilePermission> permissions = pfa.permissions();
    String perms = PosixFilePermissions.toString(permissions);

    out.println("owner:            " + user);
    out.println("group:            " + group);
    out.println("permissions:      " + perms);
    out.println();
  }

  public static void printDirEntryInfo(Path path) {
    try {
    String fmt = Files.isSymbolicLink(path)? "Symbolic link: %s%n":
        Files.isRegularFile(path)? "File: %s%n":
          Files.isDirectory(path)? "Directory: %s%n":
            "Directory entry: %s%n";
    out.printf(fmt, path);
    Set<PosixFilePermission> perms = Files.getPosixFilePermissions(path);
    String permStr = PosixFilePermissions.toString(perms);
    out.println(permStr);
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
  }

  /**
   * Copy an entire directory.
   * @param sourceDir        Directory to copy.
   * @param destinationDir   Directory to which the source directory is copied.
   * @param options          Copy options for all entries.
   */
  public static void copyEntireDirectory(Path sourceDir,
                                         Path destinationDir,
                                         CopyOption... options)  {
    try (Stream<Path> stream = Files.walk(sourceDir)) {                    // (1)
      stream.forEach(entry -> {
        Path relativeEntryPath = sourceDir.relativize(entry);              // (2)
        Path destination  = destinationDir.resolve(relativeEntryPath);     // (3)
  //      System.out.printf("source: %s%n", source);
  //      System.out.printf("relativeSourcePath: %s%n", relativeSourcePath);
  //      System.out.printf("destination: %s%n", destination);
        try {
          Files.copy(entry, destination, options);                         // (4)
        } catch (DirectoryNotEmptyException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void deleteEntireDirectory(Path dir) {
    try (Stream<Path> stream = Files.walk(dir)) {
      stream.sorted(Comparator.reverseOrder())
            .forEach(path -> {
//            System.out.printf("Deleting: %s%n", path);
              try {
                Files.delete(path);
              } catch (IOException e) {
                e.printStackTrace();
              }
            });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}