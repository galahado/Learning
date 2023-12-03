package com.hspedu.servlet.homework;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 韩顺平
 * @version 1.0
 * 听老韩.
 */
@WebServlet(urlPatterns = {"/pig1", "/pig2"}, loadOnStartup = 1)
public class PigServlet extends HttpServlet {

    private int getCount = 0;
    private int postCount = 0;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("PigServlet init() 被调用~");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //你是一个OOP程序员[潜台词是 一定要考虑使用对象方法]
        System.out.println("访问的浏览器的ip= " + req.getRemoteAddr());
        System.out.println("PigServlet 的 doPost方法被访问了 " + (++postCount));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问的浏览器的ip= " + req.getRemoteAddr());
        System.out.println("PigServlet 的 doGet方法被访问了 " + (++getCount));
    }
}
