package com.chuanqi;

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
        System.out.println("URL = " + req.getRequestURL());

        // 2. 请求的客户端ip地址和端口
        System.out.println("requester ip address = " + req.getRemoteAddr() + ":" + req.getRemotePort());

        // 3. get the Referer form Header
        System.out.println("The referer = " + req.getHeader("Referer"));

        // 4. get parameter value username and pwd and solve Chinese encoding problem
        req.setCharacterEncoding("utf-8");
        System.out.println("username: " + req.getParameter("username"));
        System.out.println("password: " + req.getParameter("pwd"));

        // 5. get all the parameter values from hobby
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println("hobby = " + hobby);
        }

        // 6. output the username back to the browser and solve Chinese encoding problem
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>提交的用户名= " + req.getParameter("username") + "</h1>");
    }
}
