package com.hspedu.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ReadSession2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("ReadSession2 被调用...");

        //1. 获取到session
        HttpSession session = request.getSession();
        System.out.println("ReadSession2 sid= " + session.getId());
        //2. 读取session的属性
        Object u = session.getAttribute("u");
        if (u != null) {
            System.out.println("读取到session属性 u= " + (String) u);
        } else {
            System.out.println("读取不到session属性 u 说明原来的session被销毁");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
