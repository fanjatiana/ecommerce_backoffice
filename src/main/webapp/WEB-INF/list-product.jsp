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
    <title>List product</title>
</head>
<body>
<h1>List Category</h1>
<table border="1" width="90%">
    <tr><th>id</th><th>nameProduct</th><th>descriptionProduct</th><th>PriceProduct</th><th>selectedProduct</th><th>photoProduct</th><th>idCategory</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach items="${products}" var="product">
        <tr><td>${product.getIdProduct()}</td><td>${product.getNameProduct()}</td><td>${product.getDescriptionProduct()}</td><td>${product.getPriceProduct()}</td><td>${product.isSelectedProduct()}</td><td>${product.getPhotoProduct()}</td><td>${product.getCategory().getNameCategory()}</td><td><a href="${pageContext.request.contextPath}/update-product?id=${product.getIdProduct()}">Edit</a></td><td><a href="${pageContext.request.contextPath}/delete-product?id=${product.getIdProduct()}">Delete</a></td></tr>
    </c:forEach>
</table>
</body>
</html>
