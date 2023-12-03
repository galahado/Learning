<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>c:set标签的使用</title>
</head>
<body>
<h1>c:set标签的使用</h1>
<%--<%--%>
<%--    //Java代码--%>
<%--    request.setAttribute("email", "hsp@sohu.com");--%>
<%--%>--%>
<%--老韩解读
    <c:set /> set 标签可以往域中保存数据
    1. 等价 域对象.setAttribute(key,value);
    2. scope 属性设置保存到哪个域
            page 表示 PageContext 域（默认值）
            request 表示 Request 域
            session 表示 Session 域
            application 表示 ServletContext 域
    3. var 属性设置 key 是什么
    4. value 属性设置值
--%>
<c:set scope="request" var="name" value="韩顺平教育~"></c:set>
c:set-name的值${requestScope.name}
</body>
</html>
