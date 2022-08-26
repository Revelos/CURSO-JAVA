<%--
  Created by IntelliJ IDEA.
  User: PC-COL2
  Date: 25/8/2022
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Primera Pagina</title>
</head>
<body>
<h2>Hola mundo EJB!</h2>
<h3>${saludo}</h3>
<h3>${saludo2}</h3>

<ul>
<c:forEach items="${listado}" var="prod">
    <li>${prod.nombre}</li>
</c:forEach>
</ul>

</body>
</html>
