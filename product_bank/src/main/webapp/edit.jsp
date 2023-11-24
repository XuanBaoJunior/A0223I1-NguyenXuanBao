<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/24/2023
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<h2>Edit Product</h2>

<form action="ProductServlet" method="post">
    <input type="hidden" name="action" value="editProduct">
    <input type="hidden" name="id_product" value="${product.getId_product()}">

    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" id="name" name="name" value="${product.getName()}">
    </div>

    <div class="mb-3">
        <label for="number" class="form-label">Number</label>
        <input type="text" class="form-control" id="number" name="number" value="${product.getNumber()}">
    </div>

    <div class="mb-3">
        <label for="mota" class="form-label">Mota</label>
        <textarea class="form-control" id="mota" name="mota">${product.getMota()}</textarea>
    </div>

    <div class="mb-3">
        <label for="bankName" class="form-label">Name Bank</label>
        <input type="text" class="form-control" id="bankName" name="bankName" value="${product.getBank().getNamebank()}">
    </div>

    <button type="submit" class="btn btn-primary">Save Changes</button>
</form>

<br>
<a href="ProductServlet">Back to Product List</a>

</body>
</html>

