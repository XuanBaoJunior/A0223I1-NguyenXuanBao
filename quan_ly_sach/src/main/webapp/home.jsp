<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/13/2023
  Time: 12:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/home.css">
</head>
<body>
<div class="container">
    <form class="mx-1" action="/ProductServlet?action=search" method="post">
        <input type="search" placeholder="Tìm Kiếm" name="searchProduct">
        <button type="submit" class="btn btn-primary">Tìm Kiếm</button>
    </form>
</div>
<div class="container " style="margin-top: 1rem">
    <table class="table table-striped table-hover">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tên</th>
            <th scope="col">Giá</th>
            <th scope="col">Tác giả</th>
            <th scope="col">Mô tả</th>
            <th scope="col"><a class="btn btn-primary" href="/ProductServlet?action=create">Thêm Mới</a></th>
        </tr>
        <tbody>
        <c:forEach var="product" items="${list}">
            <tr>
                <th scope="row">${product.getId()}</th>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getAuthor()}</td>
                <td>${product.getDescribeBook()}</td>
                <th>
                    <button onclick="transferDataDelete(${product.getId()},'${product.getName()}')" type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">Xóa</button>
                    <a href="/ControllerProductServlet?action=transfer&idupdate=${product.getId()}" class="btn btn-warning">Sữa</a>
                    <a href="/ControllerProductServlet?action=information&id=${product.getId()}" class="btn btn-primary">Thông Tin</a>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Modal Xác Nhận Xóa-->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/ControllerProductServlet?action=delete" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Xác Nhận Xóa Sản Phẩm</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="idHidden" id="idHidden">
                    <p>Bạn Muốn Xóa Sản Phẩm : <span id="deleteProduct"></span></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Enter</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
<script>
    function transferDataDelete(idProduct,nameProduct){
        document.getElementById("idHidden").value = idProduct;
        document.getElementById("deleteProduct").innerText = nameProduct;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>

