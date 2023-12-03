package com.hspedu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HiServlet 被调用..");

        //老韩梳理 servlet中可以使用哪些对象
        PrintWriter writer = response.getWriter();
        writer.println("haha");
        request.getParameter("age");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        session.setAttribute("job", "java工程师90000");
        //
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("count", 666);
        ServletConfig servletConfig = getServletConfig();
        servletConfig.getInitParameter("pwd");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
