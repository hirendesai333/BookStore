<%--
  Created by IntelliJ IDEA.
  User: hirendesai
  Date: 2023-01-23
  Time: 6:56 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.sendRedirect(request.getContextPath() + "/books/*");
%>
</body>
</html>
