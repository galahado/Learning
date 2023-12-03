package com.hspedu.http.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 韩顺平
 * @version 1.0
 * LoginServlet
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<h1>POST登录成功~~</h1>");
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //服务端输出
        System.out.println("LoginServlet doGet() 被调用");
        //输出一句话, 返回给浏览器
        //1. 通response 获取流 PrintWriter, 可以给浏览器回复数据
        //2. 为了让浏览器显示中文，需要告诉浏览器，我们的编码是utf-8
        //老韩解读: (1) 给会送数据设置编码 (2) text/html这个是MIME即告诉浏览器返回的数据
        //是 text类型下的html格式数据【MIME类型 大类型/小类型】(3)charset=utf-8数据编码
        //小小细节: 设置编码格式要在 response.getWriter()!!
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<h1>GET()登录成功~~</h1>");

        //为了确保数据返回，可以把 flush()和close()
        //程序员有强迫症
        //flush() 方法表示将缓存的数据进行刷新
        writer.flush();
        //close() 表示关闭流,及时释放资源,  有些语言是 close() 有 flush()
        writer.close();


    }
}
