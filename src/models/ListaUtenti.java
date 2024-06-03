package models;

import java.util.Vector;

public class ListaUtenti {

    private Vector<Utente> listaUtenti;

    public ListaUtenti(){this.listaUtenti = new Vector<>();}

    public Utente getUtente(int i){ return this.listaUtenti.get(i); }

    public Vector<Utente> getListaUtenti() {
        return listaUtenti;
    }

    public void aggiungiUtente(String nome, String password){ this.listaUtenti.add(new Utente(nome, password)); }

}
