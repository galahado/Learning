package com.hspedu.ajax.servlet;

import com.google.gson.Gson;
import com.hspedu.ajax.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckUserServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接收jquery发送的ajax数据
        String username = request.getParameter("username");

        response.setContentType("text/json;charset=utf-8");
        Gson gson = new Gson();
        if ("king".equals(username)) {
            //要求同学们 把验证业务接入到DB
            User user = new User(100, "king", "abc", "king@sohu.com");
            response.getWriter().write(gson.toJson(user));
        } else {
            //返回一个不存在的User=> 这里老师是有设计
            User user = new User(-1, "", "", "");
            response.getWriter().write(gson.toJson(user));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
