<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 8/15/2023
  Time: 7:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>UserList</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">userName</th>
            <th scope="col">email</th>
            <th scope="col">address</th>
            <th scope="col">Password</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.email}</td>
                <td>${user.address}</td>
                <td>${user.password}</td>
                <td><a href="user?page=userDetails&id=${user.id}"> User Details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>
