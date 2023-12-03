package com.hspedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookiePath extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CookiePath 被调用...");
        //1. 创建两个cookie
        Cookie cookie = new Cookie("address", "bj");
        Cookie cookie2 = new Cookie("salary", "20000");
        //2. 设置不同有效路径
        //   request.getContextPath() => /cs
        cookie.setPath(request.getContextPath());
        //   cookie2有效路径 /cs/aaa
        cookie2.setPath(request.getContextPath() + "/aaa");

        //老师说明：如果我们没有设置cookie有效路径，默认就是 /工程路径

        //3. 保存到浏览器
        response.addCookie(cookie);
        response.addCookie(cookie2);

        //4. 给浏览器返回信息
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>设置cookie有效路径成功</h1>");
        writer.flush();
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
