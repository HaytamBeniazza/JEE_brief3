<%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 10/13/2023
  Time: 9:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Client table</title>
  <style>
    a {
      display: inline-block;
      padding: 10px 20px;
      margin: 5px;
      background-color: #0056a0;
      color: #fff;
      text-decoration: none;
      border-radius: 5px;
    }

    a:hover {
      background-color: #0056a0;
    }
    table {
      font-family: arial, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }
    td, th {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }
    .buttonAddclient {
      text-align: center;
      margin-bottom: 20px;
    }

    .col-md-2 {
      font-weight: bold;
    }

    .col-md-10 {
      display:block;

    }

    .search {
      padding: 5px;
      width: 100%;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    button {
      padding: 5px 10px;
      background-color: #0074D9;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    button:hover {
      background-color: #0056a0;
    }

    .buttonAddclient {
      text-align: center;
      margin-bottom: 20px;
    }

    .col-md-2 {
      font-weight: bold;
    }

    .search {
      padding: 5px;
      width: 100%;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    .buttonAddclient a {
      display: inline-block;
      padding: 5px 10px;
      background-color: green;
      color: #fff;
      text-decoration: none;
      border-radius: 5px;
    }

    .buttonAddclient a:hover {
      background-color: #0056a0;
    }
    .form{
      display: flex;
      gap: 5px;
      align-items: center;

    }
    .deleteButton{
      background-color: red;
    }
    .row{
      display: flex;
      flex-direction: row-reverse;
      justify-content: space-between;
      padding: 20px;
    }
  </style>
</head>
<body>

<div class="container" data-ng-app="myApp" data-ng-controller="myCtrl">
  <div class="row">

    <div class="col-md-2">
      Search:
      <form class="form" action="/clientlist" method="get">
        <input name="search" type="text" class="search" data-ng-model="table"/>
        <button type="submit">Search</button>
      </form>
    </div>

    <div class="col-md-10">
      <div class="buttonAddclient">
        <a href="/addclient">add client</a>
      </div>
    </div>

  </div>
  <br/>
  <table>
    <thead>
    <tr>
      <th>code</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Birth Date</th>
      <th>Address</th>
      <th>Phone</th>
      <th>Options</th>
    </tr>
    </thead>
    <tbody>
    <tr class="clickable">
        <c:forEach items="${clientlist}" var="client">
      <td>${client.code}</td>
      <td>${client.firstName}</td>
      <td>${client.lastName}</td>
      <td>${client.birthDay}</td>
      <td>${client.address}</td>
      <td>${client.phone}</td>
      <td>
        <a class="updateButton" href="/updateclient?id=${client.code}">Update</a>
        <a class="deleteButton" onclick="alert('employee deleted')" href="/deleteclient?id=${client.code}">Delete</a>
      </td>
    </tr>
        </c:forEach>
    </tbody>

  </table>
  <div data-current-page="currentPage" data-max-size="maxSize" data-boundary-links="true"></div>
</div>
</body>
</html>
