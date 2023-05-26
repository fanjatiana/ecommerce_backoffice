<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Category</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container my-5">
<h1 class="mb-4">Update Category</h1>
<form method="post" action="${pageContext.request.contextPath}/auth/update-category">
    <div class="input-group mb-3">
        <input type="hidden" class="form-control" name="id" value="${id}">
    </div>
    <div class="mb-3">
        <label for="nameCategory" class="form-label">Category Name:</label>
        <input type="text" class="form-control" name="nameCategory" id="nameCategory" placeholder="Category Name...">
    </div>

    <div class="mb-3">
        <label for="descriptionCategory" class="form-label">Category Description:</label>
        <textarea class="form-control" name="descriptionCategory" id="descriptionCategory" placeholder="Category Description..."></textarea>
    </div>

    <div class="input-group">
        <button type="submit" class="btn btn-primary">Submit</button>
    </div>
</form>
</div>
</body>
</html>
