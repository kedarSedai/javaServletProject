<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 8/9/2023
  Time: 8:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form action="user?page=register" method="POST">
    <div class="container">
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" name="userName" class="form-control" id="username">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <input type="text" name="address" class="form-control" id="address">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1">
        </div>
        <a href="../index.jsp"><b>Already a Member?</b></a>
        <button type="submit" class="btn btn-primary">Register</button>
    </div>
</form>

</body>
</html>
