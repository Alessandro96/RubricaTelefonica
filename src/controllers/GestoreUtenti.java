package controllers;

import models.ListaUtenti;
import models.Utente;

public class GestoreUtenti {

    private ListaUtenti listaUtenti = new ListaUtenti();
    private static GestoreUtenti instance = null;
    private GestoreUtenti(){
    }

    public static GestoreUtenti getInstance(){
        if(instance==null) instance = new GestoreUtenti();
        return instance;
    }

    public void leggiDaFile(){
        String[][] arrayUtenti = ControllerDB.getInstance().getUtenti();
        for(String[] s : arrayUtenti) this.listaUtenti.aggiungiUtente(s[0], s[1]);
    }

    public boolean eseguiLogin(String username, String password){
        Utente login = new Utente(username, password);
        for(Utente u : this.listaUtenti.getListaUtenti()) if(u.equals(login)) return true;
        return false;
    }
}
