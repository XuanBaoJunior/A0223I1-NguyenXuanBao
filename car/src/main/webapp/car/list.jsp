<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 1/19/2024
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Car List</title>
</head>
<body>

<div class="container mt-5">
    <h2>Car List</h2>

    <div class="mb-3">
        <button class="btn btn-success" onclick="window.location.href='/carServlet?action=create'">Add New</button>
        <input type="text" id="searchInput" placeholder="Search...">
        <button class="btn btn-primary" onclick="search()">Search</button>
    </div>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Year of Manufacture</th>
            <th>Price</th>
            <th>Country Manufacture</th>
            <th>Update</th>
            <th>Delete</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="carDTO" items="${listCar}">
            <tr>
                <td>${carDTO.id_car}</td>
                <td>${carDTO.name_car}</td>
                <td>${carDTO.year_of_manufacture}</td>
                <td>${carDTO.price}</td>
                <td>${carDTO.country_manufacture}</td>
                <td><button class="btn btn-warning" onclick="update(${carDTO.id_car})">Update</button></td>
                <td><button class="btn btn-danger" onclick="remove(${carDTO.id_car})">Delete</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
