package com.hspedu.servlet.annotation;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpsServer;

import javax.servlet.annotation.WebServlet;
import java.util.HashMap;

/**
 * @author 韩顺平
 * @version 1.0
 * 模拟一把Tomcat是如果通过 @WebServlet(urlPatterns = {"/ok1", "/ok2"})
 * 来装载一个Servlet的
 *
 * 说明：这代码主要的目的，就是打破 注解的神秘感
 */
public class TestAnnotationServlet {

    private static final HashMap<String, Object> hm = new HashMap<>();

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        //1. 首先要得到扫描的包 路径 io, 进而得到类的全路径
        String classAllPath = "com.hspedu.servlet.annotation.OkServlet";
        //2. 得到 OkServlet的Class对象
        Class<?> aClass = Class.forName(classAllPath);
        //3. 通过class对象，得到Annotation
        WebServlet annotation = aClass.getAnnotation(WebServlet.class);
        System.out.println(annotation);
        String[] strings = annotation.urlPatterns();
        for (String url : strings) {
            System.out.println("url= " + url);
        }

        //如果匹配url,如果是第一次，tomcat就会创建一个OkServlet实例，放入到hashmap
        Object instance = aClass.newInstance();
        System.out.println("instance= " + instance);//OkServlet

        //简单的模拟，没有深入.
        hm.put("OkServlet", instance);

        System.out.println(hm);

    }
}
