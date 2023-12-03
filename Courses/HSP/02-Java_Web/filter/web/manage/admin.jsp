<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>
    <base href="<%=request.getContextPath() %>/manage/"/>
</head>
<body>
<h1>后台管理</h1>
<%
    //验证request对象是和前面的filter是一个对象
    System.out.println("request=" + request);
%>
<a href="#">用户列表</a>||<a href="#">添加用户</a>||<a href="#">删除用户</a>
<hr/>
<img src="shunping.jpg" height="300"/>
</body>
</html>
