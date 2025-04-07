package control;

import static org.junit.Assert.*;
import org.junit.Test;

import exception.OperationException;

public class GestioneCooperativaTest {
	
    private String nome;
    private String tipo;
    private String email;
    private String indirizzo;
    
	@Test
	public void TestCorretto() {

		GestioneCooperativa gC =  GestioneCooperativa.getInstance();
		tipo= "Ristorante";
		nome= "PizzaPazza";
		email="marino@live.it";
		indirizzo="via mille";
		try {
			gC.RegistrazioneCliente(tipo, email, nome, indirizzo);
			
		}catch(OperationException Oe) {
			fail("Eccezione generata durante la registrazione del cliente: "+ Oe.getMessage());
		}
		
	}
}