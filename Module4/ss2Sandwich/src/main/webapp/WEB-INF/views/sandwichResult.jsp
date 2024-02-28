<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 2/28/2024
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Your selected condiments:</h2>
<ul>
    <c:forEach var="condiment" items="${selectedCondiments}">
        <li>${condiment}</li>
    </c:forEach>
</ul>
</body>
</html>
