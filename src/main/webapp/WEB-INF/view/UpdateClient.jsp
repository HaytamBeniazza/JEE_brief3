<%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 10/14/2023
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
    <title>Update Client</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.2);
            padding: 20px;
            width: 300px;
            text-align: center;
        }

        .form-container h2 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #333;
        }

        .input-group {
            margin-bottom: 15px;
            text-align: left;
        }

        .input-group label {
            font-size: 14px;
            display: block;
            margin-bottom: 5px;
            color: #555;
        }

        .input-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        .input-group input:focus {
            outline: none;
            border-color: #007BFF;
        }

        .btn {
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 16px;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        body{
            background: -webkit-linear-gradient(bottom, #0250c5, #d43f8d);
        }


    </style>
</head>
<body>
<div class="form-container">
    <h2>Update Client</h2>
<form action="/updateclient?id=${client.code}" method="post">
        <div class="input-group">
            <label for="firstName">First Name</label>
            <input type="text" id="firstName" name="firstName" value="${client.firstName}" required>
        </div>
        <div class="input-group">
            <label for="lastName">Last Name</label>
            <input type="text" id="lastName" name="lastName" value="${client.lastName}" required>
        </div>
        <div class="input-group">
            <label for="address">Address</label>
            <input type="text" id="address" name="address" value="${client.address}" required>
        </div>
        <div class="input-group">
            <label for="birthdate">Birthdate</label>
            <input type="date" id="birthdate" name="birthDate" value="${client.birthDay}" required>
        </div>
        <div class="input-group">
            <label for="phone">Phone Number</label>
            <input type="tel" id="phone" name="phone" value="${client.phone}" required>
        </div>
        <%--    <div class="input-group">--%>
        <%--      <label for="CreatedBy">Created by:</label>--%>
        <%--      <input type="number" id="createdBy" name="createdBy" required>--%>
        <%--    </div>--%>
        <button type="submit" class="btn">Update Client</button>
    </form>
</div>
</body>
</html>
