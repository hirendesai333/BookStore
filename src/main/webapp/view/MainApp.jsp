<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>BookApp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <style>
        .form-centre {
            margin: auto;
            width: 50%;
        }
    </style>
</head>

<body>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
%>

<form class="form-centre" action="/LoginServlet" method="post">
    <div class="jumbotron">
        <div class="container">
            <div id="links">
                <div style="text-align: center;">
                    <h1>Login</h1>
                </div>
            </div>
        </div>
    </div>
    <div class="form-outline mb-4">
        <label class="form-label" for="form2Example1">Name:</label>
        <input type="text" id="form2Example1" class="form-control" name="name"/>
    </div>

    <div class="form-outline mb-4">
        <label class="form-label" for="form2Example2">Password:</label>
        <input type="password" id="form2Example2" class="form-control" name="password"/>
    </div>

    <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

</form>

</body>
</html>
