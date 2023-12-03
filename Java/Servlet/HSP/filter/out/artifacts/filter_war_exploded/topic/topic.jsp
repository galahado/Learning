<%--
  Created by IntelliJ IDEA.
  User: 韩顺平
  Version: 1.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>发表对阿凡达电影评论</h1>
过滤词: 苹果, 香蕉
<form method="post" action="<%=request.getContextPath()%>/topicServlet">
    用户: <input type="text" name="username"><br/>
    评论: <textarea rows="10" name="content" cols="10"></textarea>
    <input type="submit" value="发表评论">
</form>
</body>
</html>
