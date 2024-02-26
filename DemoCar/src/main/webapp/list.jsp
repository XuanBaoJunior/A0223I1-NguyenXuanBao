<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 1/27/2024
  Time: 2:04 PM
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

<link href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css" rel="stylesheet">
<body>
<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                    <use xlink:href="#bootstrap"/>
                </svg>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/LoaiXeServlet?action=showCreate" class="nav-link px-2 text-white">Add new product</a></li>
            </ul>

            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" action="/LoaiXeServlet?action=searchList" method="post"
                  style="display: flex">
                <input type="search" class="form-control form-control-dark" placeholder="Search..."
                       aria-label="Search" style="margin-right: 15px" name="nameSearch">
                <button type="submit" class="btn btn-outline-primary" style="margin-right: 5px">Search</button>
                <a href="/LoaiXeServlet" class="btn btn-outline-primary" role="button">Cancel</a>
            </form>

        </div>
    </div>
</header>

<table id="example" class="table table-hover">
    <thead>
    <tr>
        <th>STT</th>
        <th>Car Name</th>
        <th>Price</th>
        <th>Year</th>
        <th>Color</th>
        <th>Category</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="loai_xe" varStatus="loop">
        <tr>
            <td><c:out value="${loop.count}"/></td>
            <td><c:out value="${loai_xe.getName()}"/></td>
            <td><c:out value="${loai_xe.getGia_xe()}"/></td>
            <td><c:out value="${loai_xe.getNam_san_xuat()}"/></td>
            <td><c:out value="${loai_xe.getColor()}"/></td>
            <td><c:out value="${loai_xe.getSan_xuat().getNuoc_san_xuat()}"/></td>
            <td>
    <a href="/LoaiXeServlet?action=showEdit&id_loai_xe=${loai_xe.getId_loai_xe()}&id=${loai_xe.getSan_xuat().getId_san_xuat()}"
       class="btn btn-outline-primary"
       role="button">EDIT</a> |

    <button type="button" class="btn btn-outline-warning" data-bs-toggle="modal"
                        data-bs-target="#exampleModal"
                        onclick="Click('${loai_xe.getId_loai_xe()}', '${loai_xe.getName()}')">
                    DELETE
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/LoaiXeServlet?action=deleteProduct" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Model title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="id_loai_xe" id="id_loai_xe">
                    Bạn muốn xóa sản phẩm <span id="name" style="color: red"></span> không?
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#example').DataTable();
    });

    let codeDelete = -1;

    function Click(id, name) {
        document.getElementById("id_loai_xe").value = id;
        document.getElementById("name").innerText = name;

    }
</script>
</html>
