<%-- 
    Document   : listar
    Created on : 17 abr 2024, 16:18:47
    Author     : a925660
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Clientes</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>DNI</th>
                        <th>Correo</th>
                        <th>Telefono</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <%
                ClienteDAO dao = new ClienteDAO();
                List<Cliente>list=dao.listar();
                Iterator<Cliente>iter=list.iterator();
                Cliente cli=null;
                while(iter.hashnext()){
                    cli=iter.next();
                    
                
                
                %>
                <tbody>
                    <tr>
                        <td><%= cli.getNombre() %></td>
                        <td><%= cli.getDni() %></td>
                        <td><%= cli.getCorreo() %></td>
                        <td><%= cli.getTelefono() %></td>
                        <td>
                            <a>Editar</a>
                            <a>Borrar</a>
                            
                        </td>
                    </tr>
                    <%} %>
                </tbody>
            </table>

            
        </div>
           
    </body>
</html>
