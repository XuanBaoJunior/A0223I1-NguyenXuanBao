<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/24/2023
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<h2>List of Products</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Number</th>
        <th>Mota</th>
        <th>Bank Name</th>
        <!-- Add more columns as needed -->
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${list}">
        <tr>
            <td>${product.idProduct}</td>
            <td>${product.name}</td>
            <td>${product.number}</td>
            <td>${product.mota}</td>
            <td>${product.bank.name}</td>
            <!-- Access other properties as needed -->
            <td><a href="ProductServlet?action=showEdit&id=${product.idProduct}">Edit</a></td>
            <td><a href="ProductServlet?action=deleteProduct&id=${product.idProduct}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="ProductServlet?action=showCreate">Add New Product</a>
</body>
</html>
