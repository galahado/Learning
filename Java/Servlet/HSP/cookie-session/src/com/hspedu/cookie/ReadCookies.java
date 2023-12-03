package com.hspedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 读取从浏览器发送来的cookie信息[底层仍然是http协议]
 */
public class ReadCookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ReadCookies 被调用..");


        //1. 通过request对象读取cookie信息
        Cookie[] cookies = request.getCookies();
        //2. 遍历cookie
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                System.out.println("cookie name= " + cookie.getName()
                        + " value= " + cookie.getValue());
            }
        }



        //3. 给浏览器返回信息
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>读取cookie信息成功~</h1>");
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
