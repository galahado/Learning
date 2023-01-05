import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertingPaths {

  public static void main(String[] args)  throws IOException {
    Path absPath1 = Path.of("/a/b");
    Path relPath1 = Path.of("d");
    Path absPath2 = Path.of("/c");
    Path relPath2 = Path.of("e/f");

    Path relPath = Path.of(".", "..");

    //  Converting a Path to an Absolute Path

    System.out.printf("%s is an absolute path: %s%n", absPath1, absPath1.isAbsolute());
    System.out.printf("%s is an absolute path: %s%n", relPath1, relPath1.isAbsolute());
    System.out.printf("%s converted to an absolute path: %s%n", absPath1, absPath1.toAbsolutePath());
    System.out.printf("%s converted to an absolute path: %s%n", relPath1, relPath1.toAbsolutePath());
    System.out.println();

    System.out.printf("%s is an absolute path: %s%n", absPath1, absPath1.isAbsolute());
    System.out.printf("%s is an absolute path: %s%n", relPath1, relPath1.isAbsolute());
    System.out.printf("%s converted to an absolute path: %s%n", absPath1, absPath1.toAbsolutePath());
    System.out.printf("%s converted to an absolute path: %s%n", relPath1, relPath1.toAbsolutePath());
    System.out.println(relPath.toAbsolutePath());
    System.out.println();

    //  Normalizing a Path

    Path rp1 = Path.of("./a/.././a/b");
    Path rp2 = Path.of("../.././a/b");

    System.out.printf("%s normalized to path: %s%n", rp1, rp1.normalize());
    System.out.printf("%s normalized to path: %s%n", rp2, rp2.normalize());

    Path path1 = Path.of("./a/./b/c/.");
    Path path2 = Path.of("a/../b");
    Path path3 = Path.of("../../d");
    Path path4 = Path.of("../f");
    Path path5 = Path.of("./../../.");
    Path path6 = Path.of(".");
    Path path7 = Path.of("..");
    System.out.println(path1.normalize());
    System.out.println(path2.normalize());
    System.out.println(path3.normalize());
    System.out.println(path4.normalize());
    System.out.println(path5.normalize());
    System.out.println(path6.normalize());
    System.out.println(path7.normalize());

    System.out.println();


    //  Resolving Two Paths
    System.out.printf("%s is resolved with %s: %s%n", absPath1, absPath2, absPath1.resolve(absPath2));
    System.out.printf("%s is resolved with %s: %s%n", absPath1, relPath2, absPath1.resolve(relPath2));
    System.out.printf("%s is resolved with %s: %s%n", relPath1, absPath2, relPath1.resolve(absPath2));
    System.out.printf("%s is resolved with %s: %s%n", relPath1, relPath2, relPath1.resolve(relPath2));
    Path anyPath = Path.of("/a/n/y");
    Path emptyPath = Path.of("");
    System.out.println(anyPath.resolve(emptyPath));       // a/n/y
    System.out.println();

    //  Constructing a Relative Path between Two Paths
    System.out.printf("%s is relativized to %s: %s%n", absPath1, absPath2, absPath1.relativize(absPath2));
    //  System.out.printf("%s is relativized to %s: %s%n", absPath1, relPath2, absPath1.relativize(relPath2));
    //  System.out.printf("%s is relativized to %s: %s%n", relPath1, absPath2, relPath1.relativize(absPath2));
    System.out.printf("%s is relativized to %s: %s%n", relPath1, relPath2, relPath1.relativize(relPath2));
    System.out.println("----");

    System.out.printf("%s is relativized to %s: %s%n", absPath2, absPath1, absPath2.relativize(absPath1));
    System.out.printf("%s is relativized to %s: %s%n", relPath2, relPath1, relPath2.relativize(relPath1));
    System.out.println("----");
    System.out.printf("%s is relativized to %s: %s%n", relPath1, relPath1, relPath1.relativize(relPath1));

    System.out.println();

    //    Path p = absPath1.normalize();
    //    Path q = absPath2.normalize();
    Path p = Path.of("/a/b");
    Path other = Path.of("/a/b/c/d");
    Path q = p.relativize(other);                               // c/d
    System.out.println(q);
    System.out.println(p.relativize(p.resolve(q)).equals(q));   // true
    System.out.println(p.resolve(q).equals(other));             // true

    System.out.println();


    //  Converting a Path to a Real Path
    System.out.println("Converting a Path to a Real Path");

    Path currDir = Path.of(".");
    System.out.println(currDir + "->" + currDir.toRealPath());

    Path parentDir = Path.of("..");
    System.out.println(parentDir + "->" + parentDir.toRealPath());

    Path p1 = Path.of("./book/.././book/chap01");
    System.out.println(p1 + "->" + p1.toRealPath());

    Path p2 = Path.of("book/chap01/alias_appendixA");
    //    Path p2 = Path.of("/Volumes/Local/mySvns/pgj8ocp/trunk/JavaSE11_complete/PGJ8_OCP_Ch11/Chap11_Examples/book/chap01/alias_appendixA");
    System.out.println(Files.isSymbolicLink(p2));
    System.out.println(p2.toRealPath(LinkOption.NOFOLLOW_LINKS));
    //    System.out.println(p2.toRealPath());
    //    System.out.println(p2.toAbsolutePath().toRealPath());
    System.out.println();

    try {
      Path somePath = Path.of("some/path");
      Path realPath = somePath.toRealPath(LinkOption.NOFOLLOW_LINKS);
      System.out.println(realPath);
    } catch (NoSuchFileException nsfe) {
      nsfe.printStackTrace();
    }catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }
}