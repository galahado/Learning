package com.hspedu.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class HttpServletRequestMethods extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //这里我们使用request对象，获取表单提交的各种数据
        System.out.println("HttpServletRequestMethods doPost() 被调用..");

        /***********************************
         *  获取和http请求头相关信息
         ***********************************/

        System.out.println("请求的资源路径URI= " + request.getRequestURI());
        //http://主机/uri
        System.out.println("请求的统一资源定位符（绝对路径）URL= " + request.getRequestURL());
        System.out.println("请求的客户端ip 地址= " + request.getRemoteAddr());//本地就是127.0.01
        //思考题：如发现某个ip 在10s中，访问的次数超过 100次，就封ip
        //实现思路： 1用一个集合concurrentHashmap[ip:访问次数] 2[线程/定时扫描] 3 做成处理
        // 获取http请求头的信息，可以指定其他，比如 User-Agent , Host等待 老师就举一个例子
        System.out.println("http请求头HOST= " + request.getHeader("Host"));
        // 说明，如果我们希望得到请求的头的相关信息，可以使用request.getHeader("请求头字段")
        System.out.println("该请求的发起地址是= " + request.getHeader("Referer"));
        // 请获取访问网站的浏览器是什么？
        String userAgent = request.getHeader("User-Agent");
        System.out.println("User-Agent= " + userAgent);
        // 取出FireFox, 取出最后
        String[] s = userAgent.split(" ");
        System.out.println("浏览器=" + s[s.length - 1].split("\\/")[0]);
        //获取 Cookie
        // 	JSESSIONID=8CBBD23BDE01BAE6705E03C5C8916BD1

        String cookie = request.getHeader("Cookie");
        String JSESSIONID = cookie.split("=")[1];
        System.out.println("取出JSESSIONID= " + JSESSIONID);

        //课堂练习: 要求同学们取出  Windows NT 10.0  和 Win64
        // 主要是Get / Post
        System.out.println("http请求方式~= " + request.getMethod());
        /***********************************
         *  获取和请求参数相关信息, 注意要求在返回数据前，获取参数
         ***********************************/

        //解决接收参数的中文乱码问题, 老师提示，写在 getParameter前.
        request.setCharacterEncoding("utf-8");
        //1. 获取表单的数据[单个数据]
        //username=tom&pwd=&hobby=hsp&hobby=spls
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");


        //2. 获取表单一组数据
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("username= " + username);
        System.out.println("pwd= " + pwd);
        //增强for循环的快捷键 iter->回车即可 , 能使用快捷键，就使用快捷键
        for (String hobby : hobbies) {
            System.out.println("hobby=" + hobby);
        }

        //推而广之, 如果是 单选 , 下拉框 等等. => 作业布置

        //返回接收到的信息， 给浏览器回显
        //本质就是在http响应头，加上 Content-Type: text/html;charset=utf-8
        //说 text/html 表示返回的数据类型，浏览器会根据这个类型来解析数据
        // text/plain 表示返回的数据，请浏览器使用文本方式解析
        // application/x-tar 表示返回的是文件，浏览器就会以下载文件的方式处理
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<h1>提交的用户名= " + username + "</h1>");
        writer.flush();
        writer.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
