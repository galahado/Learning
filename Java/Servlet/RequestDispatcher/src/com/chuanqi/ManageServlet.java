package com.chuanqi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// refer: Courses\HSP\02-Java_Web\servlet\src\com\hspedu\servlet\request\ManageServlet
public class ManageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. get the username and role and send back to the browser
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("Username: " + req.getParameter("username"));
        writer.println("<br>");
        writer.println("Role: " + req.getAttribute("role"));
    }
}
