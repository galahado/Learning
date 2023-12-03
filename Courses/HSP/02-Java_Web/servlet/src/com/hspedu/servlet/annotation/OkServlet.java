package com.hspedu.servlet.annotation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 韩顺平
 * @version 1.0
 * 注解的方式来配置
 */

/**
 * 老韩解读
 * 老韩的小技巧: 显示方法之间的分割线
 * 1. @WebServlet 是一个注解 => java基础->注解
 * 2. @WebServlet 源码
 * @Target({ElementType.TYPE})
 * @Retention(RetentionPolicy.RUNTIME)
 * @Documented => 在javadoc工具生成文档有记录
 * public @interface WebServlet {
 *     String name() default "";
 *
 *     String[] value() default {};
 *
 *     String[] urlPatterns() default {};
 *
 *     int loadOnStartup() default -1;
 *
 *     WebInitParam[] initParams() default {};
 *
 *     boolean asyncSupported() default false;
 *
 *     String smallIcon() default "";
 *  }
 *  3. urlPatterns 对应 web.xml 的 <url-pattern></url-pattern>
 *  4. {"/ok1", "/ok2"} 可以给OkServlet配置多个 url-pattern
 *  5. 相当于这个@WebServlet(urlPatterns = {"/ok1", "/ok2"}) 代替了 web.xml的配置
 *     底层使用了 反射+注解+IO+集合 来完成一个支撑
 *  6. 浏览器可以这样访问OkServlet时，可以 http://localhost:8080/servlet/ok1 或者
 *     http://localhost:8080/servlet/ok2
 *  7. 同学们有很多小问号? 解密. => 一会老师再说.
 *  8. 我们可以根据 @interface WebServlet 源码知道可以配置哪些
 *  web.xml init-param 在注解中，如何指定呢? 老师看了源码，老师搞定
 *          <init-param>
 *             <param-name></param-name>
 *             <param-value></param-value>
 *         </init-param>
 *  9. 注解方式开发Servlet和 web.xml配置servlet 流程机制是一样
 *  10. /ok1/aa /ok1/bb /ok1/cc /ok1/aa/bb/cc /ok2
 *  11. *.action 这时 zs.action ls.action
 *  12. http://localhost:8080/servlet/register.html
 */
@WebServlet(urlPatterns = {"/ok1/aa"})
public class OkServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("注解方式 OkServlet init()被调用");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("注解方式 OkServlet doPost()");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(10/0);//报错
        System.out.println("注解方式 OkServlet doGet()");
        System.out.println(req.getRemoteAddr());
    }

}
