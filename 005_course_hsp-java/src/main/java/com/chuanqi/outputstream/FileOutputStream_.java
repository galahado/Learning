package com.chuanqi.outputstream;

import com.chuanqi.inputstream.FileInputStream;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {

    @Test
    public void writeFile() {
        String filePath = "C:/Users/zhang/test2.txt";
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.write("Hello world!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
