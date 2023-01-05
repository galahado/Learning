import java.io.*;
import java.util.*;

/** Class to create a password file */
public final class MakePasswordFile {

  public static void main (String[] args) throws IOException {
    Map<String, Integer> pwStore = new TreeMap<>();
    pwStore.put("tom", "123".hashCode());
    pwStore.put("dick", "456".hashCode());
    pwStore.put("harriet", "789".hashCode());

    try (PrintWriter destination = new PrintWriter(new FileWriter("pws.txt"))) {
      Set<Map.Entry<String, Integer>> pwSet = pwStore.entrySet();
      pwSet.stream()
           .forEach(entry -> destination.printf("%s %s%n", entry.getKey(),
                                                           entry.getValue()));
    }
    System.out.println("Created new password file.");
  }
}