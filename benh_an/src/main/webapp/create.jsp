<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 1/22/2024
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Create New Record</h2>
<form action="BVServlet" method="post">
    <input type="hidden" name="action" value="create">

    <div class="mb-3">
        <label for="ngaynhapvien" class="form-label">Ngày nhập viện:</label>
        <input type="date" class="form-control" id="ngaynhapvien" name="ngaynhapvien" required>
    </div>

    <div class="mb-3">
        <label for="ngayravien" class="form-label">Ngày nhập viện:</label>
        <input type="date" class="form-control" id="ngayravien" name="ngayravien" required>
    </div>

    <div class="mb-3">
        <label for="lydo" class="form-label">Lý do:</label>
        <textarea class="form-control" id="lydo" name="lydo"></textarea>
    </div>

    <div class="mb-3">
        <label for="tenBN" class="form-label">Tên bệnh nhân:</label>
        <select class="form-select" id="tenBN" name="tenBN">
            <c:forEach var="nameBN" items="${benhNhanList}">
                <option value="${nameBN.getId_benh_nhan()}">${nameBN.getTen_benh_nhan()}</option>
            </c:forEach>
        </select>
    </div>

    <button type="submit" class="btn btn-primary">Create Product</button>
</form>
<br>
<a href="ProductServlet">Back to Product List</a>
<%--    <input type="date" name="ngay_nhap_vien">--%>
<%--    <div><label>"${addInfo}"</label></div>--%>
</body>
</html>
