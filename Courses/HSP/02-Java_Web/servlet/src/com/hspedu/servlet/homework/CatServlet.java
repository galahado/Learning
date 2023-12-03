package com.hspedu.servlet.homework;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class CatServlet implements Servlet {


    //定义一个记录访问次数的变量
    private int count = 0;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        //一个快捷键 可以快速的在访问的文件切换  ctrl + alt + <- 回到上次访问的位置
        //ctrl + alt + -> 反向
        //访问的方式
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println("访问的方式= " + httpServletRequest.getMethod());

        System.out.println("访问CatServlet的次数= " + (++count));
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
