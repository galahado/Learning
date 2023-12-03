package com.hspedu.servlet.response.homework;

/**
 * @author 韩顺平
 * @version 1.0
 * 编写一个转换string->int的方法,处理异常
 */
public class WebUtils {

    public static int parseString(String str) {
        int num = 0;
        //try-catch : ctrl+alt+t
        //如果不知道，老韩在说什么? 回去看到java基础 - 异常
        try {
            num = Integer.parseInt(str);//
        } catch (NumberFormatException e) {
            //这个异常不会throw 给 tomcat
            System.out.println("输入的str格式不正确...");
        }

        return num;
    }
}
