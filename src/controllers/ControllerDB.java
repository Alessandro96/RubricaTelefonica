package controllers;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Vector;

public class ControllerDB {

    private static ControllerDB instance = null;

    private Connection con;

    private ControllerDB(){ createConnection(); }

    public static ControllerDB getInstance(){
        if(instance == null) instance = new ControllerDB();
        return instance;
    }

    private void createConnection(){
        Properties properties = new Properties();

        try(FileReader fileReader = new FileReader("src/main/resources/properties/credenziali_database.properties")){
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String username = properties.getProperty("username"), password = properties.getProperty("password");
        String server = properties.getProperty("ip-server-mysql"), porta = properties.getProperty("porta");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://"+server+":"+porta+"/rubricatelefonica", username, password);
            System.out.println("Connessione al database avvenuta con successo!");
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String[][] getUtenti(){
        try {
            Vector<String[]> utenti = new Vector<>();
            String[] utente;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM utente;");
            while(rs.next()){
                utente = new String[]{rs.getString("username"), rs.getString("password")};
                utenti.add(utente);
            }
            String[][] arrayUtenti = new String[utenti.size()][2];
            for(int i=0; i<utenti.size(); i++) arrayUtenti[i] = utenti.get(i);
            return arrayUtenti;
        }catch (SQLException e) { System.out.println(e.getMessage()); }
        return new String[0][0];
    }

    public String[][] getPersone(){
        try{
            Vector<String[]> persone = new Vector<>();
            String[] persona;
            String[][] arrayPersone;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM persona;");
            while(rs.next()){
                persona = new String[]{rs.getString("nome"), rs.getString("cognome"),
                        rs.getString("indirizzo"), rs.getString("telefono"),
                        ""+rs.getInt("eta")};
                persone.add(persona);
            }
            arrayPersone = new String[persone.size()][5];
            for(int i=0; i<persone.size(); i++) arrayPersone[i] = persone.get(i);
            return arrayPersone;
        }catch (SQLException e) { System.out.println(e.getMessage()); }
        return new String[0][0];
    }

    public void eliminaPersona(int persona, int max){
        try{
            Statement stm = con.createStatement();
            stm.execute("DELETE FROM persona WHERE persona_id = " + (persona+1) + ";");
            if((persona+1)<max) {
                for (int i = (persona + 2); i <= max; i++) {
                    stm.execute("UPDATE persona SET persona_id = " + (i - 1) + " WHERE persona_id = " + i + ";");
                }
            }

        }catch(SQLException e){ System.out.println(e.getMessage()); }

    }

    public void aggiungiPersona(String[] persona, int i){
        try{
            Statement stm = con.createStatement();
            String nome = persona[0], cognome = persona[1], indirizzo = persona[2], telefono = persona[3];
            int eta = Integer.parseInt(persona[4]);
            stm.execute("INSERT INTO persona VALUES("+ i +", '"+nome
                    +"', '"+cognome+"', '"+indirizzo+"', '"+telefono+"', "+eta+");");
        }catch(SQLException e){ System.out.println(e.getMessage()); }
    }

    public void modificaPersona(int vecchia, String[] nuova){
        try{
            Statement stm = con.createStatement();
            String nome = nuova[0], cognome = nuova[1], indirizzo = nuova[2], telefono = nuova[3];
            int eta = Integer.parseInt(nuova[4]);
            stm.execute("REPLACE INTO persona VALUES("+(vecchia+1)+", '"+nome
                    +"', '"+cognome+"', '"+indirizzo+"', '"+telefono+"', "+eta+");");
        }catch(SQLException e){ System.out.println(e.getMessage()); }

    }
}
