package com.hspedu.session.homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginCheckServlet 被调用..");
        //功能-> 自己拆解 -> 逐步实现 [大量练习]
        //1. 得到提交的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if("666666".equals(password)) {//认为合法
            //把用户名保存到 session
            HttpSession session = request.getSession();
            session.setAttribute("loginuser", username);

            //请求转发到ManageServlet
            request.getRequestDispatcher("/manage").forward(request, response);
        } else {
            //请求转发进入到 error.html
            request.getRequestDispatcher("/error.html").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
