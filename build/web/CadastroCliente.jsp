<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Boos/node_modules/bootstrap/dist/css/bootstrap.css">
        <title>Cadastro Cliente</title>
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
			    <a class="nav-link" href="home.html">Home</a>
			</li>
			<li class="nav-item  active">
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
        <div class="container-fluid ml-4">
            <form action="Cadastro" method="POST"> 
                <div class="form-group">
                    <label for="exampleFormControlInput1">Nome:</label>
                    <input type="text" class="form-control col-md-4" name="nome" id="nome">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Email:</label>
                    <input type="email" class="form-control col-md-4" name="email" id="email">
                </div>    
                <div class="form-group">
                    <label for="exampleFormControlInput1">Endereco</label>
                    <input type="text" class="form-control col-md-4" name="endereco" id="endereco">
                </div>    
                <div class="form-group">
                    <label for="exampleFormControlInput1">Telefone:</label>
                    <input type="text" class="form-control col-md-4" name="telefone" id="telefone">
                </div>    
                <div class="form-group">
                    <label for="exampleFormControlInput1">CPF:</label>
                    <input type="number" class="form-control col-md-4"  name="cpf" id="cpf">
                </div>    

                    <input type="submit" value="Enviar" class="btn btn-primary">
            </form>
        </div>
        
        <script type="text/javascript" src="Boos/node_modules/jquery/dist/jquery.js"></script>
	<script type="text/javascript" src="Boos/node_modules/popper.js/dist/popper.js"></script>
	<script type="text/javascript" src="Boos/node_modules/bootstrap/dist/js/bootstrap.js"></script>
    </body>
</html>
