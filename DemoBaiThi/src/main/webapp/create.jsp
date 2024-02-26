<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 1/31/2024
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous">
<body>
<script>
    function validateForm(){
        let name = document.getElementById("name").value;

        if (name.trim() === "" || name.length > 200 || !/^[a-zA-Z\s]*$/.test(name)) {
            document.getElementById("name-error").innerHTML = "Be hon 200 ki tu, va khong duoc de trong)";
            return false;
        } else {
            document.getElementById("error").innerHTML = "";
        }
    }

</script>
<h1>Add new product</h1>
<form action="/products?action=createProduct" method="post">
    <table>
        <tr>
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Nhập name" pattern="/^[a-zA-Z\s]" title="">
                <small id="name-error" class="form-text text-danger"></small>
            </div>
        </tr>
        <tr>
            <div class="form-group">
                <label for="price">Price</label>
                <input type="number" class="form-control" id="price" name="price" placeholder="Nhập price">
            </div>
        </tr>
        <tr>
            <div class="form-group">
                <label for="number">Quantity</label>
                <input type="number" class="form-control" id="number" name="number" placeholder="Nhập quantity">
            </div>
        </tr>
        <tr>
            <div class="form-group">
                <label for="color">Color</label>
                <input type="text" class="form-control" id="color" name="color" placeholder="Nhập color">
            </div>
        </tr>
        <tr>
            <label for="mota">Description</label>
            <textarea name="mota" id="mota" cols="30" rows="10"></textarea>
        </tr>
        </br>
        <tr>
            <label for="exampleFormControlSelect1">Category</label>
            <select class="form-control" id="exampleFormControlSelect1" name="id">
                <c:forEach items="${categoryList}" var="categoryList">
                    <option value="${categoryList.getId()}">${categoryList.getType()}</option>
                </c:forEach>
            </select>
        </tr>
        <tr>
            <div style="margin-top: 15px">
                <button type="submit" class="btn btn-outline-primary">Create</button>
                |
                <a href="/products" class="btn btn-outline-primary" role="button">Back</a>
            </div>
        </tr>
    </table>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</html>
