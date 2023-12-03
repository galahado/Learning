package com.hspedu.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("ReadSession 被调用...");
        // 演示读取session
        //1. 获取session, 如果没有sesion, 也会创建
        HttpSession session = request.getSession();
        //输出sessionId
        System.out.println("ReadSession sessionid= " + session.getId());
        //2. 读取属性
        Object email = session.getAttribute("email");
        if (email != null) {
            System.out.println("session属性 email= " + (String) email);
        } else {
            System.out.println("session中没有 email属性 ");
        }
        //给浏览器回复一下
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>读取session成功...</h1>");
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
