package com.hspedu.servlet.servletcontext;

import javax.servlet.ServletContext;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class WebUtils {

    //这个方法就是对访问的次数累积，同时返回次数
    public static Integer visitCount(ServletContext servletContext) {
        //从servletContext获取 visit_count 属性 k-v
        Object visit_count = servletContext.getAttribute("visit_count");
        //判断visit_count是否为null
        if (visit_count == null) {//说明是第1次访问网站
            servletContext.setAttribute("visit_count", 1);
            visit_count = 1;
        } else { //是第二次或以后
            //取出visit_count属性的值+1
            visit_count = Integer.parseInt(visit_count + "") + 1;
            //放回到servletContext
            servletContext.setAttribute("visit_count", visit_count);
        }

        return Integer.parseInt(visit_count + "");
    }
}
