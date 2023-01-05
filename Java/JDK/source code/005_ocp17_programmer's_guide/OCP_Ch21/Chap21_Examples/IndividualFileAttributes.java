import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;

import static java.lang.System.out;
import static java.nio.file.attribute.PosixFilePermission.*;

public class IndividualFileAttributes {

  public static void main(String[] args) throws IOException {

    Path fPath = Path.of("project", "src", "pkg", "Main.java");
    out.println("File: " + fPath);

    out.println("Accessing Individual File Attributes:");
    out.println("size file (bytes): " + Files.size(fPath));                // (1)
    out.println("isDirectory:       " + Files.isDirectory(fPath));         // (2)
    out.println("isRegularFile:     " + Files.isRegularFile(fPath));       // (3)
    out.println("isSymbolicLink:    " + Files.isSymbolicLink(fPath));      // (4)
    out.println();

    out.println("isReadable:        " + Files.isReadable(fPath));          // (5)
    out.println("isWritable:        " + Files.isWritable(fPath));          // (6)
    out.println("isExecutable:      " + Files.isExecutable(fPath));        // (7)
    out.println("isHidden:          " + Files.isHidden(fPath));            // (8)
    out.println();

    out.println("getLastModifiedTime: " + Files.getLastModifiedTime(fPath));// (9)
    out.println("getOwner:            " + Files.getOwner(fPath));          // (10)
    out.println();

    // Get the POSIX file permissions for the directory entry:
    Set<PosixFilePermission> filePermissions
        = Files.getPosixFilePermissions(fPath);                            // (11)
    out.println("getPosixFilePermissions (set): " + filePermissions);      // (12)
    out.println("getPosixFilePermissions (string): "
              + PosixFilePermissions.toString(filePermissions));           // (13)

    // Get the group of the directory entry:
    out.println("getAttribute-group:  " + Files.getAttribute(fPath,        // (14)
                                                             "posix:group"));
    out.println();

    // Update last modified time for the directory entry.                     (15)
    long currentTime = System.currentTimeMillis();
    FileTime timestamp = FileTime.fromMillis(currentTime);
    Files.setLastModifiedTime(fPath, timestamp);

    // Set new owner for the directory entry.                                 (16)
    FileSystem fs = fPath.getFileSystem();   // File system that created the path.
    UserPrincipalLookupService upls
        = fs.getUserPrincipalLookupService();// Obtain service to look up user.
    UserPrincipal user = upls.lookupPrincipalByName("khalid"); // User lookup.
    Files.setOwner(fPath, user);                               // Set user.

    // Set POSIX file permissions for the directory entry:                    (17)
    Set<PosixFilePermission> newfilePermissions
        = EnumSet.of(OWNER_READ, OWNER_WRITE, GROUP_READ, GROUP_WRITE);   // (18a)
    //Set<PosixFilePermission> newfilePermissions
    //  = PosixFilePermissions.fromString("rw-rw----");                   // (18b)
    Files.setPosixFilePermissions(fPath, newfilePermissions);             // (19)
    filePermissions = Files.getPosixFilePermissions(fPath);
    out.println("getPosixFilePermissions (set): " + filePermissions);
    out.println("getPosixFilePermissions (string): "
          + PosixFilePermissions.toString(filePermissions));

    // Setting the value of a file attribute by its attribute name.
    Files.setAttribute(fPath, "lastAccessTime", timestamp);               // (20)
  }
}