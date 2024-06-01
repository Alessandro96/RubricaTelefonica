package Controllers;

import GUI.FinestraPrincipale;

public class ControllerGUI {

    private static ControllerGUI instance = null;

    private ControllerGUI(){}

    public static synchronized ControllerGUI getInstance(){
        if(instance == null) instance = new ControllerGUI();
        return instance;
    }
    public void avviaGUI(String[][] data, String[] columns) {
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
}
