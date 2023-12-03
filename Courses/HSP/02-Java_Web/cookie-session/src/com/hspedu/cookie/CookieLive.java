package com.hspedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieLive extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CookieLive 被调用...");

        //演示创建一个cookie , 生命周期为 60s
        Cookie cookie = new Cookie("job", "java");
        //老韩解读:
        // 1. 从创建该cookie开始计时, 60秒后无效
        // 2. 浏览器来根据创建的时间，计时到60s秒，就认为该cookie无效
        // 3. 如果该cookie无效，那么浏览器在发出http请求时，就不在携带该cookie
        cookie.setMaxAge(60);
        //讲cookie保存到浏览器
        response.addCookie(cookie);


        //演示如何删除一个cookie, 比如删除username
        //1 先得到username cookie
        Cookie[] cookies = request.getCookies();
        Cookie usernameCookie =
                CookieUtils.readCookieByName("username", cookies);
        if(usernameCookie != null) {
            //2. 将其生命周期设置为0
            usernameCookie.setMaxAge(0);
            //3. 重新保存该cookie, 因为你将其生命周期设置0, 就等价于让浏览器删除该cookie
            //4. 说明：该cookie会被浏览器直接删除
            //   返回一个Set-Cookie: xxxxx => 一会抓包.
            //   Set-Cookie: username=tom; Expires=Thu, 01-Jan-1970 00:00:10 GMT
            response.addCookie(usernameCookie);//返回一个Set-Cookie: xxxxx => 一会抓包.
        }else{
            System.out.println("没有找到该cookie, 无法删除...");
        }

        /***********************
         * 默认的会话级别的 Cookie [即浏览器关闭就销毁了]
         * 前面我们讲课时，都是默认会话级别的生命周期
         ***********************/
        Cookie cookie3 = new Cookie("dkey", "dkey_value");
        /**
         * 老韩解读 setMaxAge源码
         * public void setMaxAge(int expiry) {
         *         this.maxAge = expiry;
         * }
         * private int maxAge = -1; 默认就是-1
         */
        //cookie.setMaxAge(-1);//设置存活时间
        response.addCookie(cookie3);


        // 给浏览器返回信息
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>设置cookie生命周期</h1>");
        writer.flush();
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
