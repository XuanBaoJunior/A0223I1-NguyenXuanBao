<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/15/2023
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Example JSP Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<h1>Danh Sach The Muon Sach</h1>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Mã Mượn</th>
        <th>Trạng Thái</th>
        <th>Ngày Mượn</th>
        <th>Ngày Trả</th>
        <th>Tên Sách</th>
        <th>Tên Sinh Viên</th>
        <th><a href="/create.jsp" class="btn btn-primary">Thêm mới</a></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="theMuonSach" items="${theMuonSachList}">
        <tr>
            <td>${theMuonSach.ma_muon}</td>
            <td>${theMuonSach.trang_thai}</td>
            <td>${theMuonSach.ngay_muon}</td>
            <td>${theMuonSach.ngay_tra}</td>
            <td>${theMuonSach.name_book}</td>
            <td>${theMuonSach.name_student}</td>
            <td>
                <button onclick="deleteByMM('${theMuonSach.ma_muon}') "
                        class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal" type="button">Xóa </button>
                <button class="btn btn-primary">Cập Nhật</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/TheMuonSachServlet" method="get">
    <input type="hidden" name="action" value="searchByMM">
    <input type="text" name="searchByMaMuon">
    <button type="submit">Tìm kiếm</button>
</form>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/TheMuonSachServlet" method="get">
        <div class="modal-content">

            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Xóa</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <input type="hidden" name="deleteMM" id="deleteMM">
                <input type="hidden" value="delete" name="action">
                <p>Bạn có muốn xóa: <b id="deleteB"></b></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary">Save changes</button>
            </div>
        </div>
        </form>
    </div>
</div>
</body>
<script>
    function deleteByMM(ma_muon){
        document.getElementById("deleteMM").value = ma_muon;
        document.getElementById("deleteB").innerText = ma_muon;
    }
</script>
</html>

