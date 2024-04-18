<%-- 
    Document   : Clientes
    Created on : 18 abr 2024, 15:12:13
    Author     : alexg
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Clientes</title>
</head>
<body>
    <h1>Lista de Clientes</h1>
    <ul>
        <c:forEach var="cliente" items="${clientes}">
            <li>${cliente.getNombre()} ${cliente.getDNI()} ${cliente.getCorreo()} ${cliente.getTel()}</li>
        </c:forEach>
    </ul>
</body>
</html>
