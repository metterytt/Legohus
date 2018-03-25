<%-- 
    Document   : showuserorders
    Created on : 21-03-2018, 13:26:17
    Author     : mette
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="functionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Orders</title>
        <link href="styleSheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Her er dine tidligere Legohus ordrer:</h1>
        <% ArrayList<Order> userOrders = (ArrayList<Order>) request.getAttribute("userorders");
            if (userOrders.size() == 0) { %>
        <p><%out.print("Du har ikke nogen tidligere ordrer registreret i systemet.");%></p>
        <%} else {%>
        <table border="1">
            <thead>
                <tr>
                    <th><p>Ordre ID </th>
                    <th><p>Højde </th>
                    <th><p>Længde </th>
                    <th><p>Bredde </th>
                    <th><p>Afsendt</th>
                </tr>
            </thead>
            <tbody>
                <% for (Order order : userOrders) {%>
                <tr>
                    <th><p> <% out.print(order.getOrderID()); %> </th>
                    <th><p> <% out.print(order.getHeight()); %> </th> 
                    <th><p> <% out.print(order.getLength()); %> </th> 
                    <th><p> <% out.print(order.getWidth()); %> </th> 
                    <th><p> <% if (order.isSent()) {
                            out.print("Ja!");
                        } else {
                            out.print("Ikke endnu");
                        } %></th> 
                    <th>
                        <form action="ServletFrontController" method="post">
                            <input type="hidden" name="command" value="showstykliste">
                            <input type="hidden" name="orderID" value="<%out.print(order.getOrderID());%>" />
                            <input type="hidden" name="height" value="<%out.print(order.getHeight());%>" />
                            <input type="hidden" name="length" value="<%out.print(order.getLength());%>" />
                            <input type="hidden" name="width" value="<%out.print(order.getWidth());%>" />
                            <input type="submit" value="Se stykliste"/><br>
                        </form>
                    </th>
                    <%  }%>
                </tr>
            </tbody>
        </table>
        <%  }%>
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
