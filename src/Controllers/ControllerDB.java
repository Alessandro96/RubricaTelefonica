package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ControllerDB {

    private static ControllerDB instance = null;

    private ControllerDB(){ createConnection(); }

    public static ControllerDB getInstance(){
        if(instance == null) instance = new ControllerDB();
        return instance;
    }

    private void createConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rubricatelefonica", "root", "mysql");
            System.out.println("Connessione al database avvenuta con successo!");
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private String[][] getUtenti(){
        return new String[0][0];
    }

    private String[][] getPersone(){ return new String[0][0]; }

    private void eliminaPersona(){}

    private void aggiungiPersona(String[] persona){}

    private void modificaPersona(String[] vecchia, String[] nuova){}
}
