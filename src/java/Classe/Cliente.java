package Classe;

public class Cliente {
	private int codigo;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	
	public Cliente(){
		this.codigo = 0;
		this.nome = "";
		this.telefone = "";
		this.email = "";
		this.endereco = "";
	}
        
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int i) {
		this.codigo = i;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void imprime(){
		String contato = "[C�digo] = " + this.codigo + " [NOME] = " + this.nome+ " [TELEFONE] = " + this.telefone + " [EMAIL] = " + this.email + " [ENDERECO] = " + this.endereco;
		System.out.println(contato);
		
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTelefone() {
		return telefone;
	}
}
