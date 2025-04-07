package entity;

public class EntityFattorino {
	private String nome;
	private String username;
	private String password;
	
public EntityFattorino(String nome, String username, String password) {
	this.nome=nome;
	this.username=username;
	this.password=password;
}
public void setnome(String nome) {
	this.nome=nome;
}
public String getnome() {
	return nome;
}
public String getusername() {
	return username;
}
public String getpassword() {
	return password;
}
}
