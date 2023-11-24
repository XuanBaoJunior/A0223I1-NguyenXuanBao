<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/3/2023
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới sản phẩm</h1>
<form action="/ProductController?action=create" method="post">
    <input type="hidden" name="action" value="create">
    <label>Tên Sản Phẩm</label> <input type="text" name="name"><br>
    <label>Giá sản phẩm</label> <input type="number" name="price"><br>
    <label>Mô tả</label> <input type="text" name="describe"><br>
    <label>Nhà sản xuất</label> <input type="text" name="producer"><br>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
