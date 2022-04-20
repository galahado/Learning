package com.chuanqi.outputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

    @Test
    public void copy() {
        String orginPath = "c:/Users/zhang/Downloads/Image_002.PNG";
        String desPath = "c:/Users/zhang/test.PNG";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(orginPath);
            fileOutputStream = new FileOutputStream(desPath);
            byte[] buf = new byte[1024];
            int redLen = 0;

            while ((redLen = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, redLen);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) fileInputStream.close();
                if (fileOutputStream != null) fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
