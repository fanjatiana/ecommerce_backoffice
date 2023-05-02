<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h1>Add Product</h1>
<form method="post" action="${pageContext.request.contextPath}/add-product">
    <div class="input-group mb-3">
        <input type="text" class="form-control" name="nameProduct" placeholder="Name Product...">
    </div>

    <div class="input-group mb-3">
        <input type="text" class="form-control" name="descriptionProduct" placeholder="descriptionProduct...">
    </div>
    <div class="input-group mb-3">
        <input type="text" class="form-control" name="PriceProduct" placeholder="PriceProduct...">
    </div>
    <div class="input-group mb-3">
        <input type="text" class="form-control" name="photoProduct" placeholder="photoProduct...">
    </div>
    <div class="input-group mb-3">
        <select name="idCategory" class="form-select">
            <c:forEach items="${categories}" var="category">
                <option value="${category.idCategory}">${category.nameCategory}</option>
            </c:forEach>
        </select>
    </div>
    <div class="input-group mb-3">
        <textarea class="form-control" name="content" placeholder="Your content.."></textarea>
    </div>
    <div class="input-group">
        <button type="submit" class="btn btn-outline-dark">Submit</button>
    </div>
</form>
</body>
</html>
