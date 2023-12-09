package com.exercise;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


// refer: Courses\HSP\02-Java_Web\servlet\src\com\hspedu\servlet\request\HttpServletRequestMethods.java
public class HttpServletRequestMethods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HttpServletRequestMethods doPost() called");

        // 1. 请求的统一资源定位符（绝对路径）URL

        // 2. 请求的客户端ip地址和端口

        // 3. get the Referer form Header

        // 4. get parameter value username and pwd and solve Chinese encoding problem

        // 5. get all the parameter values from hobby

        // 6. output the username back to the browser and solve Chinese encoding problem
    }
}
