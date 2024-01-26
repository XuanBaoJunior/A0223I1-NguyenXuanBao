<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 1/25/2024
  Time: 8:32 PM
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
<h2>Danh sach loai xe</h2>
<table class="table table-hover">
    <thead class="thead-dark">
    <tr>
        <th>ID</th>
        <th>Ten xe</th>
        <th>Gia xe</th>
        <th>Nam san xuat</th>
        <th>Nuoc san xuat</th>

        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="loaixe" items="${list}">
        <tr>
            <td>${loaixe.getId_loai_xe()}</td>
            <td>${loaixe.getTen_loai_xe()}</td>
            <td>${loaixe.getGia_xe()}</td>
            <td>${loaixe.getNam_san_xuat()}</td>
            <td>${loaixe.getSan_xuat().getNuoc_san_xuat()}</td>
            <td><a class="btn btn-outline-success" href="LoaiXeServlet?action=showEdit&id=${loaixe.getId_loai_xe()}">Edit</a></td>
            <td>
                <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal"
                        data-bs-target="#exampleModal"
                        onclick="Click('${loaixe.getId_loai_xe()}', '${loaixe.getTen_loai_xe()}')">
                    DELETE
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="LoaiXeServlet?action=showCreate">Add New</a>
</body>
</html>
