<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 8/15/2023
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>userDetails</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <td>${user.id}</td>
    </tr>
    <tr>
        <th>userName</th>
        <td>${user.userName}</td>
    </tr>
    <tr>
        <th>Email</th>
        <td>${user.email}</td>
    </tr>
    <tr>
        <th>Address</th>
        <td>${user.address}</td>
    </tr>
    <tr>
        <th>Password</th>
        <td>${user.password}</td>
    </tr>
    <tr>
        <td><a href="user?page=deleteUser&id=${user.id}">DELETE</a></td>
        <td><a href="user?page=editUser&id=${user.id}">Edit</a></td>
    </tr>
</table>
</body>
</html>
