package com.hspedu.http.servlet.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 韩顺平
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/t2"})
public class T2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.setContentType("text/html;charset=utf-8");
        // PrintWriter writer = resp.getWriter();
        // writer.print("<h1>成功访问 T2Servlet</h1>");
        // writer.flush();
        // writer.close();

        //演示302的重定向
        //resp.sendRedirect("/http/imgs/2.png");

        //演示500
        int[] arr = {1,2};
        for (int i = 0; i < 4; i++) {
            System.out.println("i=" + arr[i]);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
