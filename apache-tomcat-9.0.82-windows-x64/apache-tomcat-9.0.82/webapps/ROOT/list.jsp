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
    <script>
        function Click(id, name) {
            document.getElementById("id_product").value = id;
            document.getElementById("name").innerText = name;
        }
    </script>
</head>
<body>
<h2>List of Products</h2>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Number</th>
        <th>Mota</th>
        <th>Name Bank</th>

        <th>Edit</th>
        <th>Delete</th>
        <th>SearchByName</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${list}">
        <tr>
            <td>${product.getId_product()}</td>
            <td>${product.getName()}</td>
            <td>${product.getNumber()}</td>
            <td>${product.getMota()}</td>
            <td>${product.getBank().getNamebank()}</td>
            <td><a href="ProductServlet?action=showEdit&id=${product.getId_product()}">Edit</a></td>
            <td>
                <button type="button" class="btn btn-outline-warning" data-bs-toggle="modal"
                        data-bs-target="#exampleModal"
                        onclick="Click('${product.getId_product()}', '${product.getName()}')">
                    DELETE
                </button>
            </td>
            <td>
                <button type="button" class="btn btn-outline-warning" data-bs-toggle="modal"
                        data-bs-target="#exampleModal"
                        onclick="Click('${product.getId_product()}', '${product.getName()}')">
                    SEARCH
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/ProductServlet?action=deleteProduct" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Model title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="id_product" id="id_product">
                    Bạn muốn xóa <span id="name" style="color: red"></span> không?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
<br>
<a href="ProductServlet?action=showCreate">Add New Product</a>
</body>
</html>
