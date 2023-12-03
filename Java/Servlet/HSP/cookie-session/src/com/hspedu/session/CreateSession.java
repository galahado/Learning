package com.hspedu.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("CreateSession 被调用...");

        //1. 获取session, 同时也可能创建session
        HttpSession session = request.getSession();

        //2. 给session获取id
        System.out.println("CreateSession 当前sessionid= " + session.getId());
        //3. 给session存放数据
        session.setAttribute("email", "zs@qq.com");

        //4. 给浏览器发送一个回复
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>创建/操作session成功...</h1>");
        writer.flush();
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
