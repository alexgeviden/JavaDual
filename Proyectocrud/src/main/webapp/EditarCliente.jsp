<%-- 
    Document   : EditarCliente
    Created on : 18 abr 2024, 20:36:26
    Author     : a925660
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Cliente</title>
</head>
<body>
    <h1>Editar Cliente</h1>
    <form action="Controlador" method="post">
        <!-- Campos para editar el cliente -->
        <input type="hidden" name="action" value="update"> <!-- Indicador de acción para el servlet -->
        <input type="hidden" name="dni" value="${cliente.dni}"> <!-- DNI del cliente a editar -->
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" id="nombre" value="${cliente.nombre}"><br>
        <label for="correo">Correo:</label>
        <input type="email" name="correo" id="correo" value="${cliente.correo}"><br>
        <label for="tel">Teléfono:</label>
        <input type="tel" name="tel" id="tel" value="${cliente.tel}"><br>
         
        <button type="submit">Guardar Cambios</button>
    </form>
</body>
</html>
