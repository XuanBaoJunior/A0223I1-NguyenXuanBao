<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 11/21/2023
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
<%--    <title>Customer List</title>--%>
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">--%>
<%--</head>--%>
<%--<body>--%>

<%--<div class="container mt-5">--%>
<%--    <h2>Customer List</h2>--%>
<%--    <a href="addCustomer.jsp" class="btn btn-primary mb-3">Add New Customer</a>--%>

<%--    <table class="table">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>Customer ID</th>--%>
<%--            <th>Name</th>--%>
<%--            <th>Birthday</th>--%>
<%--            <th>Gender</th>--%>
<%--            <th>ID Card</th>--%>
<%--            <th>Phone</th>--%>
<%--            <th>Email</th>--%>
<%--            <th>Address</th>--%>
<%--            <th>Action</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:forEach var="customer" items="${customerList}">--%>
<%--            <tr>--%>
<%--                <td>${customer.customerId}</td>--%>
<%--                <td>${customer.customerName}</td>--%>
<%--                <td>${customer.customerBirthday}</td>--%>
<%--                <td>${customer.customerGender == 1 ? 'Male' : 'Female'}</td>--%>
<%--                <td>${customer.customerIdCard}</td>--%>
<%--                <td>${customer.customerPhone}</td>--%>
<%--                <td>${customer.customerEmail}</td>--%>
<%--                <td>${customer.customerAddress}</td>--%>
<%--                <td>--%>
<%--                    <a href="editCustomer.jsp?customerId=${customer.customerId}" class="btn btn-warning btn-sm">Edit</a>--%>
<%--                    <a href="deleteCustomer.jsp?customerId=${customer.customerId}" class="btn btn-danger btn-sm">Delete</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--</div>--%>

<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>--%>

<%--</body>--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        header {
            background-color: #333;
            color: white;
            padding: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        #logo {
            width: 50px;
            height: 50px;
        }

        nav {
            display: flex;
            align-items: center;
        }

        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex;
        }

        nav ul li {
            margin-right: 15px;
        }

        .content {
            display: flex;
            margin: 20px;
        }

        .side-menu {
            width: 200px;
            padding: 10px;
            background-color: #ddd;
        }

        .side-menu ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        .side-menu ul li {
            margin-bottom: 10px;
        }

        .main-content {
            flex: 1;
            padding: 20px;
            background-color: #fff;
        }
    </style>
</head>
<body>

<header>
    <div>
        <img id="logo" src="/WEB-INF/case_study_final.jpg" alt="Logo">
    </div>
    <div>
        <span>Nguyen Xuan Bao</span>
    </div>
</header>

<nav>
    <ul class="nav">
        <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Employee</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Customer</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Service</a></li>
        <li class="nav-item"><a class="nav-link" href="#">Contract</a></li>
        <li class="nav-item">
            <form class="form-inline" action="#" method="get">
                <input class="form-control mr-2" type="text" name="search" placeholder="Search">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </li>
    </ul>
</nav>

<div class="content">
<%--    <div class="side-menu">--%>
<%--        <ul class="list-group">--%>
<%--            <li class="list-group-item">List 1</li>--%>
<%--            <li class="list-group-item">List 2</li>--%>
<%--            <li class="list-group-item">List 3</li>--%>
<%--        </ul>--%>
    <thead>
    <tr>
        <td>${customer.customer_id}</td>
        <td>${customer.customer_type_id}</td>
        <td>${customer.customer_name}</td>
        <td>${customer.customer_birthday}</td>
        <td>${customer.customer_gender}</td>
        <td>${customer.customer_id_card}</td>
        <td>${customer.customer_phone}</td>
        <td>${customer.customer_email}</td>
        <td>${customer.customer_address}</td>
        <th><a href="/create.jsp" class="btn btn-primary">Thêm mới</a></th>
    </tr>
    </thead>
<%--    <form action="FuramaServlet" method="get">--%>
<%--        <input type="text" name="keyword" placeholder="Search by customer name">--%>
<%--        <button type="submit">Search</button>--%>
<%--    </form>--%>
    <tbody>
    <c:forEach var="customerList" items="${customerList}">
        <tr>
            <td>${customerList.customer_id}</td>
            <td>${customerList.customer_type_id}</td>
            <td>${customerList.customer_name}</td>
            <td>${customerList.customer_birthday}</td>
            <td>${customerList.customer_gender}</td>
            <td>${customerList.customer_id_card}</td>
            <td>${customerList.customer_phone}</td>
            <td>${customerList.customer_email}</td>
            <td>${customerList.customer_address}</td>
            <td>
                <button onclick="//deleteByMM('${theMuonSach.ma_muon}')"
                        class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal" type="button">Xóa </button>
                <button class="btn btn-primary">Cập Nhật</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    </div>
    <div class="main-content">
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>


