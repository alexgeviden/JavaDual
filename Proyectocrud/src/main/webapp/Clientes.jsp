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
    <table border="1">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>DNI</th>
                <th>Correo</th>
                <th>Teléfono</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cliente" items="${clientes}">
                <tr>
                    <td>${cliente.getNombre()}</td>
                    <td>${cliente.getDNI()}</td>
                    <td>${cliente.getCorreo()}</td>
                    <td>${cliente.getTel()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
