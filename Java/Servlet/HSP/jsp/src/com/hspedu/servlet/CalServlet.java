package com.hspedu.servlet;

import com.hspedu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CalServlet 被调用...");
        //思路 ==> 代码
        //1. 是Servlet
        //2. 接收数据
        //String num1 = request.getParameter("num1");
        //String num2 = request.getParameter("num2");
        //进行转换->int
        double num1 = WebUtils.parseDouble(request.getParameter("num1"), 0);
        double num2 = WebUtils.parseDouble(request.getParameter("num2"), 0);
        String oper = request.getParameter("oper");
        double res = 0; //使用变量来接收运算结果
        //3. 完成计算
        if ("+".equals(oper)) {
            res = num1 + num2;
        } else if ("-".equals(oper)) {
            res = num1 - num2;
        } else if ("*".equals(oper)) {
            res = num1 * num2;
        } else if ("/".equals(oper)) {
            res = num1 / num2;
        } else {
            System.out.println(oper + " 不正确...");
        }
        //4. 把结果保存到域对象[request, session, servletContext]
        //   老韩解读：因为一次请求对应一次计算, 所以我建议将结果保存到request
        //   老韩的思路: 把结果组织到一个字符串中., 方便我们在下一个页面显示
        //   java基础: String.format ,可以格式化字符串
        String formatRes = String.format("%s %s %s = %s", num1, oper, num2, res);
        request.setAttribute("res", formatRes);
        //System.out.println("formatRes= " + formatRes);
        //5. 转发到显示页面 calRes.jsp
        request.getRequestDispatcher("/cal/calRes.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
