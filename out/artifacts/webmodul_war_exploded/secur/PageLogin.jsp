<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 24.04.2020
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="j_security_check" method="post">
        <input type="text" name="j_username"/><br>
        <input type="password" name="j_password"/><br>
        <input type="submit" value="login"/>
    </form>
</body>
</html>
