<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>c:if标签使用</title>
</head>
<body>
<c:set scope="request" var="num1" value="20"></c:set>
<c:set scope="request" var="num2" value="10"></c:set>
<c:if test="${num1 > num2}">
    <h1>${num1} > ${num2}</h1>
</c:if>
</body>
</html>
