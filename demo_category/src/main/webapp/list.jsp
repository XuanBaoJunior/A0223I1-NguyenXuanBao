<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/22/2023
  Time: 8:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Product List</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"--%>
<%--          rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"--%>
<%--          crossorigin="anonymous">--%>
<%--</head>--%>
<%--<body>--%>
<%--<header class="p-3 bg-dark text-white">--%>
<%--    <div class="container">--%>
<%--        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">--%>
<%--            <!-- Your logo or brand -->--%>

<%--            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">--%>
<%--                <li><a href="/products?action=showCreate" class="nav-link px-2 text-white">Add New Product</a></li>--%>
<%--            </ul>--%>

<%--            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" action="/products?action=searchList" method="post"--%>
<%--                  style="display: flex">--%>
<%--                <input type="search" class="form-control form-control-dark" placeholder="Search..."--%>
<%--                       aria-label="Search" style="margin-right: 15px" name="nameSearch">--%>
<%--                <button type="submit" class="btn btn-outline-primary" style="margin-right: 5px">Search</button>--%>
<%--                <a href="/products" class="btn btn-outline-primary" role="button">Cancel</a>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</header>--%>

<%--<div class="container mt-4">--%>
<%--    <table class="table table-hover">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Name</th>--%>
<%--            <th>Color</th>--%>
<%--            <th>Description</th>--%>
<%--            <th>Category</th>--%>
<%--            <th>Actions</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:forEach items="${list}" var="product" varStatus="loop">--%>
<%--            <tr>--%>
<%--                <td>${loop.count}</td>--%>
<%--                <td>${product.name_product}</td>--%>
<%--                <td>${product.color_product}</td>--%>
<%--                <td>${product.describe_product}</td>--%>
<%--                <td>${product.getCategory().getType_category()}</td>--%>
<%--                <td>--%>
<%--                    <a href="/products?action=showEdit&id=${product.id_product}&id_category=${product.category.id_category}"--%>
<%--                       class="btn btn-outline-primary"--%>
<%--                       role="button">EDIT</a> |--%>
<%--                    <button type="button" class="btn btn-outline-warning" data-bs-toggle="modal"--%>
<%--                            data-bs-target="#exampleModal"--%>
<%--                            onclick="Click('${product.getId_product}', '${product.getName}')">--%>
<%--                        DELETE--%>
<%--                    </button>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--</div>--%>

<%--<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        <div class="modal-content">--%>
<%--            <form action="/products?action=deleteProduct" method="post">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="exampleModalLabel">Confirm Deletion</h5>--%>
<%--                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    <input type="hidden" name="id_product" id="id_product">--%>
<%--                    Are you sure you want to delete the product <span id="name_product" style="color: red"></span>?--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--                    <button type="submit" class="btn btn-primary">Delete</button>--%>
<%--                </div>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--    <script>--%>
<%--        function Click(id, name) {--%>
<%--        document.getElementById("id_product").value = id;--%>
<%--        document.getElementById("name_product").innerText = name;--%>
<%--    }--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<h2>Product List</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Color</th>
        <th>Description</th>
        <th>Category</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="product" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${product.name_product}</td>
            <td>${product.color_product}</td>
            <td>${product.describe_product}</td>
            <td>
                <c:if test="${product.category ne null}">
                    ${product.category.getType_category()}
                </c:if>
            </td>
            <td>${product.category.getType_category()}</td>
            <td>
                <a href="/products?action=showEdit&id=${product.getId_product}&id_category=${product.category.getId_category()}"
                   class="btn btn-outline-primary"
                   role="button">EDIT</a> |
                <button type="button" class="btn btn-outline-warning" data-bs-toggle="modal"
                        data-bs-target="#exampleModal"
                        onclick="Click('${product.getId_product}', '${product.name_product}')">
                    DELETE
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Modal for Delete Confirmation -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/products?action=deleteProduct" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Confirm Deletion</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="id_product" id="id_product">
                    Are you sure you want to delete the product <span id="name_product" style="color: red"></span>?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>


