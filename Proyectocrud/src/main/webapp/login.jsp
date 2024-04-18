<%-- 
    Document   : login
    Created on : 18 abr 2024, 13:15:02
    Author     : alexg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form name="formLogin" action="LoginController" method="POST">
            <input type="text" name="username" value="" />
            <input type="password" name="password" value="" />
            <input type="submit" value="Ingresar" name="ingresar" />
               
            
            
        </form>
    </body>
</html>
