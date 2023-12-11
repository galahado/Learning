package com.chuanqi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// refer: Courses\HSP\02-Java_Web\servlet\src\com\hspedu\servlet\response\DownServlet
public class DownServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. redirect to DownServletNew using 2 ways; get the context dynamically
//        resp.sendRedirect(req.getContextPath() + "/newDown");

        resp.setStatus(302);
        resp.setHeader("Location", req.getContextPath()+"/newDown");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
