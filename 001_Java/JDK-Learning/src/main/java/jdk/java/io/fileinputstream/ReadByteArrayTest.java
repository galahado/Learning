package jdk.java.io.fileinputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadByteArrayTest {

    @Test
    void readByteArray() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src\\main\\resources\\test.txt");
            int count = 0;
            byte[] bytes = new byte[4];
            while ((count = fileInputStream.read(bytes)) > 0) {
                System.out.println(new String(bytes, 0, count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
