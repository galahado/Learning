<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el的运算符</title>
</head>
<body>
<h1>el的运算符</h1>
<%
    request.setAttribute("num1", 90);
    request.setAttribute("num2", 30);
%>
num1+num2=${num1 + num2}<br/>
num1>num2=${num1 > num2}<br/>
</body>
</html>
