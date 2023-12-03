package com.hspedu.servlet;

import com.hspedu.entity.Monster;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 准备要显示的数据--> 从DB
        ArrayList<Monster> list = new ArrayList<>();
        list.add(new Monster(100, "牛魔王", "芭蕉扇"));
        list.add(new Monster(200, "狐狸精", "美人计"));
        list.add(new Monster(300, "白骨精", "吃人骨头"));

        //2. 把list放入到request域, 供jsp页面使用
        request.setAttribute("monsters", list);
        //3. 请求转发 list.jsp
        request.getRequestDispatcher("/hm/list.jsp")
                .forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
