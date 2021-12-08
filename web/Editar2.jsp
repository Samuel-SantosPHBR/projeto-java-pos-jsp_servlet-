<%@page import="Classe.ProdutoDAO"%>
<%@page import="Classe.ClienteDAO"%>
<%@page import="Classe.Conexao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Boos/node_modules/bootstrap/dist/css/bootstrap.css">
        <title>Tabelas</title>
        
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
            <div class="container"><a class="navbar-brand" href="#">Projeto</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
			<li class="nav-item">
			    <a class="nav-link" href="index.html">Home</a>
			</li>
			<li class="nav-item">
			    <a class="nav-link" href="CadastroCliente.jsp">Adicionar Usuarios</a>
			</li>
                        <li class="nav-item">
			    <a class="nav-link" href="CadastroProduto.jsp">Adicionar Produto</a>
			</li>
			<li class="nav-item">
			    <a class="nav-link" href="Tabela.jsp">Ver Tabela Cliente<span class="sr-only">(current)</span></a>
			</li>
                        <li class="nav-item active">
			    <a class="nav-link" href="Tabela2.jsp">Ver Tabela Produto<span class="sr-only">(current)</span></a>
			</li>
                    </ul>
		</div>
		  <div>
		</nav>
<%
String a = request.getParameter("codigo");
ProdutoDAO dao = new ProdutoDAO();
out.print(dao.listagemJSP2(a));

%>

    </body>
</html>
