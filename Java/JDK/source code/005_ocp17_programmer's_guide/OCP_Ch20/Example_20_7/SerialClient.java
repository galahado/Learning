import java.io.*;

public class SerialClient {

  public static void main(String args[])
      throws IOException, ClassNotFoundException {

    try (// Set up the output stream:                              // (4)
        FileOutputStream outputFile = new FileOutputStream("storage.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(outputFile)) {

      // Write the data:
      Wheel wheel = new Wheel(65);
      Unicycle uc = new Unicycle(wheel);
      System.out.println("Before writing: " + uc);
      outputStream.writeObject(uc);
    }

    try (// Set up the input streams:                              // (5)
        FileInputStream inputFile = new FileInputStream("storage.dat");
        ObjectInputStream inputStream = new ObjectInputStream(inputFile)) {

      // Read data.
      Unicycle uc = (Unicycle) inputStream.readObject();

      // Write data on standard output stream.
      System.out.println("After reading: " + uc);
    }
  }
}