<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    *{
      margin: 0;
      padding: 0;
      font-family: sans-serif;
    }
    body{
      background: -webkit-linear-gradient(bottom, #0250c5, #d43f8d);
    }

    .banner{
      width:100%;
      height: 100vh;
      background-image: linear-gradient(rgba(0,0,0,0.75), rgba(0,0,0,0.75)), url(/images/ales-nesetril-ex_p4AaBxbs-unsplash.jpg);
      background-size: cover;
      background-position: center;
      /* display: inline-block;
      list-style: none;
      margin: 0 20px; */
    }

    .navbar{
      width:85%;
      margin: auto;
      padding: 35px 0;
      display: flex;
      align-items: center;
      justify-content: space-between;
    }

    .logo{
      width: 80px;
      cursor: pointer;
    }

    .content{
      width: 100%;
      position: absolute;
      top: 50%;
      transform: translateY(-50%);
      text-align: center;
      color: white;
    }

    .content h1{
      font-size: 70px;
      margin-top: 80px;
    }

    .content p{
      margin: 20px auto;
      font-weight: 100;
      line-height: 25px;

    }
    a{
      width: fit-content;
      padding: 15px;
      text-align: center;
      margin: 20px 10px;
      border-radius: 25px;
      font-weight: bold;
      margin-top: 10px;
      border: 2px solid #009688;
      background: transparent;
      color: #fff;
      cursor: pointer;
      text-decoration: none;
      position: relative;
      overflow: hidden;
    }
    span{
      background: #009688;
      height: 100%;
      width: 0;
      border-radius: 25px;
      position: absolute;
      left: 0;
      bottom: 0;
      z-index: -1;
      transition: 0.5s;
    }

    a:hover span{
      width: 100%;;
    }

    a:hover{
      border: none;
    }
  </style>
  <title>Landing page</title>
</head>
<body>
<%--<div class="container">--%>
<%--  <h1>Easybank Application:</h1>--%>
<%--  <div class="btn-group">--%>
<%--    <h2>Client menu:</h2>--%>
<%--    <button class="button"><a href="/addclient">Add client</a></button>--%>
<%--    <button class="button"><a href="/updateClient">Update client</a></button>--%>
<%--    <button class="button"><a href="/clientlist">All client</a></button>--%>
<%--  </div>--%>
<%--</div>--%>
<div class="banner">
  <div class="navbar">
  </div>
</div>

<div class="content">
  <h1>WE MAKE BANKING EASY</h1>
  <p>Our platfrom Easybank allow you to add clients update their info delete them or even <br>search between clients using one if their information</p>
  <div>
    <a href="/clientlist"><span></span> CLIENTS</a>
    <a href=""><span></span>EMPLOYEES</a>
  </div>
</div>
</body>
</html>
