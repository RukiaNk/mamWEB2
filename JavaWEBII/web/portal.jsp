<%-- 
    Document   : portal
    Created on : 20/09/2018, 20:08:37
    Author     : ananicole
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="erro.jsp" %>
<%-- Procura se existe um usuário instanciado --%>
<c:choose>
    <c:when test="${empty sessionScope.user}">
        <jsp:forward page="index.jsp">
            <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema." />
        </jsp:forward>
    </c:when>
    <c:otherwise>
        <!DOCTYPE html>
        <html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <style type="text/css">@import url("materialize/css/materialize.css");</style>
                <style type="text/css">@import url("materialize/css/materialize.min.css");</style>
                <style type="text/css">@import url("materialize/css/web2.css");</style>
        <link href="resources/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="resources/bootstrap/dist/css/bootstrap-reboot.min.css" type="text/css">
                <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
                <link rel="icon" href="java.ico">
                <title>Portal</title>
            </head>
            <%@include file="menu.jsp" %>
            <body class="bgimg">
                <div class="container">
                    <div class="row">           
                        <div class="container">
                            <h1 class="jumbotron-heading">Olá, ${user.nome}</h1>
                            <div class="divider"></div>
                            <div style="height: 50px;"></div>
                            <div class="collection">
                                <a href="inserir.jsp" class="collection-item btn btn-primary my-2">Cadastro de clientes</a>
                                <a href="LogoutServlet" class="collection-item btn btn-secondary my-2">Sair</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="footer.jsp" %>
            </body>
        </html>        
    </c:otherwise>    
</c:choose>