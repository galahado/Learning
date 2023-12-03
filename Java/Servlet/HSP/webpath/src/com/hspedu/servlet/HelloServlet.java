package com.hspedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet 被调用...");

        //这个realPath 我们的项目的工作路径
        String realPath = getServletContext().getRealPath("/");
        System.out.println("realPath= " + realPath);

        //contextPath 是配置的 application context
        //这个将来可以在服务器渲染 技术jsp / thymeleaf 动态获取工程路径 application context
        String contextPath = getServletContext().getContextPath();
        System.out.println("contextPath= " + contextPath);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
