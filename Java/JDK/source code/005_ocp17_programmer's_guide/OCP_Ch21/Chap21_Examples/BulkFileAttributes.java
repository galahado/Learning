import static java.lang.System.out;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.time.Instant;
import java.util.Set;

public class BulkFileAttributes {

  public static void main(String[] args) throws IOException {

    // A timestamp.
    // Path object to directory entry.
    Path path = Path.of("project", "src", "pkg", "Main.java");
    out.println("File: " + path);

    // Supported file attribute views.
    FileSystem fss = path.getFileSystem();
    Set<String> fsTypes = fss.supportedFileAttributeViews();
    System.out.println(fsTypes);

    // --- Read into a BasicFileAttributes object.
    BasicFileAttributes bfa = Files.readAttributes(path,                   // (1)
        BasicFileAttributes.class);
    FileUtils.printBasicFileAttributes(bfa);                               // (2)


    // --- Read into a PosixFileAttributes object.
    PosixFileAttributes pfa = Files.readAttributes(path,                   // (3)
        PosixFileAttributes.class);
    out.println("File: " + path);
    FileUtils.printBasicFileAttributes(pfa);                               // (4)
    FileUtils.printPosixFileAttributes(pfa);                               // (5)

    // --- Read into a BasicFileAttributeView object.
    BasicFileAttributeView bfaView = Files.getFileAttributeView(path,      // (6)
        BasicFileAttributeView.class);
    System.out.printf("Using view: %s%n", bfaView.name());

    // Reading the basic set of file attributes:                              (7)
    BasicFileAttributes bfa2 = bfaView.readAttributes();
    FileUtils.printBasicFileAttributes(bfa2);
    FileTime currentLastModifiedTime = bfa2.lastModifiedTime();

    // Updating timestamp for last modified time using view:                     (8)
    long newLMTinMillis = currentLastModifiedTime.toMillis() + 15*60*1000L;
    FileTime newLastModifiedTime = FileTime.fromMillis(newLMTinMillis);
    bfaView.setTimes(newLastModifiedTime, null, null);

    // Reading the updated last modified time:                                (9)
    out.println("updated lastModifiedTime (incorrect): "
        + bfa2.lastModifiedTime());   // (10)
    out.println("updated lastModifiedTime: "
        + Files.getLastModifiedTime(path)); // (11)
    out.println("updated lastModifiedTime: " + Files.getAttribute(path,    // (12)
        "basic:lastModifiedTime"));
    // --- Read into a PosixFileAttributeView object.
    PosixFileAttributeView pfaView = Files.getFileAttributeView(path,      // (13)
        PosixFileAttributeView.class);
    System.out.printf("Using view: %s%n", pfaView.name());

    // Reading the basic + POSIX set of file attributes:                   // (14)
    PosixFileAttributes pfa2 = pfaView.readAttributes();
    FileUtils.printBasicFileAttributes(pfa2);
    FileUtils.printPosixFileAttributes(pfa2);

    // Updating owner and group file attributes using view.                // (15)
    FileSystem fs = path.getFileSystem();
    UserPrincipalLookupService upls = fs.getUserPrincipalLookupService();
    UserPrincipal newUser = upls.lookupPrincipalByName("khalid");
    GroupPrincipal newGroup = upls.lookupPrincipalByGroupName("admin");
    pfaView.setOwner(newUser);
    pfaView.setGroup(newGroup);

    //Updating file permissions using view.                                // (16)
    Set<PosixFilePermission> newPerms
    = PosixFilePermissions.fromString("r--r--r--");
    pfaView.setPermissions(newPerms);

    //Updating last access time using view.                                // (17)
    FileTime currentAccessTime = pfa2.lastAccessTime();
    long newLATinMillis = currentAccessTime.toMillis() + 10*60*1000L;
    FileTime newLastAccessTime = FileTime.fromMillis(newLATinMillis);
    pfaView.setTimes(null, newLastAccessTime, null);

    // Reading the updated file attributes:                                // (18)
    pfa2 = pfaView.readAttributes();
    FileUtils.printBasicFileAttributes(pfa2);
    FileUtils.printPosixFileAttributes(pfa2);
  }
}