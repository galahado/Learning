//Reading and writing records.
package record.serialize;
import java.io.*;
import java.util.Arrays;

public class ObjectSerializationDemo {
  void writeData() {                                    // (1)
    try (// Set up the output stream:
        FileOutputStream outputFile = new FileOutputStream("obj-storage.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(outputFile)) {

      // Write data:
      outputStream.writeObject(CD.cdArray);

    } catch (FileNotFoundException e) {
      System.err.println("File not found: " + e);
    } catch (IOException e) {
      System.err.println("Write error: " + e);
    }
  }

  void readData() {                                     // (2)
    try (// Set up the input stream:
        FileInputStream inputFile = new FileInputStream("obj-storage.dat");
        ObjectInputStream inputStream = new ObjectInputStream(inputFile)) {

      // Read the data:
      CD[] cdArray = (CD[]) inputStream.readObject();

      // Write data to the standard output stream:
      System.out.println(Arrays.toString(cdArray));

    } catch (FileNotFoundException e) {
      System.err.println("File not found: " + e);
    } catch (EOFException e) {
      System.err.println("End of stream: " + e);
    } catch (IOException e) {
      System.err.println("Read error: " + e);
    } catch (ClassNotFoundException e) {
      System.err.println("Class not found: " + e);
    }
  }

  public static void main(String[] args) {
    ObjectSerializationDemo demo = new ObjectSerializationDemo();
    demo.writeData();
    demo.readData();
  }
}