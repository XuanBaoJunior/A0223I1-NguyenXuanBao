<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 2/28/2024
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/views/calculator" method="post">
    <input type="number" name="num1" placeholder="Enter number 1" required>
    <select name="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="number" name="num2" placeholder="Enter number 2" required>
    <button type="submit">Calculate</button>
</form>
</body>
</html>
