<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Category</title>
</head>
<body>
<h1>Update Category</h1>
<form method="post" action="${pageContext.request.contextPath}/update-category">
    <div class="input-group mb-3">
        <input type="hidden" class="form-control" name="id" value="${id}">
    </div>
    <div class="input-group mb-3">
        <input type="text" class="form-control" name="nameCategory" value="${nameCategory}" placeholder="Cat Product...">
    </div>

    <div class="input-group mb-3">
        <input type="text" class="form-control" name="descriptionCategory" value="${descriptionCategory}" placeholder="Cat Product...">
    </div>
    <div class="input-group">
        <button type="submit" class="btn btn-outline-dark">Submit</button>
    </div>

</form>
</body>
</html>
