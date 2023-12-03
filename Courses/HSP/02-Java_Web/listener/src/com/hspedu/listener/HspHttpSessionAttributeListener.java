package com.hspedu.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class HspHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        //HttpSession session = httpSessionBindingEvent.getSession();
        System.out.println("HspHttpSessionAttributeListener 监听到session添加属性" +
                httpSessionBindingEvent.getName() + "=" + httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();

        System.out.println("HspHttpSessionAttributeListener 监听到session删除属性" +
                httpSessionBindingEvent.getName());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

        System.out.println("HspHttpSessionAttributeListener 监听到session修改属性" +
                httpSessionBindingEvent.getName() + "=" + httpSessionBindingEvent.getValue());
    }
}
