package com.hspedu.servlet.servletcontext;

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
public class ServletContext_ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取web.xml的context-parameter

        //1.获取到ServletContext对象
        ServletContext servletContext = getServletContext();
        //2. 获取website
        String website = servletContext.getInitParameter("website");
        String company = servletContext.getInitParameter("company");
        //3. 获取项目的工程路径
        String contextPath = servletContext.getContextPath();
        //4. 获取项目发布会，正在的工作路径
        //   /表示我们的项目(发布后)的 根路径 D:\hspedu_javaweb\servlet\out\artifacts\servlet_war_exploded
        String realPath = servletContext.getRealPath("/");
        System.out.println("项目路径= " + contextPath);// /servlet
        System.out.println("website= " + website);
        System.out.println("company= " + company);
        System.out.println("项目发布后的绝对路径= " + realPath);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
