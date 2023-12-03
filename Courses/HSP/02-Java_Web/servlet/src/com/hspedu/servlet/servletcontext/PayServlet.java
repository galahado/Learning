package com.hspedu.servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取到ServletContext对象
        ServletContext servletContext = getServletContext();
        // System.out.println("PayServlet servletContext= " +
        //         servletContext + " 运行类型=" + servletContext.getClass());
        //
        // //从servletContext获取 visit_count 属性 k-v
        // Object visit_count = servletContext.getAttribute("visit_count");
        // //判断visit_count是否为null
        // if (visit_count == null) {//说明是第1次访问网站
        //     servletContext.setAttribute("visit_count", 1);
        //     visit_count = 1;
        // } else { //是第二次或以后
        //     //取出visit_count属性的值+1
        //     visit_count = Integer.parseInt(visit_count + "") + 1;
        //     //放回到servletContext
        //     servletContext.setAttribute("visit_count", visit_count);
        // }
        Integer visit_count = WebUtils.visitCount(servletContext);
        //输出显示
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<h1>新网站被访问的次数是" + visit_count + "</h1>");
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
