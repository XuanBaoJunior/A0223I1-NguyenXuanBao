<%@ page import="java.util.List" %>
<%@ page import="com.example.ss10_list_of_customers.Customer" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 10/30/2023
  Time: 8:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <style>

    </style>
</head>
<body>
<table class="table table-bordered container">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Birthday</th>
        <th scope="col">Address</th>
        <th scope="col">Image</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="c">
        <c:choose>
            <c:when test="${c.getId()%2==0}">
                <tr style="color: red">
                    <th scope="row">1</th>
                    <td>${c.getName()}</td>
                    <td>${c.getCreateAt()}</td>
                    <td>${c.getAddress()}</td>
                    <td><img src="${c.image}" width="40px" height="40px" alt="anh"></td>
                </tr>
            </c:when>
            <c:otherwise>
                <tr>
                    <th scope="row">1</th>
                    <td>${c.getName()}</td>
                    <td>${c.getCreateAt()}</td>
                    <td>${c.getAddress()}</td>
                    <td><img src="${c.image}" width="40px" height="40px" alt="anh"></td>
                </tr>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    </tbody>
</table>
<%--<table>--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>Name</th>--%>
<%--        <th>Birthday</th>--%>
<%--        <th>Address</th>--%>
<%--        <th>Image</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <%--%>
<%--        List<Customer> customers = (List<Customer>) request.getAttribute("customers");--%>
<%--        for (int i = 0; i < customers.size(); i++){--%>
<%--            String name = customers.get(i).getName();--%>
<%--            String address = customers.get(i).getAddress();--%>
<%--            Date date = customers.get(i).getCreateAt();--%>
<%--            String image = customers.get(i).getImage();--%>
<%--            String tr = String.format("<tr>\n" +--%>
<%--                    "        <td>%s</td>\n" +--%>
<%--                    "        <td>%s</td>\n" +--%>
<%--                    "        <td>%s</td>\n" +--%>
<%--                    "        <td>%s</td>\n" +--%>
<%--                    "    </tr>", name, address, date, image);--%>
<%--            out.println(tr);--%>
<%--        }--%>
<%--    %>--%>

<%--    <c:forEach items="${customers}" var="c">--%>
<%--        <c:choose>--%>
<%--            <c:when test="${c.getId()%2==0}">--%>
<%--                <tr style="color: red">--%>
<%--                    <td>${c.getName()}</td>--%>
<%--                    <td>${c.getCreateAt()}</td>--%>
<%--                    <td>${c.getAddress()}</td>--%>
<%--                    <td><img src="${c.image}" width="40px" height="40px" alt="anh"></td>--%>
<%--                </tr>--%>
<%--            </c:when>--%>
<%--            <c:otherwise>--%>
<%--                <tr>--%>
<%--                    <td>${c.getName()}</td>--%>
<%--                    <td>${c.getCreateAt()}</td>--%>
<%--                    <td>${c.getAddress()}</td>--%>
<%--                    <td><img src="${c.image}" width="40px" height="40px" alt="anh"></td>--%>
<%--                </tr>--%>
<%--            </c:otherwise>--%>
<%--        </c:choose>--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
