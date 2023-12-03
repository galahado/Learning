package com.hspedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("LoginServlet 被调用...~~~");

        //1. 接收表单提交用户名和密码
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //2. 判断是否合法
        if ("hspedu".equals(username) && "123456".equals(pwd)) {
            //将登录成功的用户名，以cookie的形式，保存到浏览器
            Cookie loginuserCookie = new Cookie("loginuser", username);
            //设置该cookie生命周期
            loginuserCookie.setMaxAge(3600 * 24 * 3);
            response.addCookie(loginuserCookie);
            //合法
            writer.println("<h1>登录OK</h1>");

        } else {
            //不合法
            writer.println("<h1>登录失败</h1>");
        }

        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
