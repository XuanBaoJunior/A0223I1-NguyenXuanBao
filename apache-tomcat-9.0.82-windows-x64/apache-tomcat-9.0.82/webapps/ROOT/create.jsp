<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/24/2023
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create New Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <h2>Create New Product</h2>
    <form action="ProductServlet" method="post">
        <input type="hidden" name="action" value="createProduct">

        <div class="mb-3">
            <label for="name" class="form-label">Product Name:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>

        <div class="mb-3">
            <label for="number" class="form-label">Number:</label>
            <input type="number" class="form-control" id="number" name="number" required>
        </div>

        <div class="mb-3">
            <label for="mota" class="form-label">Description:</label>
            <textarea class="form-control" id="mota" name="mota"></textarea>
        </div>

        <div class="mb-3">
            <label for="bankId" class="form-label">Bank:</label>
            <select class="form-select" id="bankId" name="id">
                <c:forEach var="bank" items="${bankList}">
                    <option value="${bank.getId()}">${bank.getNamebank()}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Create Product</button>
    </form>
    <br>
    <a href="ProductServlet">Back to Product List</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>

