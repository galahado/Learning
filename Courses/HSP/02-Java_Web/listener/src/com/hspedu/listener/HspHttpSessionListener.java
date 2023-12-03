package com.hspedu.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HspHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        //当session创建时，我们给它设置一个生命周期 30s
        session.setMaxInactiveInterval(30);
        System.out.println("HspHttpSessionListener 监听到 session创建= " +
                session.getId());
        System.out.println("用户id=" + session.getId() + " 上线");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        System.out.println("HspHttpSessionListener 监听到 session销毁= " +
                session.getId());
        System.out.println("用户id=" + session.getId() + " 离线");
    }
}
