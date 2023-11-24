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
    <link rel="stylesheet" href="/css/create.css">
</head>
<body>
<div class="container mx-2">
    <h1 style="text-align: center">Đăng Kí Sản Phẩm</h1>
    <c:forEach var="product" items="${list}">
        <form action="/ProductServlet?action=update&id=${product.getId()}" method="post">
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Tên</label>
                <input type="text" value="${product.getName()}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="nameProduct" required>
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Giá</label>
                <input type="number" value="${product.getPrice()}" class="form-control" id="exampleInputPassword1"  name="priceProduct" required>
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Tác giả</label>
                <input type="text" value="${product.getAuthor()}" class="form-control" id="author" name="author" required>
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Mô tả</label>
                <input type="text" value="${product.getDescribeBook()}" class="form-control" id="describeBook" name="describeBook" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="reset" class="btn btn-primary">Reset</button>
        </form>
    </c:forEach>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
