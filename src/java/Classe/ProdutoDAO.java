package Classe;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {
    
    private Connection connection;
	
    public ProdutoDAO(){
	this.connection = Conexao.getConexaoMySQL();//1 = Postgre, 2 = SQL Server, 3 = MySql
    }
    
    public void adiciona(Produto produto) throws SQLException{
        //prepara o sql de inserção no banco
	String sql1 = "INSERT INTO `produto`(`nome`, `tipo`, `fornecedor`,valor,quantidade) VALUES (?,?,?,?,?)";
        
        //prepara o sql e executa o sql
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql1)) {
            preparedStatement.setString(1,produto.getNome());
            preparedStatement.setString(2,produto.getTipo());
            preparedStatement.setString(3,produto.getFornecedor());
            preparedStatement.setFloat(4,produto.getValor());
            preparedStatement.setInt(5,produto.getQuantidade());
            preparedStatement.execute();
            
        }
    }
    public String listagemJSP() throws SQLException{		
		//Seleciona e Lista em uma tabela todos os produtos e               
		String sql = "SELECT * FROM produto ORDER BY codigo";
                //prepara o sql
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
                //executa o sql
		ResultSet rs = preparedStatement.executeQuery();
                //string responsavel por montar a tabela
		String s = "<table class=\"table table-striped\" >";
		s += "<tr><th scope=\"col\">Codigo</th> ";
		s += "<th scope=\"col\">Nome</th> ";
		s += "<th scope=\"col\">Fornecedor</th> ";
                s += "<th scope=\"col\">tipo</th>";
		s += "<th scope=\"col\">Quantidade</th> ";
		s += "<th scope=\"col\">Valor</th>";
                s += "<th scope=\"col\">Ação</th> </tr>";
		
                // pega os resultados do banco e adiciona na tabela
		while(rs.next()){
			s += "<tr>";
			s += "<td>" + rs.getInt("codigo") + "</td>"; 
			s += "<td>" + rs.getString("nome") + "</td>"; 
			s += "<td>" + rs.getString("fornecedor") + "</td>";
                        s += "<td>" + rs.getString("tipo") + "</td>";
			s += "<td>" + rs.getInt("quantidade") + "</td>";
			s += "<td>" + rs.getFloat("valor")+ "</td>";
                        s += "<td><a href='Excluir2?codigo=" + rs.getInt("codigo")+ "' class=\"btn btn-secondary\">Excluir</a><a href='Editar2.jsp?codigo=" + rs.getInt("codigo")+ "' class=\"btn btn-primary\">Editar</a></td>";
			s += "</tr>";
		}
		s += "</table>";
		
		//fecha a conexao com o banco
		rs.close();
                //fecha o sql do banco
		preparedStatement.close();
		//retorna o string 
		return s;
	}
    
            //recebe uma string 
            public String listagemJSP2(String a) throws SQLException{		
		//transforma uma instring em um inteiro chamado codigo para selecionar 
                
                int codigo = parseInt(a);
                
                //seleciona todos os produtos
		String sql = "SELECT * FROM produto";
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
                
		ResultSet rs = preparedStatement.executeQuery();
		String s="";
                
                //se o resultado for diferene de null 
                if(rs != null) {
                    while(rs.next()) {
                        //se o codigo for igual ao codigo do produto ele cria um form com os dados selecionados
                        if(rs.getInt("codigo")==codigo){
                            
                            s="<div class=\"container-fluid ml-4\">\n" +
"            <form action=\"Editar2\" method=\"POST\"> \n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"exampleFormControlInput1\">Nome:</label>\n" +
"                    <input type=\"text\" class=\"form-control col-md-4\" name=nome id=\"nome\" value="+rs.getString("nome")+">\n" +
"                </div>\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"exampleFormControlInput1\">Tipo:</label>\n" +
"                    <input type=\"text\" class=\"form-control col-md-4\" name=tipo id=\"tipo\" value="+rs.getString("tipo")+">\n" +
"                </div>    \n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"exampleFormControlInput1\">Fornecedor</label>\n" +
"                    <input type=\"text\" class=\"form-control col-md-4\" name=fornecedor id=fornecedor value="+rs.getString("fornecedor")+">\n" +
                                    "<input type=\"hidden\" class=\"form-control col-md-4\" name=codigo id=\"codigo\" value="+rs.getInt("codigo")+">\n" +
"                </div>    \n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"exampleFormControlInput1\">Valor:</label>\n" +
"                    <input type=\"number\" class=\"form-control col-md-4\" name=valor id=\"valor\" value="+rs.getFloat("valor")+">\n" +
"                </div>    \n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"exampleFormControlInput1\">Quantidade:</label>\n" +
"                    <input type=\"number\" class=\"form-control col-md-4\"  name=quantidade id=\"quantidade\" value="+rs.getInt("quantidade")+">\n" +
"                </div>    \n" +
"\n" +
"                    <input type=\"submit\" value=\"Alterar\" class=\"btn btn-primary\">\n" +
"            </form>\n" +
"        </div>";
                           
                        
			}
                    }
                }
		
                    
			
                    
		
			
		
		
		
		rs.close();
		preparedStatement.close();
		
		return s;
	}
    
   
    
    public void remove(int codigo) throws SQLException{
		//prepara o sql de delete
		String sql = "DELETE FROM produto WHERE codigo=?";
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
		
		//seta os valores
		preparedStatement.setLong(1,codigo);

		//executa
		preparedStatement.execute();
		System.out.println("");
		System.out.println("produto " + codigo + " deletado com Sucesso");
		preparedStatement.close();
	}
    
    public void altera(Produto produto, int codigo) throws SQLException{
		//UPDATE
		String sql = "UPDATE produto SET nome=?,tipo=?,fornecedor=?,quantidade=?,valor=?  WHERE codigo=?";
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
		
		//seta os valores
		preparedStatement.setString(1,produto.getNome());
		preparedStatement.setString(2,produto.getTipo());
		preparedStatement.setString(3,produto.getFornecedor());
		preparedStatement.setInt(4,produto.getQuantidade());
		preparedStatement.setFloat(5,produto.getValor());
                preparedStatement.setInt(6,codigo);

		//executa
		preparedStatement.execute();
		
		preparedStatement.close();
	}

    
}
