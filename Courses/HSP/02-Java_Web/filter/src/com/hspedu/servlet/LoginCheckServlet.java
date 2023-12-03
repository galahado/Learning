package com.hspedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取到用户名和密码->DB
        //假设密码是123456, 就可以通过
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("request=" + request);
        if("123456".equals(password)) {

            //合法, 讲用户名，加入session
            request.getSession().setAttribute("username", username);
            //请求转发到admin.jsp
            request.getRequestDispatcher("/manage/admin.jsp")
                    .forward(request,response);
        } else {
            //不合法, 返回登录页面
            request.getRequestDispatcher("/login.jsp")
                    .forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
