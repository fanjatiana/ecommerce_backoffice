<%--
  Created by IntelliJ IDEA.
  User: ayoub
  Date: 26/04/2023
  Time: 01:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List user</title>
</head>
<body>
<h1>List user</h1>
<table border="1" width="90%">
    <tr><th>idUser</th><th>username</th><th>fullName</th><th>email</th><th>address</th><th>phoneNumber</th><th>roleName</th><th>Edit</th></tr>
    <c:forEach items="${users}" var="user">
        <tr><td>${user.getIdUser()}</td><td>${user.getUsername()}</td><td>${user.getFullName()}</td><td>${user.getEmail()}</td><td>${user.getAddress()}</td><td>${user.getPhoneNumber()}</td><td>${user.getRole().getRoleName()}</td><td><a href="${pageContext.request.contextPath}/update-user?id=${user.getIdUser()}">Edit role</a></td></tr>
    </c:forEach>
</table>
</body>
</html>
