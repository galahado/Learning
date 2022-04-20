package com.chuanqi.inputstream;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FileInputStream {

    @Test
    public void readFile01() {
        String filePath = "C:/Users/zhang/test.txt";
        java.io.FileInputStream inputStream = null;
        int readData = 0;

        try {
            inputStream = new java.io.FileInputStream(filePath);

            while ((readData = inputStream.read()) != -1) {
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void readFile02() {
        String filePath = "C:/Users/zhang/test.txt";
        java.io.FileInputStream inputStream = null;
        byte[] buf = new byte[8];
        int readLen = 0;

        try {
            inputStream = new java.io.FileInputStream(filePath);

            while ((readLen = inputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
