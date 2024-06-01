package Controllers;

import Controllers.GUIController;
import Models.*;

public class GestoreRubrica {

    private ListaPersone listaPersone;

    private static GestoreRubrica instance = null;
    private final String []columns = {"Nome", "Cognome", "Telefono"};

    private GestoreRubrica(){}

    public static synchronized GestoreRubrica getInstance(){
        if(instance == null) instance = new GestoreRubrica();
        return instance;
    }
    public void run(){
        //Codice relativo alla logica di dominio
        GestoreRubrica.getInstance().testManuale();
        //this.listaPersone = new ListaPersone();

        //Codice relativo all'interfaccia grafica
        GUIController.getInstance().avviaGUI(listaPersone.formatoTabella(columns), columns);
    }

    private void testManuale(){
        Persona gianni = new Persona("Gianni", "Sperti", "Via della pace 9", "3334449876", 57);
        Persona gianniNuovo = new Persona("Gianni", "Sperti", "Via Cavour 74", "0000000000", 57);
        Persona jematria = new Persona("Jematria", "Joshua", "Lucky road 79", "1978005698", 12);
        Persona antonella = new Persona("Antonella", "Clerici", "[ESTERO]Santo Domingo", "3406799754", 60);
        Persona Mara = new Persona("Mara", "Povoleri", "[ESTERO]Santo Domingo", "3387954205", 73);

        listaPersone = new ListaPersone();
        listaPersone.aggiungiPersona(gianni);
        listaPersone.aggiungiPersona(antonella);
        listaPersone.aggiungiPersona(jematria);

        System.out.println(listaPersone);

        listaPersone.eliminaPersona(antonella);
        listaPersone.aggiungiPersona(Mara);
        listaPersone.modificaPersona(gianni, gianniNuovo);
        listaPersone.modificaPersona(gianni, antonella);
        listaPersone.modificaPersona(new Persona("", "", "", "", 0), antonella);
        listaPersone.eliminaPersona(antonella);
        listaPersone.aggiungiPersona(gianni);

        System.out.println("*************************\nMODIFICHE AVVENUTE CORRETTAMENTE\n*************************");
        System.out.println(listaPersone);

        System.out.println("*************************\nSTAMPO UNA RUBRICA VUOTA\n*************************");
        System.out.println(new ListaPersone());
        System.out.println("*************************\nRUBRICA VUOTA STAMPATA\n*************************");
    }

    public void eliminaPersona(int i){
        this.listaPersone.eliminaPersona(this.listaPersone.getPersona(i));
        GUIController.getInstance().avviaGUI(this.listaPersone.formatoTabella(this.columns), this.columns);
    }

    public void aggiungiPersona(String nome, String cognome, String indirizzo, String telefono, int eta){
        Persona persona = new Persona(nome, cognome, indirizzo, telefono, eta);
        this.listaPersone.aggiungiPersona(persona);
        GUIController.getInstance().avviaGUI(this.listaPersone.formatoTabella(this.columns), this.columns);
    }

    public void modificaPersona(String nome, String cognome, String indirizzo, String telefono, int eta, int i){
        Persona vecchia = this.listaPersone.getPersona(i);
        Persona nuova = new Persona(nome, cognome, indirizzo, telefono, eta);
        this.listaPersone.modificaPersona(vecchia, nuova);
        GUIController.getInstance().avviaGUI(this.listaPersone.formatoTabella(this.columns), this.columns);
    }

    public String[] getPersona(int i){
        if(i==-1) return new String[]{"","","","",""};
        Persona p = this.listaPersone.getPersona(i);
        return new String[]{p.getNome(), p.getCognome(), p.getIndirizzo(), p.getTelefono(), ""+p.getEta()};
    }
}
