package control;

import entity.EntityCliente;
import java.util.Random;
import database.ClienteDAO;
import exception.OperationException;
import exception.DAOException;
import exception.DBConnectionException;

public class GestioneCooperativa {
	private static GestioneCooperativa gC = null;

	protected GestioneCooperativa() { //costruttore della classe singleton impostato su protected per impedire costruzioni esterne
	}
	public static GestioneCooperativa getInstance() 
	{ 
		if (gC == null) 
			gC = new GestioneCooperativa(); 

		return gC; 
	}
	// Metodo per registrare i duplicati di email
    public boolean registratiduplicati(String email) {
        //l'array di email dei clienti dal ClienteDAO
        String[] emailClienti = ClienteDAO.selezionaTutteEmailCliente();
        
        //l'array di email dei clienti utilizzando un classico ciclo for
        for (int i = 0; i < emailClienti.length; i++) {
            if (emailClienti[i].equals(email)) {
                // Se c'è una corrispondenza, restituisci true (duplicato trovato)
                return true;
            }
        }
        return false;
    }
    public void RegistrazioneCliente(String tipo, String email, String nome, String indirizzo)throws OperationException {
        try {
            // Verifica se l'email è già presente nel database
            boolean duplicato = registratiduplicati(email);
            // Se l'email non è presente nel database, procedi con la registrazione
            if (!duplicato) {
                // Genera username e password casuali
                String username = randomUsername();
                String password = randomPassword();

                // Crea un'istanza di Cliente con i dati forniti
                EntityCliente nuovoCliente = new EntityCliente(tipo, nome, indirizzo, email, username, password);

                // Memorizza il nuovo cliente nel database
                ClienteDAO.inserisciCliente(nuovoCliente);
            }
            else 
            	throw new OperationException("email gia presente nel DB");
        }catch(DBConnectionException dbEx) {
			throw new OperationException("Errore interno");
		}catch(DAOException e) {
			throw new OperationException("Errore durante la registrazione");
			//anche se catturo una DAOException, la cattura un metodo a livello piu alto di astrazione,
			//che pertanto lancia una operationexception.
		}
    }
    private String randomUsername() {
        // Implementazione della generazione casuale di username
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();//permette di costruire una stringa mutabile, a differenza
        //di string che è immutabile.
        Random random = new Random(); //oggetto random per contenere un numero random
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(chars.length());//restituisce indece random da 0 alla lunghezza
            //di chars
            sb.append(chars.charAt(index)); //seleziono il carattere con indice index dalla stringa chars
            //e gli faccio una append ad sb
        }
        return sb.toString(); //converto in stringa sb e lo ritorno 
    }
    
    // Metodo per generare una password casuale
    private String randomPassword() {
        // Implementazione della generazione casuale di password
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(); //permette di costruire una stringa mutabile, a differenza
        //di string che è immutabile.
        Random random = new Random(); 
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

}