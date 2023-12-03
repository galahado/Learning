package com.hspedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

public class ReadCookie2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("ReadCookie2 被调用..");
        //读取到中文cookie
        Cookie[] cookies = request.getCookies();
        Cookie companyCookie = CookieUtils.readCookieByName("company",cookies);
        String companyVal = companyCookie.getValue();
        System.out.println("companyVal= " + companyVal);//URL

        //解码
        companyVal = URLDecoder.decode(companyVal, "utf-8");
        System.out.println("解码后 companyVal= " + companyVal);//中文

        //3. 给浏览器返回信息
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>读取中文cookie解码成功~</h1>");
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
