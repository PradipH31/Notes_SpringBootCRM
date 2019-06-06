<%-- 
    Document   : index
    Created on : Jun 6, 2019, 9:46:25 AM
    Author     : HP B&O
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${name}!</h1>
    </body>
    <ul>
        <c:forEach var="source" items="${sources}">
            <li>${source.name}</li>
        </c:forEach>
    </ul>
</html>
