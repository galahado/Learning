<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>计算结果</title>
</head>
<body>
<h1>计算结果</h1>
<%=request.getAttribute("res")%><br/>
<%--<a href="/jsp/cal/calUI.jsp">返回重新来玩一把</a>--%>
<a href="<%=request.getContextPath()%>/cal/calUI.jsp">返回重新来玩一把~</a>
</body>
</html>
