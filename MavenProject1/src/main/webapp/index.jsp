<%--
  Created by IntelliJ IDEA.
  User: littl
  Date: 2020/5/31
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>maven</title>
</head>
<body>
    Hello,maven!
    <form action="${pageContext.request.contextPath}/ServletDemo1" method="get">
        <input type="text" name="cmd">
        <input type="submit" name="submit">
    </form>
</body>
</html>
