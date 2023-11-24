<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/24/2023
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<h1>Thông kê sách đang cho mượn</h1>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Mã Mượn Sách</th>
        <th>Tên Sách</th>
        <th>Tác giả</th>
        <th>Tên học sinh</th>
        <th>Lớp</th>
        <th>Ngày mượn</th>
        <th>Ngày trả</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="theMuonSach" items="${theMuonSachList}">
        <tr>
            <td>${theMuonSach.ma_muon}</td>
            <td>${theMuonSach.book.name_book}</td>
            <td>${theMuonSach.book.author}</td>
            <td>${theMuonSach.student.name_student}</td>
            <td>${theMuonSach.student.class_student}</td>
            <td><fmt:formatDate value="${theMuonSach.ngay_muon}" pattern="dd-MM-yyyy"></fmt:formatDate></td>
            <td><fmt:formatDate value="${theMuonSach.ngay_tra}" pattern="dd-MM-yyyy"></fmt:formatDate></td>


            <td>
                <button onclick="deleteByMM('${theMuonSach.ma_muon}') "
                        class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal" type="button">Trả sách </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/TheMuonSachServlet" method="get">
            <div class="modal-content">

                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Trả sách</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="deleteMM" id="deleteMM">
                    <input type="hidden" value="delete" name="action">
                    <p>Bạn có muốn trả sách: <b id="deleteB"></b> không ?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </form>
    </div>
</div>
<form action="/TheMuonSachServlet" method="get">
    <input type="hidden" name="action" value="searchById">
    <input type="text" name="searchById">
    <button type="submit">Tìm kiếm</button>
</form>
</body>
<script>
    function deleteByMM(ma_muon){
        document.getElementById("deleteMM").value = ma_muon;
        document.getElementById("deleteB").innerText = ma_muon;
    }
</script>
</html>
