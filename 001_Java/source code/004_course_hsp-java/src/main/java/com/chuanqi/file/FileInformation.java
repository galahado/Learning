package com.chuanqi.file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileInformation {
    public static void main(String[] args) {

    }

    @Test
    public void info() {
        File file = new File("C:\\Users\\zhang\\test.txt");

        System.out.println("File name: " + file.getName());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Parent path: " + file.getParent());
        System.out.println("File length: " + file.length());
        System.out.println("Exist?: " + file.exists());
        System.out.println("Is file?: " + file.isFile());
        System.out.println("Is directory?: " + file.isDirectory());
    }
}
