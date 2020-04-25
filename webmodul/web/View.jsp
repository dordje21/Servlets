<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 22.04.2020
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="jsp.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="Student" class="jsp.Student" scope="request"/>
<%--    <jsp:useBean id="Student" class="Student" scope="session"/>--%>
<%--    <jsp:useBean id="Student" class="Student" scope="application"/>--%>
    <jsp:getProperty name="Student" property="name"/>
    <jsp:getProperty name="Student" property="age"/>
    <br>
    ${list[0]}
    ${list[1]}
    <br>
    ${map.one}
    ${map["two"]}
    <br>
    ${cookie.JSESSIONID}

</body>
</html>
