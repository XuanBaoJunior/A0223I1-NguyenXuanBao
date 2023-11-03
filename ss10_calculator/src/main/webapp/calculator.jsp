<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/1/2023
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>CALCULATOR</h1>
    <hr>
    <form action="CalculatorServlet" method="post">
        <p><input type="text" name="numberA"></p>
        <p><input type="text" name="numberB"></p>
        <hr>
        <p><input type="submit" value="+" name="action">
            <input type="submit" value="-" name="action">
            <input type="submit" value="x" name="action">
            <input type="submit" value="/" name="action">
        </p>
    </form>
</body>
</html>
