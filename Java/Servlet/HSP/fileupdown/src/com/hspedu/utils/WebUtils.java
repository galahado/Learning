package com.hspedu.utils;

import java.time.LocalDateTime;

public class WebUtils {

    public static String getYearMonthDay() {
        //如何得到当前的日期-> java基础 日期 三代类
        LocalDateTime ldt = LocalDateTime.now();
        int year = ldt.getYear();
        int monthValue = ldt.getMonthValue();
        int dayOfMonth = ldt.getDayOfMonth();
        String yearMonthDay = year + "/" + monthValue + "/" + dayOfMonth + "/";
        return yearMonthDay;
    }
    //技巧, 最好测试一把
    //public static void main(String[] args) {
    //    System.out.println(WebUtils.getYearMonthDay());
    //}
}
