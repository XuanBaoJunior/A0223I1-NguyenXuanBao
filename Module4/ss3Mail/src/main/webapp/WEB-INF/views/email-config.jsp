<%--
  Created by IntelliJ IDEA.
  User: XuanBao
  Date: 3/1/2024
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Email Configuration</title>
</head>
<body>
<h1>Email Configuration</h1>
<form action="/views/update-email-config" method="post">
    <label for="language">Language:</label>
    <select name="language" id="language">
        <option value="English">English</option>
        <option value="Vietnamese">Vietnamese</option>
        <option value="Japanese">Japanese</option>
        <option value="Chinese">Chinese</option>
    </select>
    <br><br>
    <label for="pageSize">Page Size:</label>
    <select name="pageSize" id="pageSize">
        <option value="5">5</option>
        <option value="10">10</option>
        <option value="15">15</option>
        <option value="25">25</option>
        <option value="50">50</option>
        <option value="100">100</option>
    </select>
    <br><br>
    <label for="spamFilter">Spam Filter:</label>
    <input type="checkbox" name="spamFilter" id="spamFilter">
    <br><br>
    <label for="signature">Signature:</label><br>
    <textarea name="signature" id="signature" rows="4" cols="50"></textarea>
    <br><br>
    <button type="submit">Update</button>
</form>
<h2>Current Configuration:</h2>
<p>Language: ${emailConfig.language}</p>
<p>Page Size: ${emailConfig.pageSize}</p>
<p>Spam Filter: ${emailConfig.spamFilter ? 'Enabled' : 'Disabled'}</p>
<p>Signature: ${emailConfig.signature}</p>
</body>
</html>

