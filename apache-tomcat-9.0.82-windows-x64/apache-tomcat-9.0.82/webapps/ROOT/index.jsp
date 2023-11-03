<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/1/2023
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product Discount Calculator</h1>
<form action="/DiscountServlet" method="post">
    <label for="productDescription">Product Description:</label>
    <input type="text" id="productDescription" name="productDescription"><br>

    <label for="listPrice">List Price:</label>
    <input type="text" id="listPrice" name="listPrice"><br>

    <label for="discountPercent">Discount Percent:</label>
    <input type="text" id="discountPercent" name="discountPercent"> %<br>

    <input type="submit" value="Calculate Discount">
</form>
</body>
</html>
