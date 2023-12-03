package com.hspedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 演示如何创建cookie,并保存到浏览器
 */
public class CreateCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CreateCookie 被调用...");


        //1. 创建一个Cookie对象
        //老韩解读
        //1) username 该cookie的名字 是唯一, 可以理解成是key
        //2) hsp : 该cookie的值
        //3) 可以创建多个cookie，老师就创建了一个
        //4) 这是cookie在服务器端, 还没有到浏览器
        Cookie cookie = new Cookie("username", "tom");
        Cookie cookie2 = new Cookie("email", "tom@sohu.com");

        response.setContentType("text/html;charset=utf-8");
        //2. 将cookie发送给浏览器, 让浏览器将该cookie保存
        response.addCookie(cookie);
        response.addCookie(cookie2);

        PrintWriter writer = response.getWriter();
        writer.println("<h1>创建cookie成功~</h1>");
        writer.flush();
        writer.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
