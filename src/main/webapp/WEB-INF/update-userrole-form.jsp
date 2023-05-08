<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Role</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:import url="header.jsp"></c:import>
<div class="d-flex justify-content-center align-items-center h-50">
    <div class="card">
        <div class="card-body">
            <h1 class="card-title text-center mb-3">Update Role</h1>
            <form method="post" action="${pageContext.request.contextPath}/auth/update-user">
                <div class="mb-3">
                    <input type="hidden" class="form-control" name="id" value="${id}">
                </div>
                <div class="mb-3">
                    <input type="hidden" class="form-control" name="password" value="${password}">
                </div>
                <div class="mb-3">
                    <input type="hidden" class="form-control" name="fullName" value="${fullName}">
                </div>
                <div class="mb-3">
                    <input type="hidden" class="form-control" name="email" value="${email}">
                </div>
                <div class="mb-3">
                    <input type="hidden" class="form-control" name="address" value="${address}">
                </div>
                <div class="mb-3">
                    <input type="hidden" class="form-control" name="phoneNumber" value="${phoneNumber}">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" name="username" value="${username}" placeholder="Username">
                </div>
                <div class="mb-3">
                    <select name="idRole" class="form-select" aria-label="Default select example">
                        <option selected>Choose role</option>
                        <option value="2">Admin</option>
                        <option value="3">Client</option>
                    </select>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>

</html>
