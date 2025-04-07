package entity;
import exception.DBConnectionException;
import exception.DAOException;
import database.ClienteDAO;

public class EntityCliente {
	private String tipo;
	private String nome;
	private String indirizzo;
	private String email;
	private String username;
	private String password;
	
public EntityCliente(String tipo, String nome, String indirizzo, String email, String username, String password) {
	super();
	this.tipo=tipo;
	this.nome=nome;
	this.indirizzo=indirizzo;
	this.email=email;
	this.username=username;
	this.password=password;
}
public void memorizzaCliente() throws DAOException, DBConnectionException {
	ClienteDAO.inserisciCliente(this); //memorizziamo il cliente nel DB passandogli l'istanza dell
	//oggetto corrente
}
public String gettipo() {
	return tipo;
}
public void settipo(String tipo) {
	this.tipo=tipo;
}
public String getnome() {
	return nome;
}
public void setnome(String nome) {
	this.nome=nome;
}
public String getindirizzo() {
	return indirizzo;
}
public void setindirizzo(String indirizzo) {
	this.indirizzo=indirizzo;
}
public String getemail() {
	return email;
}
public void setemail(String email) {
	this.email=email;
}
public String getusername() {
	return username;
}
public String getpassword() {
	return password;
}
}
