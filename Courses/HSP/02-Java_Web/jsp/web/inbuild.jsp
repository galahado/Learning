<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp内置对象</title>
</head>
<body>
<h1>jsp内置对象</h1>
<%
    //老韩梳理jsp的内置对象
    //out 类型是 JspWriter 父类就是 Writer.
    out.println("jsp out");
    //request是HttpServletRequest
    request.getParameter("age");
    //response就是 HttpServletResponse
    //response.sendRedirect("http://www.baidu.com");
    //session 就是 HttpSession
    session.setAttribute("job", "PHP工程师");
    //application类型就是ServletContext
    application.setAttribute("name", "老韩老师");
    //pageContext 可以存放数据(属性), 但是该数据只能在本页面使用
    pageContext.setAttribute("age", 100);
    //exception 异常对象 使用比较少
    //page 内置对象，类似 this
    out.println("page=" + page);
    //config 内置对象的类型就是ServletConfig
    String pwd = config.getInitParameter("pwd");


%>
</body>
age: <%=pageContext.getAttribute("age")%>
</html>
