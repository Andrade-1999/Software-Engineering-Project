package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entity.EntityCliente;
import exception.DAOException;
import exception.DBConnectionException;public class ClienteDAO {

    // Metodo per selezionare tutte le email dei clienti dal database
    public static String[] selezionaTutteEmailCliente() {
        // Array per memorizzare le email dei clienti
        String[] emailClienti = null;
        
        // Connessione al database
        Connection conn = null;
        // PreparedStatement per eseguire la query
        PreparedStatement stmt = null;
        // ResultSet per memorizzare i risultati della query
        ResultSet rs = null;

        try {
            //connessione al database utilizzando il metodo getConnection di DBManager
            conn = DBManager.getConnection();
            
            // Query SQL per selezionare tutte le email dei clienti
            String query = "SELECT email FROM cliente";
            
            // Prepara la query
            stmt = conn.prepareStatement(query);
            
            // Eseguo la query e ottiengo i risultati
            //Questa istruzione serve a permettere al cursore del
            //result set a spostarsi arbitrariamente
            stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query);
            
            // Ottieni il numero di righe nel ResultSet
            rs.last();
            int rowCount = rs.getRow();
            rs.beforeFirst(); //risetto il cursore a prima della prima riga
            // Inizializza l'array con la dimensione corretta
            emailClienti = new String[rowCount];
            
            // Scorrere i risultati e aggiungere le email all'array
            int i = 0;
            while (rs.next()) {//next restituisce true e va avanti se non è finito
                String emailCliente = rs.getString("email"); //recupero i valori della colonna email
                emailClienti[i] = emailCliente;
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gestione delle eccezioni
        } finally {
            // Chiudi le risorse (ResultSet, PreparedStatement, Connection)
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace(); //per stampare info dettagliate sull eccezione
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        // Restituisci l'array di email dei clienti
        return emailClienti;
    }
    public static void inserisciCliente(EntityCliente cliente) throws DAOException, DBConnectionException {
        // Definisci la query SQL per l'inserimento del cliente
        String query = "INSERT INTO cliente (tipo, nome, indirizzo, email, username, password) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (
            // Ottieni la connessione al database
            Connection conn = DBManager.getConnection();
            // Prepara lo statement SQL
            PreparedStatement statement = conn.prepareStatement(query);
        ) {
            // Imposta i parametri dello statement con i dati del cliente
            statement.setString(1, cliente.gettipo());
            statement.setString(2, cliente.getnome());
            statement.setString(3, cliente.getindirizzo());
            statement.setString(4, cliente.getemail());
            statement.setString(5, cliente.getusername());
            statement.setString(6, cliente.getpassword());
            
            // Esegui la query per inserire il cliente nel database
            statement.executeUpdate();
        } catch (SQLException e) {
            // Gestisci eventuali errori SQL
            throw new DAOException("Errore durante l'inserimento del cliente nel database");
        }
    }
}
