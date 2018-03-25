<%-- 
    Document   : employee
    Created on : 19-03-2018, 15:22:33
    Author     : mette
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
        <link href="styleSheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Du er nu logget ind på administratorsiden.</h1>
        <p>Her kan du se alle ordrer i systemet:
        <form name="orders" action="ServletFrontController" method="post">
            <input type="hidden" name="command" value="showordersemp">
            <br><input type="submit" value="Se alle ordrer">
        </form>
        <br>
        <form action="ServletFrontController" method="post">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="Log ud"/><br>
        </form>
    </body>
</html>
