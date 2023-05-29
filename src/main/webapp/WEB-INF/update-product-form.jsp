<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container my-5">
<h1 class="mb-4">Update Product</h1>
<form method="post" action="${pageContext.request.contextPath}/auth/update-product" enctype="multipart/form-data">
    <div class="mb-3">
        <input type="hidden" class="form-control" name="id" id="id" value="${id}">
    </div>
    <div class="mb-3">
        <label for="nameProduct" class="form-label">Name Product</label>
        <input type="text" class="form-control" name="nameProduct" id="nameProduct" value="${nameProduct}" placeholder="Name Product..." maxlength="50" pattern="[a-zA-Z0-9 ]+" title="The product name must only contain letters, numbers, and spaces.">
    </div>
    <div class="mb-3">
        <label for="descriptionProduct" class="form-label">Description Product</label>
        <input type="text" class="form-control" name="descriptionProduct" id="descriptionProduct" placeholder="Description Product..." maxlength="200" pattern="[a-zA-Z0-9 ]+" title="The product description must only contain letters, numbers, and spaces.">
    </div>
    <div class="mb-3">
        <label for="priceProduct" class="form-label">Price Product</label>
        <input type="text" class="form-control" name="priceProduct" id="priceProduct" placeholder="Price Product..." pattern="[0-9]+(\.[0-9]{1,2})?" title="The product price must be a valid number (e.g., 10 or 10.99).">
    </div>
    <div class="mb-3">
        <label for="photoProduct" class="form-label">Photo Product</label>
        <input type="file" class="form-control" name="photoProduct" id="photoProduct">
    </div>
    <div class="mb-3">
        <label for="idCategory" class="form-label">Category</label>
        <select name="idCategory" id="idCategory" class="form-select">
            <c:forEach items="${categories}" var="category">
                <option value="${category.idCategory}">${category.nameCategory}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <button type="submit" class="btn btn-primary">Submit</button>
    </div>
</form>
</div>
</body>
</html>
