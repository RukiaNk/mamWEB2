<%-- 
    Document   : menu
    Created on : 21/09/2018, 16:55:05
    Author     : michellynk
--%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" style="color: white;">Portal</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="portal.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="clientesNovo.jsp">Cadastrar Cliente</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ClientesServlet?action=list">Listar Clientes</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="LogoutServlet">Sair</a>
      </li>
    </ul>
    <span class="navbar-text">
      by 
      Ana, Marcos, Michelly
    </span>
  </div>
</nav>

