<%-- 
    Document   : clientesAlterar
    Created on : 26/09/2018, 23:48:44
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
                <title>Alterar</title>
            </head>
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
                                <form action="AlterarClienteServlet" method="post">
                                    <div class="col m6">
                                        <input type="hidden" name="id" value=${cli.idCliente}>
                                        <label>Nome:</label><input type="text" required
                                                                   name="nome" size="100" maxlength="100" value=${cli.nomeCliente}>
                                        <label>CPF:</label><input type="text" required
                                                                  name="cpf" size="100" maxlength="100" value=${cli.cpfCliente}>
                                        <label>Email:</label><input type="text" required
                                                                    name="email" size="100" maxlength="100" value=${cli.emailCliente}>
                                        <label>Rua:</label><input type="text" required
                                                                    name="rua" size="100" maxlength="100" value=${cli.ruaCliente}>
                                        <label>Cidade:</label><input type="text" required
                                                                    name="cidade" size="100" maxlength="100" value=${cli.cidadeCliente}>
                                        <label>Numero:</label><input type="text" required
                                                                    name="numero" size="100" maxlength="100" value=${cli.nrCliente}>
                                        <label>Cep:</label><input type="text" required
                                                                    name="cep" size="100" maxlength="100" value=${cli.cepCliente}>
                                        <label>Data de Nascimento:</label><input type="text" required
                                                                    name="data" size="100" maxlength="100" value=${cli.dataCliente}>
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