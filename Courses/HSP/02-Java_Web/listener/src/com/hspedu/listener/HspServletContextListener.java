package com.hspedu.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionListener;

/**
 * 老韩解读
 * 1. 当一个类实现了 ServletContextListener
 * 2. 该类就是一个监听器
 * 3. 该类可以监听的事件 由该类实现的监听接口决定 ，比如 实现ServletContextListener
 *    , 则该类就可以监听 ServletContext对象的创建和销毁, 以此类推
 * 4. HspServletContextListener 就是一个监听者
 * 5. 当web应用启动时，就会产生 ServletContextEvent 事件, 会调用监听器的对应事件处理方法
 *    contextInitialized, 同时会传递 事件对象
 * 6. 程序员可以通过 ServletContextEvent 事件对象，来获取需要的信息, 然后再进行业务处理
 * 7. tomcat怎么知道这个监听器存在 ? 因为我们需要在web.xml中配置
 */
public class HspServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        System.out.println("HspServletContextListener 监听到 " +
                servletContext + " 被创建..");
        //如果我们获取到ServletContext 对象..进行业务处理

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        System.out.println("HspServletContextListener 监听到 " +
                servletContext + " 被销毁..");

        //比如可以对servletContext 数据进行处理， 或者日志的管理...
        System.out.println("进行处理工作.....");
    }
}
