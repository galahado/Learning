import java.io.*;

public class BinaryValuesIO {
  public static void main(String[] args) throws IOException {

    // Write binary values to a file:
    try(                                                                   // (1)
        // Create a FileOutputStream.                                         (2)
        FileOutputStream outputFile = new FileOutputStream("primitives.data");
        // Create a DataOutputStream which is chained to the FileOutputStream.(3)
        DataOutputStream outputStream = new DataOutputStream(outputFile)) {

      // Write Java primitive values in binary representation:                (4)
      outputStream.writeBoolean(true);
      outputStream.writeChar('A');               // int written as Unicode char
      outputStream.writeByte(Byte.MAX_VALUE);    // int written as 8-bits byte
      outputStream.writeShort(Short.MIN_VALUE);  // int written as 16-bits short
      outputStream.writeInt(Integer.MAX_VALUE);
      outputStream.writeLong(Long.MIN_VALUE);
      outputStream.writeFloat(Float.MAX_VALUE);
      outputStream.writeDouble(Math.PI);
    }

    // Read binary values from a file:
    try (                                                                  // (1)
        // Create a FileInputStream.                                          (2)
        FileInputStream inputFile = new FileInputStream("primitives.data");
        // Create a DataInputStream which is chained to the FileInputStream.  (3)
        DataInputStream inputStream = new DataInputStream(inputFile)) {

      // Read the binary representation of Java primitive values
      // in the same order they were written out:                             (4)
      System.out.println(inputStream.readBoolean());
      System.out.println(inputStream.readChar());
      System.out.println(inputStream.readByte());
      System.out.println(inputStream.readShort());
      System.out.println(inputStream.readInt());
      System.out.println(inputStream.readLong());
      System.out.println(inputStream.readFloat());
      System.out.println(inputStream.readDouble());

      // Check for end of stream:
      int value = inputStream.readByte();
      System.out.println("More input: " + value);
    } catch (FileNotFoundException fnf) {
      System.out.println("File not found.");
    } catch (EOFException eof) {
      System.out.println("End of input stream.");
    }
  }
}