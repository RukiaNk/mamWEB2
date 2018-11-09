<%-- 
    Document   : clientesAlterar
    Created on : 26/09/2018, 23:48:44
    Author     : ananicole
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
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
                <title>Alterar</title>
            </head>
            <body>
                <jsp:useBean id="cliente" class="com.ufpr.tads.web2.beans.Cliente" scope="request"/>
                <div class="container">
                    <div class="row">
                        <div class="col offset-m2 m8">
                            <h1 class="white-text">@Portal</h1>
                            <h2 class="white-text">Dados do cliente selecionado:</h2>
                            <div class="divider"></div>
                            <div class="card">
                                <div class="card-content">
                                    <div class="card-title center-align">
                                        <h3>Dados do cliente</h3>
                                    </div>
                                    <form action="ClientesServlet?action=update" method="post">
                                        <div class="col m6">
                                            <input type="hidden" name="id" value=${cliente.idCliente}>
                                            <label>Nome:</label><input type="text" required
                                                                       name="nome" size="100" maxlength="100" value=${cliente.nomeCliente}>
                                            <label>CPF:</label><input type="text" required
                                                                      name="cpf" size="100" maxlength="100" value=${cliente.cpfCliente}>
                                            <label>Email:</label><input type="text" required
                                                                        name="email" size="100" maxlength="100" value=${cliente.emailCliente}>
                                            <label>Rua:</label><input type="text" required
                                                                      name="rua" size="100" maxlength="100" value=${cliente.ruaCliente}>
                                            <label>Numero:</label><input type="text" required
                                                                         name="numero" size="100" maxlength="100" value=${cliente.nrCliente}>
                                            <label>Cep:</label><input type="text" required
                                                                      name="cep" size="100" maxlength="100" value=${cliente.cepCliente}>
                                            <label>Data de Nascimento:</label><input type="text" required
                                                                                     name="data" size="100" maxlength="100" value=${cliente.dataCliente}>
                                        </div>
                                        <div class="container">
                                            <div class="row">
                                                <div class="col m5">
                                                    <button type="submit" class="waves-effect waves-teal btn">
                                                        <i class="material-icons right">Alterar</i>
                                                    </button>
                                                </div>
                                                <div class="col offset-s6">
                                                    <a href="ClientesServlet" class="waves-effect waves-teal btn">Cancelar<i class="material-icons right"></i></a>                                
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="height: 100px;"></div>
                </div>
                <%@include file="footer.jsp"%>
            </body>
        </html>
    </c:otherwise>
</c:choose>