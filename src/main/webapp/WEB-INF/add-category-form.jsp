<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container my-5">
    <h1 class="mb-4">Add Category</h1>
    <form method="post" action="${pageContext.request.contextPath}/auth/add-category">
        <div class="mb-3">
            <label for="nameCategory" class="form-label">Category Name</label>
            <input type="text" class="form-control form-control-lg" id="nameCategory" name="nameCategory" placeholder="Enter category name" maxlength="50" pattern="[a-zA-Z0-9 ]+" title="The category name must only contain letters, numbers, and spaces.">
        </div>
        <div class="mb-3">
            <label for="descriptionCategory" class="form-label">Category Description</label>
            <input class="form-control" type="text" id="descriptionCategory" name="descriptionCategory" placeholder="Enter category description" maxlength="200" pattern="[a-zA-Z0-9 ]+" title="The category description must only contain letters, numbers, and spaces.">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
