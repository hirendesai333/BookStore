<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>

<%--to include JSTL tags in JSP page--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Book List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
%>
<%@ include file="Header.jsp" %>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Title</th>
            <th scope="col">Author</th>
            <th scope="col">Price</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${book_list}" var="item">
            <tr>
                <td>${item.getTitle()}</td>
                <td>${item.getAuthor()}</td>
                <td>${item.getPrice()}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>
