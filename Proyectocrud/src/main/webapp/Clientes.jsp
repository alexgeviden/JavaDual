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
   
    <title>Lista de Clientes</title>
    <link rel="stylesheet" href="estilo.css"/>
</head>
<body>
    <h1 style="text-align: center">Lista de Clientes</h1>
    <div class="container">
    
    <table border="1">
        
        <thead>
            
            <tr>
                
                <th>Nombre</th>
                <th>DNI</th>
                <th>Correo</th>
                <th>Teléfono</th>
                <th>Opciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cliente" items="${clientes}">
                <tr>
                    <td>${cliente.getNombre()}</td>
                    <td>${cliente.getDNI()}</td>
                    <td>${cliente.getCorreo()}</td>
                    <td>${cliente.getTel()}</td>
                  <td>
           <!-- <form action="Controlador" method="post">
                <input type="hidden" name="action" value="editar"> <!-- Indicador de acción para editar -->
            <!--    <input type="hidden" name="dni" value="${cliente.getDNI()}"> <!-- DNI del cliente -->
             <!--   <button type="submit">Editar</button>
            </form>-->
            <form action="Controlador" method="post">
                <input type="hidden" name="action" value="eliminar"> <!-- Indicador de acción para eliminar -->
               
                <input type="hidden" name="dni" value="${cliente.getDNI()}"> <!-- DNI del cliente -->
                <button type="submit">Eliminar</button>
            </form>
        </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
                <div class="insert-form">
            <h1>Insertar Cliente</h1>
            <form action="Controlador" method="post">
                <!-- Campos para insertar un nuevo cliente -->
                <input type="hidden" name="action" value="insertar"> <!-- Indicador de acción para el servlet -->
                <label for="nombre">Nombre:</label>
                <input type="text" name="nombre" id="nombre"><br>
                <label for="dni">DNI:</label>
                <input type="text" name="dni" id="dni"><br>
                <label for="correo">Correo:</label>
                <input type="email" name="correo" id="correo"><br>
                <label for="tel">Teléfono:</label>
                <input type="tel" name="tel" id="tel"><br>

                <button type="submit">Insertar Cliente</button>
            </form>
                 </div>
                </div>
</body>
</html>
