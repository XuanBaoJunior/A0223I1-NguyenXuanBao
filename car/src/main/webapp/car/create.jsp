<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 1/19/2024
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/car" method="post">
        <input type="hidden" name="action" value="create">
        <label>Id</label>
        <input class="form-control" type="text" name="id">
        <label>Name</label>
        <input class="form-control" type="text" name="name">
        <label>Year of Manufacture</label>
        <input class="form-control" type="number" name="point">
        <label>	Price</label>
        <input class="form-control" type="number" name="idCard">
        <label>Country Manufacture</label>
        <select name="country_manufacture">
            <c:forEach var="countryList" items="${countryList}">
                <option value="${countryList.id_country}">
                        ${countryList.country_manufacture}
                </option>
            </c:forEach>
        </select>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
