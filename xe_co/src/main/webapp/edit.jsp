<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 1/26/2024
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<h2>Edit Product</h2>

<form action="LoaiXeServlet" method="post">
    <input type="hidden" name="action" value="editLX">
    <input type="hidden" name="id_loai_xe" value="${loai_xe.getId_loai_xe()}"> <!-- Corrected variable name -->

    <div class="mb-3">
        <label for="ten_loai_xe" class="form-label">Ten loai xe</label>
        <input type="text" class="form-control" id="ten_loai_xe" name="ten_loai_xe" value="${loai_xe.getTen_loai_xe()}">
    </div>

    <div class="mb-3">
        <label for="gia_xe" class="form-label">Gia xe</label>
        <input type="text" class="form-control" id="gia_xe" name="gia_xe" value="${loai_xe.getGia_xe()}">
    </div>

    <div class="mb-3">
        <label for="nam_san_xuat" class="form-label">Nam san xuat</label>
        <textarea class="form-control" id="nam_san_xuat" name="nam_san_xuat">${loai_xe.getNam_san_xuat()}</textarea>
    </div>

    <div class="mb-3">
        <label for="nuoc_san_xuat" class="form-label">Select Nuoc San Xuat</label>
        <select class="form-select" id="nuoc_san_xuat" name="nuoc_san_xuat">
            <c:forEach var="sx" items="${SXlist}"> <!-- Corrected variable name -->
                <option value="${sx.id_nuoc_san_xuat}" ${loai_xe.getSan_xuat().getId_nuoc_san_xuat() eq sx.id_nuoc_san_xuat ? 'selected' : ''}>
                        ${sx.nuoc_san_xuat}
                </option>
            </c:forEach>
        </select>
    </div>

    <button type="submit" class="btn btn-primary">Save Changes</button>
</form>

<br>
<a href="LoaiXeServlet">Back to Product List</a>

</body>
</html>

