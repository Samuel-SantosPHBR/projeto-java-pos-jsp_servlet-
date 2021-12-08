package Classe;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
	
	private Connection connection;
	
	public ClienteDAO(){
		this.connection = Conexao.getConexaoMySQL();//1 = Postgre, 2 = SQL Server, 3 = MySql
	}
	
	public void remove(int cliente) throws SQLException{
		//DELETE
		String sql = "DELETE FROM cliente WHERE id=?";
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
		
		//seta os valores
		preparedStatement.setInt(1,cliente);

		//executa
		preparedStatement.execute();
		System.out.println("");
		System.out.println("Cliente " + cliente + " deletado com Sucesso");
		preparedStatement.close();
	}
	
	public void altera(Cliente cliente, int codigo) throws SQLException{
		//UPDATE
		String sql = "UPDATE cliente SET nome=?,email=?,endereco=?,telefone=?,cpf=? WHERE id=?";
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
		
		//seta os valores
		preparedStatement.setString(1,cliente.getNome());
		preparedStatement.setString(2,cliente.getEmail());
		preparedStatement.setString(3,cliente.getEndereco());
		preparedStatement.setString(4,cliente.getTelefone());
		preparedStatement.setInt(5,cliente.getCodigo());
                preparedStatement.setInt(6,codigo);

		//executa
		preparedStatement.execute();
		System.out.println("");
		System.out.println("Cliente alterado com Sucesso");
		cliente.imprime();
		preparedStatement.close();
	}
	
	public void adiciona(Cliente cliente) throws SQLException{
		/*int codigo = 0;
		//pega o max ID
		String sql = "SELECT MAX(clicodigo) codigo FROM CLIENTES";
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);				
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()){
			codigo = rs.getInt("codigo");
		}
		rs.close();
		preparedStatement.close();
		
		//Max ID +1
		codigo = codigo +1;*/
		
		//INSERT
		String sql1 = "INSERT INTO `cliente`(`nome`, `email`, `endereco`, `telefone`, `cpf`) VALUES (?,?,?,?,?)";
            
            try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql1)) {
                //seta os valores
                //cliente.setCodigo(codigo);
                //preparedStatement.setLong(1,cliente.getCodigo());
                preparedStatement.setString(1,cliente.getNome());
                preparedStatement.setString(2,cliente.getEmail());
                preparedStatement.setString(3,cliente.getEndereco());
                preparedStatement.setString(4,cliente.getTelefone());
                preparedStatement.setInt(5,cliente.getCodigo());
                
                //executa
                preparedStatement.execute();
                System.out.println("");
                System.out.println("Cliente Inserido com Sucesso");
                cliente.imprime();
            }
	}
	
	public void listagem() throws SQLException{
		//SELECT
		String sql = "SELECT * FROM CLIENTE ORDER BY nome";
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);				
		//preparedStatement.setString(1,"10");
		//preparedStatement.setString(2,"20");
		//preparedStatement.setInt(1,0);
		//preparedStatement.setInt(2,20);
		ResultSet rs = preparedStatement.executeQuery();
		
		System.out.println("");				
		String s = "codigo - nome - telefone - email - endereco";
		System.out.println(s);
		while(rs.next()){
			s="";
			s += rs.getString("clicodigo") + " - " + rs.getString("clinome") + " - " + rs.getString("clitelefone") + " - " + rs.getString("cliemail") + " - " + rs.getString("cliendereco");
			System.out.println(s);
		}
		rs.close();
		preparedStatement.close();
	}
	
	public String listagemJSP() throws SQLException{		
		//SELECT
		String sql = "SELECT * FROM cliente ORDER BY nome";
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);				
		ResultSet rs = preparedStatement.executeQuery();
		
		String s = "<table class=\"table table-striped\" >";
		s += "<tr><th scope=\"col\">CPF</th> ";
		s += "<th scope=\"col\">Nome</th> ";
		s += "<th scope=\"col\">Telefone</th> ";
		s += "<th scope=\"col\">E-mail</th> ";
		s += "<th scope=\"col\">Endereço</th> ";
                s += "<th scope=\"col\">Ação</th> </tr>";
			
		while(rs.next()){
			s += "<tr>";
			s += "<td>" + rs.getString("cpf") + "</td>"; 
			s += "<td>" + rs.getString("nome") + "</td>"; 
			s += "<td>" + rs.getString("telefone") + "</td>";
			s += "<td>" + rs.getString("email") + "</td>";
			s += "<td>" + rs.getString("endereco")+ "</td>";
                        s += "<td><a href='Excluir1?id=" + rs.getInt("id")+ "' class=\"btn btn-secondary\">Excluir</a> <a href='Editar.jsp?id=" + rs.getInt("id")+ "' class=\"btn btn-primary\">Editar</a></td>";
			s += "</tr>";
		}
		s += "</table>";
		
		System.out.println(s);
		rs.close();
		preparedStatement.close();
		
		return s;
	}
        
        //necessita de uma string
        public String listagemJSP2(String a) throws SQLException{		
		//SELECT os clientes
                
                int codigo = parseInt(a);
                
		String sql = "SELECT * FROM cliente";
		PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
                
		ResultSet rs = preparedStatement.executeQuery();
		String s="";
                
                //execulta se o resultado for diferente do null
                if(rs != null) {
                    while(rs.next()) {
                        if(rs.getInt("id")==codigo){
                            
                            s="<div class=\"container-fluid ml-4\">\n" +
"            <form action=\"Editar\" method=\"POST\"> \n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"exampleFormControlInput1\">CPF:</label>\n" +
"                    <input type=\"text\" class=\"form-control col-md-4\" name=\"cpf\" id=\"cpf\" value="+rs.getInt("cpf")+">\n" +
"                    <input type=hidden class=\"form-control col-md-4\" name=\"id\" id=\"id\" value="+rs.getInt("id")+">\n" +
                                    "                </div>\n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"exampleFormControlInput1\">Nome:</label>\n" +
"                    <input type=\"text\" class=\"form-control col-md-4\" name=\"nome\" id=\"nome\" value="+rs.getString("nome")+">\n" +
"                </div>    \n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"exampleFormControlInput1\">Email:</label>\n" +
"                    <input type=\"text\" class=\"form-control col-md-4\" name=\"email\" id=\"email\" value="+rs.getString("email")+">\n" +
"                </div>    \n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"exampleFormControlInput1\">Telefone:</label>\n" +
"                    <input type=\"number\" class=\"form-control col-md-4\" name=\"telefone\" id=\"telefone\" value="+rs.getString("telefone")+">\n" +
"                </div>    \n" +
"                <div class=\"form-group\">\n" +
"                    <label for=\"exampleFormControlInput1\">Endereço:</label>\n" +
"                    <input type=\"number\" class=\"form-control col-md-4\"  name=\"endereco\" id=\"endereco\" value="+rs.getString("endereco")+">\n" +
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
	
	public String listagemFixa(){
		String s = "<table border= \"1\">";
		s += "<tr> <td>C�digo</td> ";
		s += "<td>Nome</td> ";
		s += "<td>Telefone</td> ";
		s += "<td>E-mail</td> ";
		s += "<td>Endere�o</td> </tr>";
			
		for(int i = 1; i <= 10; i++){
			s += "<tr>";
			s += "<td>" + i + "</td>"; 
			s += "<td>" + "Fulaninho" + i + "</td>"; 
			s += "<td>" + "8142391" + i + "</td>";
			s += "<td>" + "email@site" + i + ".com </td>";
			s += "<td>" + "rua " + i+ "Bairro velho, cidade tal </td>";
			s += "</tr>";
		}
		s += "</table>";
		return s;
	}
}