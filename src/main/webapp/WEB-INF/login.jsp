<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: ayoub
  Date: 19/04/2023
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<body>
<%--<c:import url="header.jsp"></c:import>--%>
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-sm-center h-100">
            <div class="col-xxl-4 col-xl-5 col-lg-5 col-md-7 col-sm-9">
                <div class="text-center my-5">
                    <img src="https://www.sauvageboris.fr/training/javaee/recipeEE/resources/logo/100.png" alt="logo" width="100">
                </div>
                <div class="card shadow-lg">
                    <div class="card-body p-5">
                        <h1 class="fs-4 card-title fw-bold mb-4">Login</h1>
                        <form action="${pageContext.request.contextPath}/login" method="post">
                            <div class="mb-3">
                                <label class="mb-2 text-muted" >Username</label>
                                <input type="text" class="form-control" name="username" placeholder="username">
                            </div>
                            <div class="mb-3">
                                <div class="mb-2 w-100">
                                    <label class="text-muted" >Password</label>
                                </div>
                                <input type="password" class="form-control" name="password" placeholder="password">
                            </div>
                            <div class="d-flex align-items-center">
                                <button type="submit" class="btn btn-primary ms-auto">
                                    Login
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<c:if test="${isError == true}">
    <p>Bad credentials.</p>
</c:if>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.2.0/js/bootstrap.min.js"></script>
</body>
</html>
