package com.chuanqi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// refer: Courses\HSP\02-Java_Web\servlet\src\com\hspedu\servlet\request\CheckServlet
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. check the username, if tom set role as administrator, otherwise user
        String username = req.getParameter("username");
        if ("tom".equals(username)) {
            req.setAttribute("role", "administrator");
        } else {
            req.setAttribute("role", "user");
        }
        // 2. dispatch to ManageServlet
        req.getRequestDispatcher("/manage").forward(req, resp);

    }
}
