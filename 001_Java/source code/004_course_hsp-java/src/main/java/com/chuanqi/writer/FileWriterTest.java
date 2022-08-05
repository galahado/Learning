package com.chuanqi.writer;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

    @Test
    void writeFile() {
        String filePath = "c:\\Users\\zhang\\test.txt";
        FileWriter writer = null;

        try {
            writer = new FileWriter(filePath);
            writer.write("张传琦");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
