<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>LMS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form action="user?page=login" method="POST">
    <div class="container">
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" name="userName" class="form-control" id="username">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1">
        </div>
        <a href="user?page=newUser"><b>New User Register?</b></a>
        <button type="submit" class="btn btn-primary">Login</button>

    </div>
</form>
</body>
</html>