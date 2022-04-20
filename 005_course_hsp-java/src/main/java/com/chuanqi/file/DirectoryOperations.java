package com.chuanqi.file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class DirectoryOperations {

    @Test
    public void m1() {
        String filePath = "C:\\Users\\zhang\\test.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Delete successfully!");
            } else {
                System.out.println("Delete failed!");
            }
        } else {
            System.out.println("File not exist!");
        }
    }

    @Test
    public void m2() {
        // Create a directory if not existing
        String filePath = "C:\\Users\\zhang\\test\\t";
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Alread exist!");
        } else {
            if (file.mkdirs()) {
                System.out.println("Created successfully!");
            } else {
                System.out.println("Create failed");
            }
        }
    }
}
