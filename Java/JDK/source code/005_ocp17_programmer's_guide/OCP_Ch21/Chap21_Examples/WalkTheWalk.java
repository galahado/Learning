import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class WalkTheWalk {

  public static void main(String[] args) throws IOException {

    // Creating symbolic link.                                        // (1)
    try {
      Path targetPath = Path.of(".", "a", "b");
      Path symbLinkPath  = Path.of(".", "a", "b", "c", "dir_link");
      if (Files.notExists(symbLinkPath, LinkOption.NOFOLLOW_LINKS)) {
        Files.createSymbolicLink(symbLinkPath, targetPath.toAbsolutePath());
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
      return;
    }

    // Do the walk.                                                    // (2)
    Path start = Path.of(".", "a");
    int MAX_DEPTH = 4;
    for (int depth = 0; depth <= MAX_DEPTH; ++depth)  {                // (3)
      try(Stream<Path> stream = Files.walk(start, depth,               // (4)
                                           FileVisitOption.FOLLOW_LINKS)) {
        System.out.println("Depth limit: " + depth);
        stream.forEach(System.out::println);
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }
}