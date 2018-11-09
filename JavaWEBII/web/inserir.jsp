<%-- 
    Document   : inserir
    Created on : 20/09/2018, 23:25:11
    Author     : ananicole
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="erro.jsp"%>
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
                <link href="resources/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
                <link rel="stylesheet" href="resources/bootstrap/dist/css/bootstrap-reboot.min.css" type="text/css">
                <title>Novo</title>
            </head>
            <%@include file="menu.jsp" %>
            <div class="container" >
                <div class="row">
                    <div class="col offset-m2 m8">
                        <div class="divider"></div>
                            <div class="card-content">
                                <div class="card-title center-align pt-4">
                                    <h3>Dados do Usuário</h3>
                                </div>
                                <form action="CadastrarUsuarioServlet" method="post">
                                    <div class="col m6" >
                                        <label>Nome:</label>
                                        <input type="text" required name="nome" size="100" maxlength="100"/>
                                        <label>Login:</label>
                                        <input type="text" required name="login" size="100" maxlength="100"/>
                                        <label>Senha:</label>
                                        <input type="text" required name="senha" size="100" maxlength="100"/>
                                    </div>
                                    <div class="container">
                                        <div class="row">
                                            <div class="col m5">
                                                <button type="submit" class="waves-effect waves-teal btn">
                                                    <i class="material-icons right">Salvar</i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="height: 100px;"></div>
            <%@include file="footer.jsp"%>
        </body>
    </html>
</c:otherwise>
</c:choose>
