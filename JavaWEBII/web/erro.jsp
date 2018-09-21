<%-- 
    Document   : erro
    Created on : 20/09/2018, 22:57:54
    Author     : ananicole
--%>

<%@page import="javax.servlet.jsp.PageContext" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body class="bgimg">
        <div class="container">
            <div class="row bordered">
                <h1 class="red-text">
                    <c:out value="${exception.message}" /></h1>
                <h2 class="red-text">
                    <c:out value="${pageContext.out()}" /><br/>
                    <c:out value="${exception.printStackTrace(pageContext.response.writer)}" /><br/>
                </h2>
                <h3 class="white-text">Para voltar à Home <a href="index.html" class="black-text pulse"><strong>Clique aqui</strong></a>.</h3>
            </div>
        </div>
<%@include file="footer.jsp" %>
    </body>
</html>
