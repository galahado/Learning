package com.hspedu.servlet.homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class DogServlet extends HttpServlet {

    //定义两个变量
    private int getCount = 0;
    private int postCount = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("DogServlet doPost 访问次数= " + (++postCount));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("DogServlet doGet 访问次数= " + (++getCount));
    }
}
