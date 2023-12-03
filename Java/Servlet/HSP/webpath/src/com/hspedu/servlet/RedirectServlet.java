package com.hspedu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RedirectServlet 重定向4 被调用....");
        //这里如何通过重定向来定位 /views/user/user.html
        //1. 分析出 重定向是发生在 浏览器
        //2. 写法1: response.sendRedirect("http://localhost:8080/webpath/views/user/user.html");
        //3. 写法2: response.sendRedirect("/webpath/views/user/user.html");
        //4. 写法3: response.sendRedirect("views/user/user.html");
        //5. 写法4: response.sendRedirect(contextPath + "/views/user/user.html");
        //6. 推荐写法是 第4个写法，比较灵活，而且定位资源是稳定的.
        String contextPath = getServletContext().getContextPath();//contextPath=/webpath
        response.sendRedirect(contextPath + "/views/user/user.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
