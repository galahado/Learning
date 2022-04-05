package com.chuanqi.generic;


public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        String s = "java.lang.String";
        Class c = Class.forName(s);
    }
}
