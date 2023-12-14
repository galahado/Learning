package com.chuanqi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("123456".equals(password)) {
            System.out.println("Successfully logged in!");
            req.getSession().setAttribute("username", username);
        } else {
            System.out.println("Wrong password!");
            req.getRequestDispatcher("/index.html").forward(req, resp);
        }
    }
}
