package controllers;

import models.ListaPersone;
import models.Persona;

public class GestoreRubrica {
    private ListaPersone listaPersone = new ListaPersone();
    private static GestoreRubrica instance = null;
    private final String []columns = {"Nome", "Cognome", "Telefono"};

    private GestoreRubrica(){}

    public static synchronized GestoreRubrica getInstance(){
        if(instance == null) instance = new GestoreRubrica();
        return instance;
    }

    public String[] getColumns(){ return this.columns; }

    public ListaPersone getListaPersone(){ return this.listaPersone; }

    public void leggiDaFile(){
        String[][] arrayPersone = ControllerDB.getInstance().getPersone();
        for(String[] s : arrayPersone) this.listaPersone.aggiungiPersona(new Persona(s[0],s[1],s[2],s[3], Integer.parseInt(s[4])));
    }

    public void eliminaPersona(int i){
        ControllerDB.getInstance().eliminaPersona(i, this.listaPersone.getRubrica().size());
        this.listaPersone.eliminaPersona(this.listaPersone.getPersona(i));
        ControllerGUI controller = ControllerGUI.getInstance();
        controller.setData(this.listaPersone.formatoTabella(this.columns));
        controller.setColumns(this.columns);
        controller.avviaFinestraPrincipale();
    }

    public void aggiungiPersona(String nome, String cognome, String indirizzo, String telefono, int eta){
        this.listaPersone.aggiungiPersona(new Persona(nome, cognome, indirizzo, telefono, eta));
        ControllerDB.getInstance().aggiungiPersona(new String[]{nome, cognome, indirizzo, telefono, ""+eta}, this.listaPersone.getRubrica().size());
        ControllerGUI controller = ControllerGUI.getInstance();
        controller.setData(this.listaPersone.formatoTabella(this.columns));
        controller.setColumns(this.columns);
        controller.avviaFinestraPrincipale();
    }

    public void modificaPersona(String nome, String cognome, String indirizzo, String telefono, int eta, int i){
        Persona vecchia = this.listaPersone.getPersona(i);
        Persona nuova = new Persona(nome, cognome, indirizzo, telefono, eta);
        this.listaPersone.modificaPersona(vecchia, nuova);
        ControllerDB.getInstance().modificaPersona(i, new String[]{nome, cognome, indirizzo, telefono, ""+eta});
        ControllerGUI controller = ControllerGUI.getInstance();
        controller.setData(this.listaPersone.formatoTabella(this.columns));
        controller.setColumns(this.columns);
        controller.avviaFinestraPrincipale();
    }

    public String[] getStringArrayPersona(int i){
        if(i==-1) return new String[]{"","","","",""};
        Persona p = this.listaPersone.getPersona(i);
        return new String[]{p.getNome(), p.getCognome(), p.getIndirizzo(), p.getTelefono(), ""+p.getEta()};
    }
}
