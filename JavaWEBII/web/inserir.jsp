<%-- 
    Document   : inserir
    Created on : 20/09/2018, 23:25:11
    Author     : ananicole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="erro.jsp"%>
<c:if test="${empty sessionScope.user}">
    <jsp:forward page="index.html">
        <jsp:param name="msg"
                   value="Usuário deve se autenticar para acessar o sistema." />
    </jsp:forward>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <c:otherwise>
        <title>Novo</title>
    </head>
    <div class="container">
        <div class="row">
            <div class="col offset-m2 m8">
                <h1 class="white-text">@Portal</h1>
                <h2 class="white-text">Olá, ${user.nome}</h2>
                <div class="divider"></div>
                <div class="card">
                    <div class="card-content">
                        <div class="card-title center-align">
                            <h3>Dados do cliente</h3>
                        </div>
                        <form action="CadastrarUsuarioServlet" method="post">
                            <div class="col m6">
                                <label>Nome:</label><input type="text" required
                                                           name="nome" size="100" maxlength="100" />
                                <label>Login</label><input type="text" required
                                                           name="login" size="100" maxlength="100" />
                                <label>Senha</label><input type="text" required
                                                           name="senha" size="100" maxlength="100" />
                            </div>

                            <div class="container">
                                <div class="row">
                                    <div class="col m5">
                                        <button type="submit" class="waves-effect waves-teal btn">
                                            salvar<i class="material-icons right">salvar</i>
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
    </div>
</c:otherwise>
</c:choose>
<%@include file="footer.jsp"%>
</body>
</html>
