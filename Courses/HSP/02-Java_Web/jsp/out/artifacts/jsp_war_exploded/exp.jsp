<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表达式脚本的使用</title>
</head>
<body>
<h1>个人信息</h1>
<%
    String name = "老韩";
    String email = request.getParameter("email");
%>
用户名: <%=name%><br/>
工作是: <%="java工程师"%><br/>
年龄: <%=request.getParameter("age")%><br/>
电邮: <%=email%>
</body>
</html>
