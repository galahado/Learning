package com.hspedu.filter;

import javax.servlet.*;
import java.io.IOException;

public class TopicFilter implements Filter {

    //属性-> 存放禁用词
    private String[] forbiddenWords = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取禁用词
        String forbiddenword = filterConfig.getInitParameter("forbiddenword");
        forbiddenWords = forbiddenword.split(",");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //解决从topic.jsp 提交的中文乱码问题
        servletRequest.setCharacterEncoding("utf-8");

        //判断评论是不是有禁用词
        String content = servletRequest.getParameter("content");
        //循环遍历一把，看看有没有禁用词
        for (String forbiddenWord : forbiddenWords) {//java基础
            if (content.contains(forbiddenWord)) {
                //返回topic.jsp
                servletRequest.setAttribute("errorInfo", "你输入的有禁用词");
                servletRequest.getRequestDispatcher("/topic.jsp")
                        .forward(servletRequest, servletResponse);
                return;//返回
            }
        }

        //继续到目标
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
