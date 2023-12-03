package com.hspedu.utils;

public class WebUtils {

    //把一个string->int
    public static int parseInt(String strNum, int defaultVal) {
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            System.out.println(strNum + " 不能转成整数...");
        }
        return defaultVal;
    }

    //把一个string->int
    public static double parseDouble(String strNum, double defaultVal) {
        try {
            return Double.parseDouble(strNum);
        } catch (NumberFormatException e) {
            System.out.println(strNum + " 不能转成double...");
        }
        return defaultVal;
    }
}
