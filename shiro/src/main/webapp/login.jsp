<%--
  Created by IntelliJ IDEA.
  User: zhanghongkai
  Date: 2019/4/11
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <form action="/login.action" method="post">
        <span>用户名：</span><input type="text" name="username"><br>
        <span>密码：</span><input type="password" name="password"><br>
        <input type="submit" value="登录">
        <div style="color: red;"><%=request.getAttribute("errorMsg")%></div>
    </form>
</body>
</html>
