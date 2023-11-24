<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/15/2023
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
    <h1>Thêm mới</h1>
    <div class="container">
    <form class="row g-3">
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
            <label for="inputCity" class="form-label">Tên Sách</label>
            <select id="inputState" class="form-select">
                <option selected value="">Choose...</option>
                <option>Truyện</option>
                <option>Sách</option>
                <option>Truyện</option>
            </select>
        </div>
        <div class="col-md-6">
            <label for="inputState" class="form-label">Tên học sinh</label>
            <input type="text" class="form-control" id="inputCity">
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
            <button type="submit" class="btn btn-primary">Thêm mới</button>
        </div>
    </form>
    </div>
</body>
</html>
