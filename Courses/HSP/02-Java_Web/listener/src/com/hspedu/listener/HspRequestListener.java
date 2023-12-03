package com.hspedu.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class HspRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("HspRequestListener 监听到 request对象创建");
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        System.out.println("记录访问日志....");
        System.out.println("访问IP= " + servletRequest.getRemoteAddr());
        System.out.println("访问的资源= " + ((HttpServletRequest)servletRequest).getRequestURL());
    }
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

        System.out.println("HspRequestListener 监听到 request对象被销毁");
    }


}
