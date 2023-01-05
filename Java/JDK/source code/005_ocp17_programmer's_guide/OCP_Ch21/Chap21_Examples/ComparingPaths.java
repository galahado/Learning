import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComparingPaths {

  public static void main(String[] args) {
    Path p1 = Path.of("/", "a", "b", "c", "d");
    Path p2 = Path.of("/", "a", "b");
    Path p3 = Path.of("/", "a", "b", "c");
    Path p4 = Path.of("a", "b");

    // Sorting paths according to natural order:
    List<Path> sortedPaths = Stream.of(p1, p2, p3, p4)
        .sorted()
        .toList();
    System.out.println(sortedPaths);
    // [/book/chap01, /book/chap01/examples, /book/chap01/examples/Demo.java, book/chap01]


    // Comparing for lexicographical equality:
    System.out.println(p2);                         // Absolute path: /book/chap01
    System.out.println(p3.subpath(0, 2));           // Relative path: book/chap01
    System.out.println(p2.equals(p3.subpath(0, 2)));// false

  }
}