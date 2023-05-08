<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List of categories</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container">
    <h1>List of categories</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Id</th>
            <th>Category name</th>
            <th>Category description</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="category">
            <tr>
                <td>${category.getIdCategory()}</td>
                <td>${category.getNameCategory()}</td>
                <td>${category.getDescriptionCategory()}</td>
                <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/auth/update-category?id=${category.getIdCategory()}">Edit</a></td>
                <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/auth/delete-category?id=${category.getIdCategory()}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
