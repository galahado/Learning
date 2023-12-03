package com.hspedu.session.homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //判断该用户是否登录过
        HttpSession session = request.getSession();
        Object loginuser = session.getAttribute("loginuser");
        if(loginuser == null) {//说明该用户没有登录
            //重新登录-> 请求重定向
            //response.sendRedirect("/cs/userlogin.html");
            response.sendRedirect(request.getContextPath() + "/userlogin.html");
            return;
        } else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println("<h1>用户管理页面</h1>");
            writer.println("欢迎你, 管理员：" + loginuser.toString());
            writer.flush();
            writer.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
