package com.hspedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

public class EncoderCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("EncoderCookie 被调用");
        //1. 创建cookie, 有中文
        //老韩解读
        //1) 如果直接存放中文的cookie, 报错 Control character in cookie value or attribute.
        //2) 解决方法，就是将中文 编程成 URL编码  英文： Encode=编码
        //3) 编码后，再保存即可
        String company = URLEncoder.encode("韩顺平教育", "utf-8");

        Cookie cookie = new Cookie("company", company);
        //2. 保存到浏览器
        response.addCookie(cookie);

        //3. 给浏览器返回信息
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>设置中文cookie成功</h1>");
        writer.flush();
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
