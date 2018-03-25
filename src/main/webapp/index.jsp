<%-- 
    Document   : index
    Created on : 19-03-2018, 13:29:39
    Author     : mette
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
        <link href="styleSheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Velkommen til LegoHus butikken!</h1>
        <p>Login:
        <form name="login" action="ServletFrontController" method="post">
            <input type="hidden" name="command" value="login">            
            <br><p>Email: <input type="text" name="email" placeholder="Email...">
            <br><p>Password: <input type="password" name="password" placeholder="Password...">
                <br><input type="submit" value="Login">
        </form>
        <br>
        <br>
        <p>Ny kunde? Registrér dig herunder:
        <form name="register" action="ServletFrontController" method="post">
            <input type="hidden" name="command" value="register">
            <br><p>Email: <input type="text" name="email" placeholder="Email...">
            <br><p>Password: <input type="password" name="password1" placeholder="Password...">
            <br><p>Gentag password: <input type="password" name="password2" placeholder="Gentag password...">
                <br><input type="submit" value="Registrer">
        </form>
        <% String error = (String) request.getAttribute("error");
                        if (error != null) {%>
        <p> Error! </p>
        <p> <%=error%>
            <%}%>
    </body>
</html>
