package com.hspedu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        //给servletContext 对象操作属性
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("name", "韩顺平教育");
        servletContext.setAttribute("name", "老韩教育");
        servletContext.removeAttribute("name");

        //获取session对象
        //Filter

        HttpSession session = request.getSession();
        session.setAttribute("age", 100);
        session.setAttribute("age", 400);
        session.removeAttribute("age");

        System.out.println("HiServlet 处理完毕....");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
