package com.hspedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //这里请求转发到 /views/user/user.html
        //System.out.println("HiServlet 被调用....");

        //使用转发
        //注意 第一个 / 被服务器解析成  /webpath/
        //    因为请求转发是发生服务器端，所以通过 /webpath/views/user/user.html
        //    可以定位该资源
        request.getRequestDispatcher("/views/user/user.html")
                .forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
