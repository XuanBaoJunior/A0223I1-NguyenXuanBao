<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/24/2023
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
<h1>Danh sách sách</h1>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Mã Sách</th>
        <th>Tên Sách</th>
        <th>Tác giả</th>
        <th>Số lượng</th>
        <th>Mô tả</th>
        <th><a href="/TheMuonSachServlet?action=create" class="btn btn-primary">Mượn</a></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="theMuonSach" items="${theMuonSachList}">
        <tr>
            <td>${theMuonSach.ma_muon}</td>
            <td>${theMuonSach.book.name_book}</td>
            <td>${theMuonSach.book.author}</td>
            <td>${theMuonSach.student.name_student}</td>
            <td>${theMuonSach.book.quatity}</td>
            <td>${theMuonSach.book.description}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>


