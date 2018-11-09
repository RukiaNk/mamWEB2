<%-- 
    Document   : index
    Created on : 20/09/2018, 23:17:01
    Author     : ananicole
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page errorPage="erro.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv`="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="resources/bootstrap/dist/css/bootstrap-reboot.min.css" type="text/css">
        <title>Home</title>
    </head>
    <body class="bgimg">
        <div class="container">
                <div class="col offset-m3 m6" style="width: 400px; margin: 100px;">
                        <div class="card-content">
                            <div class="card-title center-align"><h3> Login</h3></div>
                            <form action="LoginServlet" method="post" class="form-horizontal">
                               <div class="form-group"> Login: <input type="text" name="login" value=""/></div>
                               <div class="form-group"> Senha: <input type="password" name="senha" value=""/></div>
                                <input type="submit" value="Entrar" class="btn btn-secondary">
                            </form>
                            <h5></br>
                                <div class="red-text my-5 pt-5 text-muted text-center text-small">
                                    <c:out value="${ (empty requestScope.msg) ? ((empty param.msg) ? '' : param.msg) : requestScope.msg }" />
                                </div>
                            </h5>
                    </div>
                </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>