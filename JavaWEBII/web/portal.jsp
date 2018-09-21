<%-- 
    Document   : portal
    Created on : 20/09/2018, 20:08:37
    Author     : ananicole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="erro.jsp" %>
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

                <title>Portal</title>
            </head>
            <body class="bgimg">
                <jsp:useBean id="LoginBean" class="com.ufpr.tads.web2.beans.LoginBean" scope="session"/> 
                
                <div class="container">
                    <div class="row">
                        <div class="col offset-m3 m6">
                            <h1 class="white-text">@Portal</h1>
                            <h2 class="white-text">Olá, <jsp:getProperty name="LoginBean" property = "nome"/></h2>
                            <div class="divider"></div>
                            <div style="height: 50px;"></div>
                            <div class="collection">
                                <a href="LogoutServlet" class="collection-item">Sair</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%@include file="erro.jsp" %>
            </body>
        </html>        
    </c:otherwise>    
</c:choose>