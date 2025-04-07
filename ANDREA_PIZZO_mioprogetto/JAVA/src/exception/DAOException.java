package exception;

public class DAOException extends Exception {


	public DAOException() {}
	
	public DAOException(String msg) {
		super(msg); //chiamo il costruttore della superclasse Exception e gli passo il messaggio
	}
}