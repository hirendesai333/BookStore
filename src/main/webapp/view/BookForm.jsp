<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" http-equiv="Content-type" content="text/html">
    <title>Book Form</title>
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

    <form name="book_form" action="insert" method="post">
        <div class="form-group">
            <label>Title:</label>
            <input type="text" name="bookTitle">
        </div>
        <div class="form-group">
            <label>Author:</label>
            <input type="text" name="bookAuthor">
        </div>
        <div class="form-group">
            <label>Price:</label>
            <input type="text" name="bookPrice">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

</div>

</body>
</html>