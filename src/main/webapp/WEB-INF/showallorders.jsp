<%-- 
    Document   : showallorders
    Created on : 21-03-2018, 16:13:01
    Author     : mette
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="functionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vis alle ordrer</title>
        <link href="styleSheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Liste over alle ordrer i systemet:</h1>
        <%  ArrayList<Order> ordersSent = (ArrayList<Order>) request.getAttribute("orderssent");
            ArrayList<Order> ordersNotSent = (ArrayList<Order>) request.getAttribute("ordersnotsent");
            if (ordersNotSent.size() == 0 && ordersSent.size() == 0) { %>
        <p><%out.print("Der er i øjeblikket ingen ordrer registreret i systemet.");%></p>
        <%  }%>
        <%if (ordersNotSent.size() != 0) {%>
        <table border="1">
            <thead>
                <tr>
                    <th><p>Ordre ID </th>
                    <th><p>Kunde ID </th>
                    <th><p>Højde </th>
                    <th><p>Længde </th>
                    <th><p>Bredde </th>
                    <th><p>Afsendt</th>
                </tr>
            </thead>
            <tbody>
                <% for (Order order : ordersNotSent) {%>
                <tr>
                    <th><p> <% out.print(order.getOrderID()); %> </th>
                    <th><p> <% out.print(order.getUserID()); %> </th> 
                    <th><p> <% out.print(order.getHeight()); %> </th> 
                    <th><p> <% out.print(order.getLength()); %> </th> 
                    <th><p> <% out.print(order.getWidth()); %> </th> 
                    <th><p> <% out.print("Ikke endnu"); %></th> 
                    <th>
                        <form action="ServletFrontController" method="post">
                            <input type="hidden" name="command" value="setsent">
                            <input type="hidden" name="orderID" value="<%out.print(order.getOrderID());%>" />
                            <input type="submit" value="Sæt til afsendt"/><br>
                        </form>
                    </th>
                    <%  }%>
                </tr>
            </tbody>
        </table>
        <%  }%>
        <br>
        <%if (ordersSent.size() != 0) {%>
        <table border="1">
            <thead>
                <tr>
                    <th><p>Ordre ID </th>
                    <th><p>Kunde ID </th>
                    <th><p>Højde </th>
                    <th><p>Længde </th>
                    <th><p>Bredde </th>
                    <th><p>Afsendt</th>
                </tr>
            </thead>
            <tbody>
                <% for (Order order : ordersSent) {%>
                <tr>
                    <th><p> <% out.print(order.getOrderID()); %> </th>
                    <th><p> <% out.print(order.getUserID()); %> </th> 
                    <th><p> <% out.print(order.getHeight()); %> </th> 
                    <th><p> <% out.print(order.getLength()); %> </th> 
                    <th><p> <% out.print(order.getWidth()); %> </th> 
                    <th><p> <% out.print("Ja!");%></th> 
                        <%  }%>
                </tr>
            </tbody>
        </table>
        <%  }%>
        <br>
        <form action="ServletFrontController" method="post">
            <input type="hidden" name="command" value="backtoadmin">
            <input type="submit" value="Tilbage til adminside"/><br>
        </form>
        <br>
        <form action="ServletFrontController" method="post">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="Log ud"/><br>
        </form>
    </body>
</html>
