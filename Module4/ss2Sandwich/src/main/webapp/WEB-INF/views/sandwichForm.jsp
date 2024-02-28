<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 2/28/2024
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Choose your condiments:</h2>
<form action="/views/sandwich" method="post">
    <input type="checkbox" name="condiments" value="Lettuce"> Lettuce<br>
    <input type="checkbox" name="condiments" value="Tomato"> Tomato<br>
    <input type="checkbox" name="condiments" value="Onion"> Onion<br>
    <input type="checkbox" name="condiments" value="Pickles"> Pickles<br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
