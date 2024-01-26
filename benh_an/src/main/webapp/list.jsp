<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 1/22/2024
  Time: 6:19 PM
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
<h2>Danh sach</h2>
<table class="table table-hover">
    <thead class="thead-dark">
    <tr>
        <th>ID</th>
        <th>Ngay Nhap Vien</th>
        <th>Ngay Ra Vien</th>
        <th>Ly Do Nhap Vien</th>
        <th>Ten Benh Nhan</th>

        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="benhan" items="${list}">
            <tr>
                <td>${benhan.getId_benh_an()}</td>
                <td>${benhan.getNgay_nhap_vien()}</td>
                <td>${benhan.getNgay_ra_vien()}</td>
                <td>${benhan.getLy_do()}</td>
                <td>${benhan.getBenh_nhan().getTen_benh_nhan()}</td>
                <td><a class="btn btn-outline-success" href="BVServlet?action=showEdit&id=${benhan.getId_benh_an()}">Edit</a></td>
                <td>
                    <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal"
                            data-bs-target="#exampleModal"
                            onclick="Click('${product.getId_product()}', '${product.getName()}')">
                        DELETE
                    </button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="BVServlet?action=showCreate">Add New</a>
</body>
</html>
