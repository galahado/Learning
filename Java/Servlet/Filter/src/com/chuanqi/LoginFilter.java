package com.chuanqi;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Login Filtered called!");
        // implement the filter, so that the page can only be shown when there is a "username" attribute in session object
        // otherwise, forward the page to /
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if (session.getAttribute("username") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.getRequestDispatcher("/").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
