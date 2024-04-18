<%-- 
    Document   : Clientes
    Created on : 18 abr 2024, 19:47:37
    Author     : a925660
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
    
      <c:forEach var="cliente" items="${clientes}">
                <tr>
                    <td>${cliente.getNombre()}</td>
                    <td>${cliente.getDNI()}</td>
                    <td>${cliente.getCorreo()}</td>
                    <td>${cliente.getTel()}</td>
                </tr>
            </c:forEach>
    
</table>



</body>
</html>
