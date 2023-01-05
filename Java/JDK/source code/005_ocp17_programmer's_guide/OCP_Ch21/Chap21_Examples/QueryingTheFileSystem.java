import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueryingTheFileSystem {

  public static void main(String[] args) throws IOException {

    // File exists.
    {
    Path path1 = Path.of("project", "src", "pkg", "Main.java");
    System.out.println(Files.exists(path1));                       // true
    System.out.println(Files.notExists(path1));                    // false

    Path path2 = Path.of("project", "..", "project", ".", "src", "pkg", "Main.java");
    System.out.println(Files.exists(path2));                       // true
    System.out.println(Files.notExists(path2));                    // false

    Path path3 = Path.of("project", "readme.txt");
    System.out.println(Files.exists(path3));                       // false
    System.out.println(Files.notExists(path3));                    // true
//  System.out.println(path1.equals(path2));
//  System.out.println(Files.isSameFile(path2, path2));

    Path target   = Path.of("project", "src", "manifest.txt");
    Path symbLink = Path.of("project", "manifest_alias");

    boolean result4 = Files.exists(target);                               // (1)
    boolean result5 = Files.exists(symbLink);                             // (2)
    boolean result6 = Files.exists(symbLink, LinkOption.NOFOLLOW_LINKS);  // (3)

    System.out.println("target: " + result4);                      // (1a) true
    System.out.println("symbLink->target: " + result5);            // (2a) true
    System.out.println("symbLink_NOFOLLOW_LINKS: " + result6);     // (3a) true
    }
    // Is same file?
    {
Path path1 = Path.of("project", "src", "pkg", "Main.java");
Path path2 = Path.of("project", "..", "project", ".", "src", "pkg", "Main.java");

Path target   = Path.of("project", "src", "manifest.txt");
Path symbLink = Path.of("project", "manifest_alias");

System.out.println(Files.isSameFile(path1, path2));            // (1) true
System.out.println(Files.isSameFile(symbLink, target));        // (2) true
System.out.println(Files.isSameFile(path1, target));           // (3) false
System.out.println(Files.isSameFile(Path.of("Main.java"),
                                    Path.of("Main.java")));    // (4) true
//System.out.println(Files.isSameFile(path1,
//                           Path.of("Main.java")));  // (5) NoSuchFileException

    }

    // Deleting Directory Entries
    {
      Path projDir  = Path.of("project");
      Path target   = Path.of("project", "src", "manifest.txt");
      Path symbLink = Path.of("project", "manifest_alias");
     // The delete() methods throws a NoSuchFileException, if the path does not exist.
      Files.delete(symbLink);                 // Exists. Link deleted, not target.
      Files.delete(Path.of("Main.java"));     // Does not exist: NoSuchFileException
     // The deleteIfExists() method does not throw a NoSuchFileException. It indicates the result by the boolean return value.
      System.out.println(Files.deleteIfExists(target));  // Exists. Deleted: true
      System.out.println(Files.deleteIfExists(Path.of("Main.java"))); // Does not
                                                                      //  exists: false
     // In order to delete a directory, it must be empty. The directory ./project is not empty. Both methods throw a DirectoryNotEmptyException.
      Files.delete(projDir);                             // DirectoryNotEmptyException
      System.out.println(Files.deleteIfExists(projDir)); // DirectoryNotEmptyException
      }
    }
}