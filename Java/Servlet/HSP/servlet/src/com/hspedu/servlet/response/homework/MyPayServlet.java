package com.hspedu.servlet.response.homework;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class MyPayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("MyPayServlet 被调用...");
        //得到金额
        String money = request.getParameter("money");
        System.out.println("money= " + money.getClass());
        //转成int
        //处理一下这个异常
        int iMoney = WebUtils.parseString(money);
        ServletContext servletContext = getServletContext();
        if(iMoney > 100) {
            //重定向到payok.html
            //servletContext.getContextPath() 就是 /servlet
            response.sendRedirect(servletContext.getContextPath() + "/payok.html");
        } else {
            response.sendRedirect(servletContext.getContextPath() + "/pay.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
