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
    <title>List of products</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="container">
    <h1>List of Products</h1>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>Product name</th>
                <th>Product description</th>
                <th>Product Price</th>
                <th>Product photo</th>
                <th>Category name</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.getIdProduct()}</td>
                    <td>${product.getNameProduct()}</td>
                    <td>${product.getDescriptionProduct()}</td>
                    <td>${product.getPriceProduct()}</td>
                    <td>
                        <img src="${pageContext.request.contextPath.substring(0, pageContext.request.contextPath.lastIndexOf("/"))}/images/${product.getPhotoProduct()}" alt="${product.getNameProduct()}" width="100px">
                    </td>
                    <td>${product.getCategory().getNameCategory()}</td>
                    <td>
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/auth/update-product?id=${product.getIdProduct()}">Edit</a>
                    </td>
                    <td>
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/auth/delete-product?id=${product.getIdProduct()}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
</div>
</body>
</html>
