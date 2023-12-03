package com.hspedu.http.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class T1Servlet extends HttpServlet {

    //这里我们把 doGet和doPost合并处理
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //如果有一个请求来
        //重定向到hi.html
        //(1) 返回302状态码 (2) 响应头Location:/hi.html
        //response.sendRedirect("/http/hi.html");
        response.sendRedirect("http://www.baidu.com");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
