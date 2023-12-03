<%@ page import="java.io.PrintWriter" %>
<%@ page import="org.apache.jasper.runtime.HttpJspBase" %><%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  jsp的模板如何定制，一会再说明
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp的简单的求和计算器</title>
</head>
<body>
<h1>jsp的简单的求和计算器</h1>
<%
    //老韩解读
    //1. 在jsp的 该标签中, 可以写java代码

    int i = 10;
    int j = 20;
    int res = i + j;

    //2. jsp 中内置对象，可以直接使用, 比如 out
    //   老韩小技巧：先死后活 ctrl + alt + l
    out.println(i + " + " + j + " = " + res);
    //3. 老师说明，如果要看HttpJspBase类的关系, 需要引入一个包， alt+enter

    //在java片段中,仍然是java的注释
    String email = "xx@qq.com";
    /*
        多行注释
     */
    HttpJspBase

%>
<%--email: <%=email%>--%>
<!--html注释 -->
</body>
</html>
