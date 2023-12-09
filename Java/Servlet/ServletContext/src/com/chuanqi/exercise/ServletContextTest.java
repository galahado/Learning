package com.chuanqi.exercise;

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
        // 1. get the context param "name" from web.xml

        // 2. get the project context path

        // 3. get the path the project is installed on the hard disk
    }
}
