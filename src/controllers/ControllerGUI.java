package controllers;

import GUI.FinestraPrincipale;
import GUI.Login;

public class ControllerGUI {

    private static ControllerGUI instance = null;
    private String[][] data;

    private String[] columns;

    private ControllerGUI(){}

    public static synchronized ControllerGUI getInstance(){
        if(instance == null) instance = new ControllerGUI();
        return instance;
    }
    public void avviaGUI(String[][] data, String[] columns) {
        this.data = data;
        this.columns = columns;
        Login l = new Login();
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public void avviaFinestraPrincipale() {
        FinestraPrincipale fp = new FinestraPrincipale(data, columns);
    }

    public void eliminaPersona(int i){
        GestoreRubrica.getInstance().eliminaPersona(i);
    }

    public void aggiungiPersona(String nome, String cognome, String indirizzo, String telefono, int eta) {
        GestoreRubrica.getInstance().aggiungiPersona(nome, cognome, indirizzo, telefono, eta);
    }

    public void modificaPersona(String nome, String cognome, String indirizzo, String telefono, int eta, int i) {
        GestoreRubrica.getInstance().modificaPersona(nome, cognome, indirizzo, telefono, eta, i);
    }

    public String[] getPersona(int i){ return GestoreRubrica.getInstance().getStringArrayPersona(i); }

    public boolean eseguiLogin(String username, String password){
        return GestoreUtenti.getInstance().eseguiLogin(username, password);
    }
}
