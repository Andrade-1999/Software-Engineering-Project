package boundary;
import java.util.Scanner;
import control.GestioneCooperativa;
import exception.OperationException;
public class BoundaryGestore {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {		
		boolean exit = false;
		while(!exit) {
			System.out.println("1. Registra un nuovo cliente!");
			String op = scan.nextLine();
			if(op.equals("1")) 
				RegistrazioneCliente();
			else{
				System.out.println("Operazione non disponibile");
				}
		}	
		System.out.println("\nChiusura effettuata.");
	}

	public static void RegistrazioneCliente() {
		GestioneCooperativa gestioneCooperativa = GestioneCooperativa.getInstance();  //ritorno istanza singleton. (se non 
	//creata creo altrimenti richiamo)
		String tipo=null;
		String nome=null;
		String indirizzo=null;
		String email=null;
		String username=null;
		String password=null;
		boolean inputvalido = false;
		String Alfanumerico = "^[a-zA-Z0-9 ]+$";

		try {
			
			while(!inputvalido) {
				System.out.println("Inserire il tipo: ");
				tipo = scan.nextLine();
				if (tipo.equals("Ristorante") || tipo.equals("Pescheria")) {
					inputvalido=true;
				}
				else 
					System.out.println("Inserire un tipo che sia Ristorante o Pescheria\n");

			}
			
			inputvalido=false;
			while(!inputvalido) {
				System.out.println("Inserire il nome: ");
				nome = scan.nextLine();
				
				if(nome.length() < 30 &&  nome.matches(Alfanumerico)) {
					inputvalido = true;
				}
				else {
					System.out.println("Errore nell'inserimento del nome. Si prega di reinserirlo correttamente");
					System.out.println();
				}
			}
			
			inputvalido=false;
			while(!inputvalido) {
				System.out.println("Inserire l'indirizzo: ");
				indirizzo = scan.nextLine();
				if(indirizzo.matches("^" + Alfanumerico + ",\\d+," + Alfanumerico + "$")) {
					inputvalido = true;
				}
				else {
					System.out.println("Errore nell'inserimento dell'indirizzo. Si prega di reinserirlo correttamente");
					System.out.println();
				}
			}
			
			while(!inputvalido) {
				System.out.println("Inserire l'email: ");
				email = scan.nextLine();
				if (email.contains("@")) {
					inputvalido=true;
				} else {
				    System.out.println("ERRORE! La stringa email non contiene il carattere '@'");
					System.out.println();
				}
			}
			
			gestioneCooperativa.RegistrazioneCliente(tipo, email, nome, indirizzo);
			
			
			System.out.println("Registrazione avvenuta con successo!");
			System.out.println();
		}catch (OperationException oE) {
			System.out.println(oE.getMessage()); //stampa il messaggio di errroe di default di OperationException
			System.out.println("Riprovare..\n");
		} catch (Exception e) {
			System.out.println("Eccezione insapettata, riprovare..");
			System.out.println();
	    }
	}
}