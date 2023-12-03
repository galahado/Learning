package com.hspedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //这里我们希望通过转发来定位b.html
        //老师解读
        //1. 在服务器端 解析第一个 /时，会被解析成 http://ip:port/项目名[application context]
        //   老韩再补充： 项目名=> 说成 application context
        //2. "/d1/d2/b.html" => 被解析 http://ip:port/项目名/d1/d2/b.html
        System.out.println("Servlet03 进行转发~~~ ....");
        request.getRequestDispatcher("/d1/d2/b.html").forward(request,response);
        //3. 在服务器进行转发时, 没有 / 就按照默认的方式参考定位 http://ip:port/项目名/
        //   老师建议，仍然使用上面的
        //request.getRequestDispatcher("d1/d2/b.html").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
