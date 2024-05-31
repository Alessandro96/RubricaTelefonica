package Controllers;

import Controllers.GUIController;
import Models.*;

public class GestoreRubrica {

    private static ListaPersone listaPersone;
    private static final String []columns = {"Nome", "Cognome", "Telefono"};
    public static void run(){
        //Codice relativo alla logica di dominio
        testManuale();

        //Codice relativo all'interfaccia grafica
        GUIController.avviaGUI(listaPersone.formatoTabella(columns), columns);
    }

    private static void testManuale(){
        Persona gianni = new Persona("Gianni", "Sperti", "Via della pace 9", "3334449876", 57);
        Persona gianniNuovo = new Persona("Gianni", "Sperti", "Via Cavour 74", "3334449876", 57);
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
        listaPersone.aggiungiPersona(gianniNuovo);

        System.out.println("*************************\nMODIFICHE AVVENUTE CORRETTAMENTE\n*************************");
        System.out.println(listaPersone);

        System.out.println("*************************\nSTAMPO UNA RUBRICA VUOTA\n*************************");
        System.out.println(new ListaPersone());
        System.out.println("*************************\nRUBRICA VUOTA STAMPATA\n*************************");
    }

    public static void eliminaPersona(int i){
        //listaPersone.eliminaPersona(listaPersone.getPersona(i));
        listaPersone.eliminaPersona(listaPersone.getPersona(i));
        GUIController.avviaGUI(listaPersone.formatoTabella(columns), columns);
    }
}