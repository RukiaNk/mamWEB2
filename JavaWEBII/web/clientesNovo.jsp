<%-- 
    Document   : clientesNovo
    Created on : 04/11/2018, 16:30:26
    Author     : Marcos
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
                <title>Novo</title>
            </head>
            <div class="container">
                <div class="row">
                    <div class="col offset-m2 m8">
                        <h1 class="white-text">@Portal</h1>
                        <h2 class="white-text">Novo cliente</h2>
                        <div class="divider"></div>
                        <div class="card">
                            <div class="card-content">
                                <div class="card-title center-align">
                                    <h3>Dados do cliente:</h3>
                                </div>
                                <form action="NovoClienteServlet" method="post">
                                    <div class="col m6">
                                        <label>Nome:</label><input type="text" required
                                                                   name="nome" size="100" maxlength="100" />
                                        <label>CPF:</label><input type="text" required
                                                                  name="cpf" size="100" maxlength="100" />
                                        <label>Email:</label><input type="text" required
                                                                    name="email" size="100" maxlength="100" />
                                        <label>Rua:</label><input type="text" required
                                                                  name="rua" size="100" maxlength="100" />
                                        <label>Cidade:</label><input type="text" required
                                                                     name="cidade" size="100" maxlength="100" />
                                        <label>Numero:</label><input type="text" required
                                                                     name="numero" size="100" maxlength="100" />
                                        <label>Cep:</label><input type="text" required
                                                                  name="cep" size="100" maxlength="100" />
                                        <label>Data de Nascimento:</label><input type="text" required
                                                                                 name="data" size="100" maxlength="100" />
                                    </div>
                                    <div class="container">
                                        <div class="row">
                                            <div class="col m5">
                                                <button type="submit" class="waves-effect waves-teal btn">
                                                    <i class="material-icons right">Salvar</i>
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
