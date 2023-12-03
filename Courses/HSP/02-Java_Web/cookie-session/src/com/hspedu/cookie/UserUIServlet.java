package com.hspedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("UserUIServlet .. 被调用..");
        //String contextPath = request.getContextPath();

        //老韩解读
        //1. 难度没有增加，-》文件多了 => 基础
        //2. 读取从浏览器发送来的cookie
        Cookie[] cookies = request.getCookies();
        Cookie loginuserCookie = CookieUtils.readCookieByName("loginuser", cookies);
        String username = "";
        if (loginuserCookie != null) {//如果有
            username = loginuserCookie.getValue();
        }

        response.setContentType("text/html;charset=utf-8");
        //1. 得到writer
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>登录页面</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>用户登录界面</h1>\n" +
                "<form action=\"/cs/login\" method=\"post\">\n" +
                "    u:<input type=\"text\" value=\"" + username + "\" name=\"username\"><br/>\n" +
                "    p:<input type=\"password\" name=\"pwd\"><br/>\n" +
                "    <input type=\"submit\" value=\"登录\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");


        writer.flush();
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
