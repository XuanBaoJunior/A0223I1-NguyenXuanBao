<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/24/2023
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<h1>Thêm mới</h1>
<div class="container">
    <form class="row g-3" method="post" action="/TheMuonSachServlet">
        <div class="col-md-6">
            <label for="maMuon" class="form-label">Mã mượn</label>
            <input type="text" class="form-control" id="maMuon" name="maMuon">
        </div>
        <div class="col-md-6">
            <label for="trangThai" class="form-label">Trạng thái</label>
            <input type="text" class="form-control" id="trangThai" name="trangThai">
        </div>
        <div class="col-6">
            <label for="ngayMuon" class="form-label">Ngày mượn</label>
            <input type="text" class="form-control" id="ngayMuon" name="ngayMuon">
        </div>
        <div class="col-6">
            <label for="ngayTra" class="form-label">Ngày trả</label>
            <input type="text" class="form-control" id="ngayTra" name="ngayTra">
        </div>
        <div class="col-md-6">
            <label for="inputState" class="form-label">Tên Sách</label>
            <select id="inputState" class="form-select" name="bookSelect">
                <c:forEach items="${books}" var="b">
                <option  value="${b.id_book}" >${b.name_book}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-6">
            <label for="inputStudent" class="form-label">Tên học sinh</label>
            <select id="inputStudent" class="form-select" name="studentSelect">
                <c:forEach items="${students}" var="s">
                    <option  value="${s.id_student}" >${s.name_student}</option>
                </c:forEach>
            </select>
        </div>
        <%--        <div class="col-12">--%>
        <%--            <div class="form-check">--%>
        <%--                <input class="form-check-input" type="checkbox" id="gridCheck">--%>
        <%--                <label class="form-check-label" for="gridCheck">--%>
        <%--                    Check me out--%>
        <%--                </label>--%>
        <%--            </div>--%>
        <%--        </div>--%>
        <div class="col-12">
            <button type="submit" class="btn btn-primary">Mượn sách</button>
            <input type="hidden" name="action" value="create">
        </div>
    </form>
</div>
</body>
</html>

