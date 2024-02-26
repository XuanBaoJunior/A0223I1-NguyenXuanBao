<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 2/21/2024
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Conversion Result</h2>
    <p>Amount in USD: <%= request.getAttribute("usdAmount") %></p>
    <p>Amount in VND: <%= request.getAttribute("vndAmount") %></p>
    <a href="list.jsp">Back to Conversion Page</a>
</body>
</html>
