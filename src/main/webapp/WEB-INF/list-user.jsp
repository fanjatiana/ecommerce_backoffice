<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container">
    <h1>List of Users</h1>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Username</th>
                <th>Full name</th>
                <th>Email</th>
                <th>Role</th>
                <th>Edit</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.getUsername()}</td>
                    <td>${user.getFullName()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getRole().getRoleName()}</td>
                    <td><a href="${pageContext.request.contextPath}/auth/update-user?id=${user.getIdUser()}">Edit role</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
</div>
</html>
