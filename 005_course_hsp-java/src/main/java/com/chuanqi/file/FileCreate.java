package com.chuanqi.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {

    public static void main(String[] args) {

    }

    @Test
    public void createFile01() {
        String filePath = "C:\\Users\\zhang\\test.txt";
        File file = new File(filePath);

        try {
            boolean newFile = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createFile02() throws IOException {
        File parentFile = new File("C:\\Users\\zhang");
        String fileName = "test2.txt";
        boolean newFile = new File(parentFile, fileName).createNewFile();
    }


    @Test
    public void createFile03() throws IOException {
        String parentPath = "C:\\Users\\zhang";
        String fileName = "test3.txt";
        boolean newFile = new File(parentPath, fileName).createNewFile();
    }
}
