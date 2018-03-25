<%-- 
    Document   : visstykliste
    Created on : 21-03-2018, 14:18:12
    Author     : mette
--%>

<%@page import="functionLayer.House"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vis stykliste for tidligere ordre:</title>
        <link href="styleSheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <% int orderID = Integer.parseInt(request.getParameter("orderID"));
            House house = (House) request.getAttribute("house");
        %>
        <h1>Stykliste for ordre: <% out.print(orderID);%></h1>
        <br>
        <br>
        <table border="1">
            <tr>
                <th><p>Klodstype</th>
                <th><p>Hus forside</th>
                <th><p>Hus bagside</th>
                <th><p>Gavle, ialt</th>
                <th><p>Total antal per type</th>
            </tr>
            <tr>
                <th><p>1x2</th>
                <td><p><%out.print(house.getFrontSide1x2()); %></td>
                <td><p><%out.print(house.getBackSide1x2()); %></td>
                <td><p><%out.print(house.getGables1x2()); %></td>
                <td><p><%out.print(house.getAll1x2());%></td>
            </tr>
            <tr>
                <th><p>2x2</th>
                <td><p><%out.print(house.getFrontSide2x2()); %></td>
                <td><p><%out.print(house.getBackSide2x2()); %></td>
                <td><p><%out.print(house.getGables2x2()); %></td>
                <td><p><%out.print(house.getAll2x2());%></td>
            </tr>
            <tr>
                <th><p>4x2</th>
                <td><p><%out.print(house.getFrontSide4x2()); %></td>
                <td><p><%out.print(house.getBackSide4x2()); %></td>
                <td><p><%out.print(house.getGables4x2()); %></td>
                <td><p><%out.print(house.getAll4x2());%></td>
            </tr>
        </table>
        <br>
        <form action="ServletFrontController" method="post">
            <input type="hidden" name="command" value="newcalculation">
            <input type="submit" value="Tilbage til Min Side"/><br>
        </form>
        <br>
        <form action="ServletFrontController" method="post">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="Log ud"/><br>
        </form>
    </body>
</html>
