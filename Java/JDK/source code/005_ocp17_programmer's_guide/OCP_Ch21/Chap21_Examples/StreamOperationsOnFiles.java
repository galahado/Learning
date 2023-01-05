import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsOnFiles {

  // lines(), walk(), find(), list()

  // collate statistic with the help of streams.

  public static void main(String[] args) {
    List<String> lines = List.of("Guess who got caught?", "Who?",
        "NullPointerException.", "Seriously?", "No. Finally.");
    Path textFile = Path.of(".", "project", "linesOnly.txt");

    try {
      textFile = Files.write(textFile, lines);
      System.out.printf("List of lines written to file \"%s\":%n%s%n", textFile, lines);
    } catch (IOException e1) {
      e1.printStackTrace();
    }

    // Stream to read lines in a text file:
    System.out.printf("Stream to read from text file \"%s\":%n", textFile);
    try (Stream<String> stream = Files.lines(textFile)) {
      stream.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }


    Path wordFile = Path.of(".", "wordlist.txt");
    System.out.println("Find palindromes, greater than length 2.");
    try (Stream<String> stream = Files.lines(wordFile)){
      List<String> palindromes = stream
          .filter(str -> str.length() > 2)
          .filter(str -> str.equals(new StringBuilder(str).reverse().toString()))
          .toList();
      System.out.printf("List of palindromes:   %s%n", palindromes);
      System.out.printf("Number of palindromes: %s%n", palindromes.size());
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("Create map to count the number of lines with different lengths.");
    try (Stream<String> stream = Files.lines(textFile)) {
      Map<Integer, Long> grpMap =
          stream.collect(Collectors.groupingBy(String::length,
              Collectors.counting()));
      System.out.println(grpMap);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // List immediate entries in a directory
    System.out.println("Number of immediate regular files whose name ends with \".txt\":");
    Path dir = Path.of(".", "a");
    try(Stream<Path> stream = Files.list(dir)) {
      long numOfFiles = stream.filter(Files::isRegularFile)
          .map(Path::toString)
          .filter(s -> s.endsWith(".txt"))
          .count();
      System.out.println(numOfFiles);
    } catch (NotDirectoryException nde) {
      nde.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    //List immediate entries in a directory
    //Path dir = Path.of(".", "a");
    System.out.printf("Immediate entries under directory \"%s\":%n", dir);
    try(Stream<Path> stream = Files.list(dir)) {
      stream.forEach(System.out::println);
    } catch (NotDirectoryException nde) {
      nde.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }


    Path start = Path.of(".", "a");
    // Walking a directory (max depth, do not follow symbolic links):
    System.out.println("Files whose name ends with \".txt:\"");
    try(Stream<Path> stream = Files.walk(start)) {
      stream.filter(Files::isRegularFile)
      .filter(p -> p.toString().endsWith(".txt"))
      .forEach(System.out::println);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    // Copy entire directory:
    CopyOption[] options = new CopyOption[] {
        StandardCopyOption.REPLACE_EXISTING,
        StandardCopyOption.COPY_ATTRIBUTES,
        LinkOption.NOFOLLOW_LINKS};
    Path srcDir = Path.of("book", "chap01");                  // ./book/chap01
    Path destParent = Path.of("project");                     // ./project
    Path destDir = destParent.resolve(srcDir.getFileName());  // ./project/chap01
    System.out.printf("Source dir: %s%n", srcDir);
    System.out.printf("Destination dir: %s%n", destDir);
    if (Files.exists(destDir)) {
      FileUtils.deleteEntireDirectory(destDir);
    }
    FileUtils.copyEntireDirectory(srcDir, destDir, options);

    Path sourceDirectory      = Path.of(".", "a", "b");     // ./a/b
    Path destinationDirectory = Path.of(".", "x", "y");     // ./x/y
    //Path destinationDirectory = Path.of(".", "x")
    //              .resolve(sourceDirectory.getFileName());  // ./x/b
    FileUtils.copyEntireDirectory(sourceDirectory, destinationDirectory, options);

    // Copy single file:
    Path srcFile = Path.of("project", "linesOnly.txt");                // ./project/linesOnly.txt
    Path destFile = Path.of("archive").resolve(srcFile.getFileName()); // ./archive/linesOnly.txt
    System.out.printf("Source file: %s%n", srcFile);
    System.out.printf("Destination file: %s%n", destFile);
    FileUtils.copyEntireDirectory(srcFile, destFile, options);

    System.out.printf("Total size of text files (bytes):   %d%n",
        getTotalSize(start, path -> Files.isRegularFile(path) &&
            StreamOperationsOnFiles.entrySize(path) > 0 &&
            path.toString().endsWith(".txt")));
    System.out.printf("Total size of regular files (byes): %d%n",
        getTotalSize(start, Files::isRegularFile));
    System.out.printf("Total size of directories (byes):   %d%n",
        getTotalSize(start, p -> true));

    // Find files:
    System.out.println("Find regular files whose name ends with \".txt\""
        + " and whose size is > 0:");
    Path startEntry = Path.of(".", "a");
    int depth = 5;
    try (var pStream = Files.find(startEntry, depth,
        (path, attrs) -> attrs.isRegularFile()       // (1)
        && attrs.size() > 0
        && path.toString().endsWith(".txt"))) {
      List<Path> pList = pStream.toList();
      System.out.println(pList);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public static long getTotalSize(Path start, Predicate<Path> predicate) {
    long totSize = 0;
    try (Stream<Path> stream = Files.walk(start)) {
      totSize = stream
          .filter(predicate::test)
          //       .peek(System.out::println)
          .mapToLong(StreamOperationsOnFiles::entrySize)
          .sum();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    return totSize;
  }

  public static long entrySize(Path p) {
    try {
      return Files.size(p);
    } catch (IOException ioe) {
      System.out.printf("%s: Cannot determine size of %s.%n", ioe, p);
      return 0L;
    }
  }
}