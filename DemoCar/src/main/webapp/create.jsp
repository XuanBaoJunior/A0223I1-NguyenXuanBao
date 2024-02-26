<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 1/27/2024
  Time: 2:28 PM
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
<h1>Add new product</h1>
<form action="/LoaiXeServlet?action=createLoaiXe" method="post">
    <table>
        <tr>
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Nhập name">
            </div>
        </tr>
        <tr>
            <div class="form-group">
                <label for="gia_xe">Price</label>
                <input type="number" class="form-control" id="gia_xe" name="gia_xe" placeholder="Nhập price">
            </div>
        </tr>
        <tr>
            <div class="form-group">
                <label for="nam_san_xuat">Year</label>
                <input type="number" class="form-control" id="nam_san_xuat" name="nam_san_xuat" placeholder="Nhập year">
            </div>
        </tr>
        <tr>
            <div class="form-group">
                <label for="color">Color</label>
                <input type="text" class="form-control" id="color" name="color" placeholder="Nhập color">
            </div>
        </tr>
        <tr>
            <%--            <div class="form-group">--%>
            <label for="mota">Description</label>
            <%--                <input type="text" class="form-control" id="mota" name="mota" placeholder="Nhập description">--%>
            <%--            </div>--%>
            <textarea name="mota" id="mota" cols="30" rows="10"></textarea>
        </tr>
        </br>
        <tr>
            <label for="exampleFormControlSelect1">Nuoc san xuat</label>
            <select class="form-control" id="exampleFormControlSelect1" name="id">
                <c:forEach items="${san_xuatList}" var="san_xuatList">
                    <option value="${san_xuatList.getId_san_xuat()}">${san_xuatList.getNuoc_san_xuat()}</option>
                </c:forEach>
            </select>
        </tr>
        <tr>
            <div style="margin-top: 15px">
                <button type="submit" class="btn btn-outline-primary">Create</button>
                |
                <a href="/LoaiXeServlet" class="btn btn-outline-primary" role="button">Back</a>
            </div>
        </tr>
    </table>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</html>
