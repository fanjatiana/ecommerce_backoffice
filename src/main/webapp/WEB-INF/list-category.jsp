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
    <title>List Category</title>
</head>
<body>
<h1>List Category</h1>
<table border="1" width="90%">
    <tr><th>idCategory</th><th>nameCategory</th><th>descriptionCategory</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach items="${categories}" var="category">
        <tr><td>${category.getIdCategory()}</td><td>${category.getNameCategory()}</td><td>${category.getDescriptionCategory()}</td><td><a href="${pageContext.request.contextPath}/update-category?id=${category.getIdCategory()}">Edit</a></td><td><a href="${pageContext.request.contextPath}/delete-category?id=${category.getIdCategory()}">Delete</a></td></tr>
    </c:forEach>
</table>
</body>
</html>
