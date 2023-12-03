<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jstl的快速入门</title>
</head>
<body>
<h1>jstl的快速入门</h1>
<%--老韩解读
    1. c:if ... 类似
    2. if(10>2){
       out.println("<h1>10 > 2 成立~</h1>")
    }
--%>
<c:if test="${10 < 2}">
    <h1>10 > 2 成立~</h1>
</c:if>
</body>
</html>
