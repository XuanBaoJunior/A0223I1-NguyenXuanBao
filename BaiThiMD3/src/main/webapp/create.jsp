<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 1/29/2024
  Time: 8:09 PM
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
<script>
    function validateForm() {
        var id_nguoi_thue = document.getElementById("id_nguoi_thue").value;
        var ten_nguoi_thue = document.getElementById("ten_nguoi_thue").value;
        var so_dien_thoai = document.getElementById("so_dien_thoai").value;
        var ngay_thue = document.getElementById("ngay_thue").value;
        var ghi_chu = document.getElementById("ghi_chu").value;

        // Validation for Ma phong tro
        if (id_nguoi_thue.trim() === "" || id_nguoi_thue.length > 10) {
            document.getElementById("id_nguoi_thue_error").innerHTML = "Please enter Ma phong tro (maximum 10 characters)";
            return false;
        } else {
            document.getElementById("id_nguoi_thue_error").innerHTML = "";
        }

        // Validation for Ten nguoi thue tro
        if (ten_nguoi_thue.trim() === "" || ten_nguoi_thue.length > 200 || !/^[a-zA-Z\s]*$/.test(ten_nguoi_thue)) {
            document.getElementById("ten_nguoi_thue_error").innerHTML = "Please enter Ten nguoi thue tro (maximum 200 characters, only letters and spaces)";
            return false;
        } else {
            document.getElementById("ten_nguoi_thue_error").innerHTML = "";
        }

        // Validation for So dien thoai
        if (so_dien_thoai.trim() === "" || !/^\d{10}$/.test(so_dien_thoai)) {
            document.getElementById("so_dien_thoai_error").innerHTML = "Please enter a valid So dien thoai (exactly 10 digits)";
            return false;
        } else {
            document.getElementById("so_dien_thoai_error").innerHTML = "";
        }

        // Validation for Ngay thue
        if (ngay_thue.trim() === "") {
            document.getElementById("ngay_thue_error").innerHTML = "Please enter Ngay thue";
            return false;
        } else {
            document.getElementById("ngay_thue_error").innerHTML = "";
        }

        // Validation for Ghi chu
        if (ghi_chu.trim() === "") {
            document.getElementById("ghi_chu_error").innerHTML = "Please enter Ghi chu";
            return false;
        } else {
            document.getElementById("ghi_chu_error").innerHTML = "";
        }

        return true; // Form submission will proceed if all validations pass
    }
</script>
<h1>Add new product</h1>
<form action="/PhongTroServlet?action=createPT" method="post">
    <table>
        <tr>
            <div class="form-group">
                <label for="id_nguoi_thue">Ma phong tro</label>
                <input type="text" class="form-control" id="id_nguoi_thue" name="id_nguoi_thue" placeholder="Nhập id">
                <small id="id_nguoi_thue_error" class="form-text text-danger"></small>
            </div>
        </tr>
        <tr>
            <div class="form-group">
                <label for="ten_nguoi_thue">Ten nguoi thue tro</label>
                <input type="text" class="form-control" id="ten_nguoi_thue" name="ten_nguoi_thue" placeholder="Nhập name">
                <small id="ten_nguoi_thue_error" class="form-text text-danger"></small>
            </div>
        </tr>
        <tr>
            <div class="form-group">
                <label for="so_dien_thoai">So dien thoai</label>
                <input type="text" class="form-control" id="so_dien_thoai" name="so_dien_thoai" placeholder="Nhập sdt">
                <small id="so_dien_thoai_error" class="form-text text-danger"></small>
            </div>
        </tr>
        <tr>
            <div class="form-group">
                <label for="ngay_thue">Ngay thue</label>
                <input type="text" class="form-control" id="ngay_thue" name="ngay_thue" placeholder="Nhập ngày thuê">
                <small id="ngay_thue_error" class="form-text text-danger"></small>
            </div>
        </tr>

        </br>
        <tr>
            <label for="exampleFormControlSelect1">Hinh thuc thanh toan</label>
            <select class="form-control" id="exampleFormControlSelect1" name="id">
                <c:forEach items="${phongTroList}" var="phongTroList">
                    <option value="${phongTroList.getId()}">${phongTroList.getHinh_thuc_thanh_toan()}</option>
                </c:forEach>
            </select>
        </tr>
        <tr>
            <div class="form-group">
                <label for="ghi_chu">Ghi chu</label>
                <input type="text" class="form-control" id="ghi_chu" name="ghi_chu" placeholder="Nhập ngày thuê">
                <small id="ghi_chu_error" class="form-text text-danger"></small>
            </div>
        </tr>
        <tr>
            <div style="margin-top: 15px">
                <button type="submit" class="btn btn-outline-primary">Create</button>
                |
                <a href="/PhongTroServlet" class="btn btn-outline-primary" role="button">Back</a>
            </div>
        </tr>
    </table>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</html>
