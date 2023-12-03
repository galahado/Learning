package com.hspedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UpdateCookie 被调用...");

        //需求
        /**
         * 1. 需求 演示如何修改Cookie
         * 1) 给定一个cookie的name, 找到该cookie, 如果找到, 则修改该cookie的值为 hsp-hi
         * 2) 如果找不到指定的cookie , 则提示, 没有该cookie
         */
        //1. 根据name 去查找 cookie
        String cookieName = "emailx";
        Cookie[] cookies = request.getCookies();

        //如果我们直接创建了一个同名的cookie
        Cookie userNameCookie = new Cookie("username", "hahaha");


        Cookie cookie = CookieUtils.readCookieByName(cookieName, cookies);
        if (null == cookie) {//在该浏览器没有email cookie
            System.out.println("当前访问 服务端的 浏览器没有 该cookie");
        } else {
            cookie.setValue("hsp-hi");
        }
        System.out.println("=====修改后的cookies信息=======");
        //2. 编写cookie
        for (Cookie cookie1 : cookies) {
            System.out.println("cookie name= " + cookie1.getName()
                    + " value= " + cookie1.getValue());
        }

        //3. 给浏览器返回信息
        response.setContentType("text/html;charset=utf-8");
        //4. 如果希望我们的浏览器本地的cookie也修改，则需要使用response.addCookie(cookie);
        if(cookie != null) {
            response.addCookie(cookie);
        }
        //把 新创建的userNameCookie 重新保存到浏览器
        //如果 保存的userNameCookie 和已经有的cookie同名，就等价于替换.
        if(userNameCookie != null) {
            response.addCookie(userNameCookie);
        }
        PrintWriter writer = response.getWriter();
        writer.println("<h1>完成修改cookie的任务..</h1>");
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
