package com.hspedu.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class HspServletContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {

        System.out.println("HspServletContextAttributeListener 监听到添加属性.."
                + servletContextAttributeEvent.getName() + "=" + servletContextAttributeEvent.getValue() );
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {

        System.out.println("HspServletContextAttributeListener 监听到删除属性.."
                + servletContextAttributeEvent.getName() + "=" + servletContextAttributeEvent.getValue() );
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {

        System.out.println("HspServletContextAttributeListener 监听到修改属性.."
                + servletContextAttributeEvent.getName() + "=" + servletContextAttributeEvent.getValue() );

    }
}
