package com.powernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class ConfigTestServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        var out = servletResponse.getWriter();

        ServletConfig config = this.getServletConfig();
        out.print(config);
    }
}
