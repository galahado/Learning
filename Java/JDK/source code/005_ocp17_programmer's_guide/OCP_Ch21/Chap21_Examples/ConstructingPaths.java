import java.nio.file.Paths;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Files;

public class ConstructingPaths {

  public static void main(String[] args) {
    FileSystem dfs = FileSystems.getDefault();     // The default file system
    String nameSeparator = dfs.getSeparator();     // The name separator for a path.

    //    Creating Paths with the of() Methods of the Path Interface
    {
      Path absPath1 = Path.of("/a/b/c");                       // (1)
      Path absPath2 = Path.of(nameSeparator + "a" +                        // (2)
          nameSeparator + "b" +
          nameSeparator + "c");
      Path absPath3 = Path.of(nameSeparator, "a", "b", "c");   // (3)

      Path absPath4 = Path.of("C:\\a\\b\\c");                  // (4)
      Path absPath5 = Path.of("C:", "a", "b", "c");            // (5)

      System.out.println(absPath1);
      System.out.println(absPath2);
      System.out.println(absPath3);
      System.out.println(absPath4);
      System.out.println(absPath5);
      System.out.println(absPath1.equals(absPath2) && absPath2.equals(absPath3));
      System.out.println(absPath5.equals(absPath4));



      Path relPath1 = Path.of("c", "d");
      Path relPath2 = Path.of(".", "c", "d");

      System.out.println(relPath1);
      System.out.println(relPath2);

      String pathOfCurrDir = System.getProperty("user.dir");
      Path currDir = Path.of(pathOfCurrDir);
      Path relPath = Path.of(pathOfCurrDir, "d");

      System.out.println(">" + pathOfCurrDir);
      System.out.println(">" + currDir);
      System.out.println(">" + relPath);
    }

    //    Creating Paths using the Default File System
    {
      Path absPath7 = Paths.get(nameSeparator, "a", "b", "c");
      Path relPath3 = Paths.get("c", "d");
      System.out.println(absPath7);
      System.out.println(relPath3);


    }



    //    Creating Paths with the get() Method of the Paths Class
    {
      Path absPath1 = Paths.get(nameSeparator, "a", "b", "c");

      System.out.println(absPath1);

    }

    //  Interoperability with the java.io.File Legacy Class
    {
      File file = new File(File.separator + "a" +
          File.separator + "b" +
          File.separator + "c"); // /book/chap01/examples
      // File --> Path, using the java.io.File.toPath() instance method
      Path fileToPath = file.toPath();                   // /book/chap01/examples
      // Path --> File, using the java.nio.file.Path.toFile() default method.
      File pathToFile = fileToPath.toFile();             // /book/chap01/examples
      System.out.println("fileToPath: " + fileToPath);
      System.out.println("pathToFile: " + pathToFile);

      URI fileToUri = file.toURI();
      System.out.println(">" + fileToUri);
    }

    //    Interoperability with the java.net.URI Class
    //    try
    {
      //URI uri1 = new URI("file:///book/chap01/examples/Demo.java");      // Local file
      // Create an URI, using the java.net.URL.create(String str) static factory method
      URI uri1 = URI.create("file:///a/b/c/d");   // Local file.
      // URI --> Path, using the Path.of(URI uri) static factory method
      Path uriToPath1 = Path.of(uri1);    // file:///book/chap01/examples/Demo.java
      // URI --> Path, using the Paths.get(URI uri) static factory method
      Path uriToPath2 = Paths.get(uri1);  // file:///book/chap01/examples/Demo.java
      // Path --> URI, using the Path.toURI() instance method
      URI pathToUri = uriToPath1.toUri(); // file:///book/chap01/examples/Demo.java
      System.out.println("uriToPath:" + uriToPath1);
      System.out.println("pathToUri:" + pathToUri);
    }
    //    catch (URISyntaxException uex) {
    //      uex.printStackTrace();
    //    }
  }
}