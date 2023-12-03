<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理后台登录</title>
</head>
<body>
<h1>管理后台登录</h1>
<%
    System.out.println("request=" + request);
%>
<form action="<%=request.getContextPath() %>/loginCheckServlet" method="post">
    u：<input type="text" name="username"/> <br/><br/>
    p：<input type="password" name="password"/> <br/><br/>
    <input type="submit" value="用户登录"/></form>
</body>
</html>
