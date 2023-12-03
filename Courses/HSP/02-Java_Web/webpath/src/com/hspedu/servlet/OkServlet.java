package com.hspedu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //老韩多说一句:
        //1. 我们程序员应该学会自己灵活的配置快捷键(按你的习惯)
        //2. 默认的是shift+f10[我记不住]=> 改成自己习惯的alt+r
        //3. 怎么该，file->settings->keymap -> 输入 run -> 找到
        //   Shift+F10-> 改成自己习惯的, -> 为了不破坏原来的快捷键-> leave
        //4. 回到主线
        System.out.println("OkServlet 被调用..");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
