<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container my-5">
    <h1 class="mb-4">Add Product</h1>
    <form method="post" action="${pageContext.request.contextPath}/auth/add-product" enctype="multipart/form-data">
        <div class="mb-3">
            <label for="nameProduct" class="form-label">Product Name</label>
            <input type="text" class="form-control form-control-lg" id="nameProduct" name="nameProduct" placeholder="Enter product name" maxlength="50">
        </div>
        <div class="mb-3">
            <label for="descriptionProduct" class="form-label">Product Description</label>
            <textarea class="form-control" id="descriptionProduct" name="descriptionProduct" placeholder="Enter product description" rows="3"></textarea>
        </div>
        <div class="mb-3">
            <label for="PriceProduct" class="form-label">Product Price</label>
            <input type="text" class="form-control" id="PriceProduct" name="PriceProduct" placeholder="Enter product price" maxlength="10">
        </div>
        <div class="mb-3">
            <label for="photoProduct" class="form-label">Product Photo</label>
            <input type="file" class="form-control" id="photoProduct" name="photoProduct">
        </div>
        <div class="mb-3">
            <label for="idCategory" class="form-label">Product Category</label>
            <select name="idCategory" id="idCategory" class="form-select">
                <c:forEach items="${categories}" var="category">
                    <option value="${category.idCategory}">${category.nameCategory}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
