<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Role</title>
</head>
<body>
<h1>Update Role</h1>
<form method="post" action="${pageContext.request.contextPath}/update-user">
    <div class="input-group mb-3">
        <input type="hidden" class="form-control" name="id" value="${id}">
    </div>
    <div class="input-group mb-3">
        <input type="hidden" class="form-control" name="password" value="${password}">
    </div>
    <div class="input-group mb-3">
        <input type="hidden" class="form-control" name="fullName" value="${fullName}">
    </div>
    <div class="input-group mb-3">
        <input type="hidden" class="form-control" name="email" value="${email}">
    </div>
    <div class="input-group mb-3">
        <input type="hidden" class="form-control" name="address" value="${address}">
    </div>
    <div class="input-group mb-3">
        <input type="hidden" class="form-control" name="phoneNumber" value="${phoneNumber}">
    </div>
    <div class="input-group mb-3">
        <input type="text" class="form-control" name="username" value="${username}" placeholder="usernam">
    </div>
    <div>
        <select name="idRole" class="form-select" aria-label="Default select example">
            <option selected>Open this select menu</option>
            <option value="2">Admin</option>
            <option value="3">Client</option>
        </select>
    </div>
    <div class="input-group">
        <button type="submit" class="btn btn-outline-dark">Submit</button>
    </div>

</form>
</body>
</html>
