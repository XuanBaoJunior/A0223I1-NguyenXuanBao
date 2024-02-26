<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 2/21/2024
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Kết quả tra cứu</h2>
    <p>Từ: <%= request.getAttribute("word") %></p>
    <p>Nghĩa: <%= request.getAttribute("meaning") %></p>
    <a href="/">Quay lại trang chủ</a>
</body>
</html>
