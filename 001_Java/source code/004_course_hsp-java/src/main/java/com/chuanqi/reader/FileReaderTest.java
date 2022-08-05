package com.chuanqi.reader;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

    @Test
    void readFile1() {
        String filePath = "c:\\Users\\zhang\\test.txt";
        int readData = 0;
        FileReader reader = null;

        try {
            reader = new FileReader(filePath);
            while ((readData = reader.read()) != -1) {
                System.out.print((char)readData);
            }
        } catch (IOException e) {
            try {
                    reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    void readFile2() {
        String filePath = "c:\\Users\\zhang\\test.txt";
        FileReader reader = null;
        char[] buf = new char[8];
        int readLen = 0;

        try {
            reader = new FileReader(filePath);
            while ((readLen = reader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
