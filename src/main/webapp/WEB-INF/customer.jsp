<%-- 
    Document   : customer
    Created on : 19-03-2018, 15:21:32
    Author     : mette
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
        <link href="styleSheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Velkommen til din side i LegoHus butikken.</h1>
        <h2>${message}</h2>
        <p>Her kan du indtaste den ønskede størrelse på dit legohus.</p>
        <p>I huset vil der være en dør i facaden der er 3 klodser høj og 2 prikker bred,</p>
        <p>og et vindue på bagsiden der er 2 klodser højt og 2 prikker bredt.</p>
        <form name="login" action="ServletFrontController" method="post">
            <input type="hidden" name="command" value="inputhouse">
            <br><p>Højde, antal klodser: <input type="text" name="height" placeholder="Min 4, max 10...">
            <br>Længde, antal prikker: <input type="text" name="length" placeholder="Min 8, max 40...">
            <br>Bredde, antal prikker: <input type="text" name="width" placeholder="Min 5, max 30...">
            <br><input type="submit" value="Beregn stykliste">
        </form>
        <br>
        <p>Herunder kan du se dine tidligere ordrer, samt hvorvidt de er afsendt:</p>
        <form name="orders" action="ServletFrontController" method="post">
            <input type="hidden" name="command" value="showordersuser">
            <br><input type="submit" value="Se tidligere ordrer">
        </form>
        <% String error = (String) request.getAttribute("error");
            if (error != null) {%>
        <p> Error! </p>
        <p> <%=error%>
            <%}%>
            <br>
        <form action="ServletFrontController" method="post">
            <input type="hidden" name="command" value="logout">
            <input type="submit" value="Log ud"/><br>
        </form>
    </body>
</html>
