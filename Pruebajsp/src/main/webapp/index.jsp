<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Llamada a Servlet desde JSP</title>
</head>
<body>
    <h2>Hello World</h2>
    Esta es la hora: <%= new java.util.Date() %>
    <hr>
    <h3>Respuesta del Servlet:</h3>
    <jsp:include page="/mensaje" />
</body>
</html>
