<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="Boos/node_modules/bootstrap/dist/css/bootstrap.css">        
    </head>
    <body>
        <%
            String usuario = (String) session.getAttribute("usuario");
            
            if(usuario==null){
                response.sendRedirect("index.jsp");
            }
        %>
        <nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
            <div class="container"><a class="navbar-brand" href="#">Projeto</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
			<li class="nav-item active">
			    <a class="nav-link" href="home.html">Home</a>
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
                        <li class="nav-item">
			    <a class="nav-link" href="Tabela2.jsp">Ver Tabela Produto<span class="sr-only">(current)</span></a>
			</li>
                    </ul>
		</div>
		  <div>
		</nav>
        <br><br><br><br><br><br>
    <center><h1>Projeto de Cadastro de Clientes e Produtos</h1></center>
    </body>
</html>
