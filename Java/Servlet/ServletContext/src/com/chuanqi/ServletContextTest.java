package com.chuanqi;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// check Courses\HSP\02-Java_Web\servlet\src\com\hspedu\servlet\servletcontext\ServletContext_.java
public class ServletContextTest extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        System.out.println("Name: " + servletContext.getInitParameter("name"));
        System.out.println("Context Path: " + servletContext.getContextPath());
        System.out.println("Real Path: " + servletContext.getRealPath("/"));
    }
}
