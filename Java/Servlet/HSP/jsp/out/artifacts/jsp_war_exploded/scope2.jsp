<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope2.js</title>
</head>
<body>
<h1>在scope2页面获取数据的情况</h1>
pageContext-k1: <%=pageContext.getAttribute("k1")%><br/>
request-k1: <%=request.getAttribute("k1")%><br/>
session-k1: <%=session.getAttribute("k1")%><br/>
application-k1: <%=application.getAttribute("k1")%><br/>
</body>
</html>
