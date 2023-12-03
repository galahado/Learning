package com.hspedu.servlet.request.homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class ComputerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("ComputerServlet ..");

        //可以获取到浏览器所在电脑的操作系统版本和位数(32还是64), 显示在页面即可
        //分析一把 http请求头
        //User-Agent
        // 	Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:97.0) Gecko/20100101 Firefox/97.0
        //  我们要 Windows NT 10.0 和 Win64
        // 老师解读
        // (1) Windows NT 10.0; Win64; x64; rv:97.0
        // (2) Windows NT 10.0 和 Win64
        // (3) 老师回顾使用正则表达式
        String userAgent = request.getHeader("User-Agent");
        //java基础 正则表达式
        String regStr = "\\((.*)\\)";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(userAgent);
        matcher.find();// 因为我们的userAgent只有一组 ()
        String group = matcher.group(0);// (Windows NT 10.0; Win64; x64; rv:97.0)
        String group1 = matcher.group(1);// Windows NT 10.0; Win64; x64; rv:97.0
        String[] operInfos = group1.split(";");
        System.out.println("操作系统=" + operInfos[0]);//Windows NT 10.0
        System.out.println("操作系统位数=" + operInfos[1].trim());// Win64


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
