<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/6/2023
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Thêm mới sản phẩm</h1>
    <form action="/CreateController?action=create" method="post">
        <label>Tên</label><input name="name" required>
        <label>Giá</label><input name="price">
        <label>Mô tả</label><input name="describe">
        <label>Nhà sản xuất</label><input name="producer">
        <button type="submit">Create</button>
    </form>
</body>
</html>
