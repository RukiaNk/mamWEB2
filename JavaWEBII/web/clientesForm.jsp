<%-- 
    Document   : clientesForm
    Created on : 09/11/2018, 18:54:37
    Author     : Marcos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page errorPage="/erro.jsp"%>
<%@page import="com.ufpr.tads.web2.beans.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="com.ufpr.tads.web2.beans.LoginBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário de clientes</title>

        <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script type="text/javascript" >
            function getCidades(idEstado) {
                var url = "AJAXServlet";
                $.ajax({
                    url: url, // URL da sua Servlet
                    data: {
                        estadoId: idEstado
                    }, // Parâmetro passado para a Servlet
                    dataType: 'json',
                    success: function (data) {
                        // Se sucesso, limpa e preenche a combo de cidade
                        // alert(JSON.stringify(data));
                        $("#cidade").empty();
                        $.each(data, function (i, obj) {
                            $("#cidade").append('<option value=' + obj.idCidade + '>' + obj.nomeCidade + '</option>');
                        });
                    },
                    error: function (request, textStatus, errorThrown) {
                        alert(request.status + ', Error: ' + request.statusText);
                        alert("Erro AJAX");
                    }
                });
            }
        </script>

    </head>
    <body>
        <jsp:useBean id="login" class="com.ufpr.tads.web2.beans.LoginBean" scope="session"/>

        <c:if test="${empty sessionScope.login}">
            <jsp:forward page="/index.jsp">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o sistema"/>
            </jsp:forward>
        </c:if>





        <c:if test="${alterar == 'true'}">
            <h1>Alterar dados do cliente</h1>

            <form action="ClientesServlet?action=update" method="POST">
                Nome: <input type="text" name="nome" value=${cliente.nomeCliente} required maxlength="100"> <br/>
                CPF: <input type="text" name="cpf" value=${cliente.cpfCliente} required
                            maxlength="11"  minlength="11" pattern="[0-9]{11}" title="only numbers"> <br/>
                Email: <input type="text" name="email" value=${cliente.emailCliente} maxlength="100"
                              required  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="xxx@xxx.xxx"> <br/>
                Data: <input type="date" name="data" value=${cliente.dataCliente} required> <br/>
                Rua: <input type="text" name="rua" value=${cliente.ruaCliente} required maxlength="100"> <br/>
                Número: <input type="number" name="numero" value=${cliente.nrCliente} 
                               required pattern="[0-9]"> <br/>
                CEP: <input type="text" name="cep" value=${cliente.cepCliente} required
                            pattern="[0-9]{8}" title="only numbers" maxlength="8"> <br/>
                Estado:
                <select name="estado" id ="estado" onChange="getCidades(estado.value)" required>
                    <option value="">Selecione</option>
                    <c:forEach items="${estados}" var="estado">  
                        <option value="${estado.idEstado}">${estado.nomeEstado}</option>
                    </c:forEach>
                </select>
                <br/>
                Cidade:
                <select name="cidade" id="cidade" required>
                    <option value="">Selecione</option>           
                </select>
                </br></br>
                <input type="submit" value="Alterar"> 
                <a href="ClientesServlet" class="waves-effect waves-teal btn">Cancelar<i class="material-icons right"></i></a>                                
            </form>
        </c:if>


        <c:if test="${alterar == 'false'}">

            <h1>Novo cliente</h1>

            <form action="ClientesServlet?action=new" method="POST">
                Nome: <input type="text" name="nome" required maxlength="100"> <br/>
                CPF: <input type="text" name="cpf" required
                maxlength="11" minlength="11" pattern="[0-9]{11}" title="only numbers"><br/>
                Email: <input type="text" name="email" required maxlength='100'
                              pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="xxx@xxx.xxx"><br/>
                Data: <input type="date" name="data" required><br/>
                Rua: <input type="text" name="rua" required maxlength='100'><br/>
                Número: <input type="number" name="numero" required><br/>
                CEP: <input type="text" name="cep" required
                            maxlength="8" pattern="[0-9]{8}" title="only numbers"><br/>

                Estado:
                <select name="estado" id ="estado" onChange="getCidades(estado.value)" required>
                    <option value="">Selecione</option>
                    <c:forEach items="${estados}" var="estado">  
                        <option value="${estado.idEstado}">${estado.nomeEstado}</option>
                    </c:forEach>
                </select>
                <br/>


                Cidade AJAX:
                <select name="cidade" id="cidade" required>
                    <option value="">Selecione</option>
                </select>
                <br/>
                <br/><br/>
                <input type="submit" value="Salvar">
                <a href="ClientesServlet" class="waves-effect waves-teal btn">Cancelar<i class="material-icons right"></i></a>                                
            </form>
        </c:if>
        </br></br> <a href="#void" onclick="getCidades();" style="color: darkblue">Carregar Cidade</a>
    </body>
</html>
