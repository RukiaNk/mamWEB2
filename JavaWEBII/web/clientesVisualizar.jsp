<%-- 
    Document   : clientesVisualizar
    Created on : 21/09/2018, 02:06:35
    Author     : ananicole
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="cli" class="com.ufpr.tads.web2.beans.Cliente" scope="request"/>
        <h1>Visualizando <jsp:getProperty name="cli" property="nomeCliente"/></h1>
    </body>
</html>
