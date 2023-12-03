<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope文件</title>
</head>
<body>
<%
    //在不同的域对象中，放入数据
    //老韩解读
    //1. 因为四个域对象，是不同的对象，因此name(key) 相同时，并不会冲突
    pageContext.setAttribute("k1", "pageContext数据(k1)");
    request.setAttribute("k1", "request数据(k1)");
    session.setAttribute("k1", "session数据(k1)");
    application.setAttribute("k1", "application数据(k1)");

    //做一个请求转发的操作
    //路径应该怎么写，请不清楚地小伙伴，去看韩老师讲的web路径专题
    //request.getRequestDispatcher("/scope2.jsp").forward(request, response);

    //做一个重定向
    String contextPath = request.getContextPath();//返回的就是 web路径=>/jsp
    //response.sendRedirect("/jsp/scope2.jsp");
    response.sendRedirect(contextPath + "/scope2.jsp");
%>
<h1>四个域对象，在本页面获取数据的情况</h1>
pageContext-k1: <%=pageContext.getAttribute("k1")%><br/>
request-k1: <%=request.getAttribute("k1")%><br/>
session-k1: <%=session.getAttribute("k1")%><br/>
application-k1: <%=application.getAttribute("k1")%><br/>
</body>
</html>
