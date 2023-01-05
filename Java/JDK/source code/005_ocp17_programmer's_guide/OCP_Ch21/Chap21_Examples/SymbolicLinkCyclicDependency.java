import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class SymbolicLinkCyclicDependency {

  public static void main(String[] args) throws IOException {

    // Creating symbolic link:
    try {
      Path targetPath = Path.of(".", "a", "b");
      Path symbLinkPath  = Path.of(".", "a", "b", "c", "dir_link");
      Files.deleteIfExists(symbLinkPath);
      Files.createSymbolicLink(symbLinkPath, targetPath.toAbsolutePath());
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    // Walking the directory:
    Path start = Path.of(".", "a");
    final int MAX_DEPTH = 4;
    for (int depth = 0; depth <= MAX_DEPTH; ++depth)  {
      try(Stream<Path> stream = Files.walk(start, depth,
                                           FileVisitOption.FOLLOW_LINKS)) {
        System.out.println("Depth limit: " + depth);
        stream.forEach(System.out::println);
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }

    // Searching for entries:
    for (int depth = 0; depth <= MAX_DEPTH; ++depth)  {
      try(Stream<Path> stream = Files.find(start, depth,
          (p, a) -> true,
          FileVisitOption.FOLLOW_LINKS)) {
        System.out.println("Depth limit: " + depth);
        stream.forEach(System.out::println);
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }
}