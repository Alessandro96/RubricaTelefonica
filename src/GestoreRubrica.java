import GUI.GUIController;
import Models.*;

public class GestoreRubrica {
    public static void run(){
        //Codice relativo alla logica di dominio
        ListaPersone listaPersone = testManuale();

        //Codice relativo all'interfaccia grafica
        String []columns = {"Nome", "Cognome", "Telefono"};
        GUIController.avviaGUI(listaPersone.formatoTabella(columns), columns);
    }

    private static ListaPersone testManuale(){
        Persona gianni = new Persona("Gianni", "Sperti", "Via della pace 9", "3334449876", 57);
        Persona gianniNuovo = new Persona("Gianni", "Sperti", "Via Cavour 74", "3334449876", 57);
        Persona jematria = new Persona("Jematria", "Joshua", "Lucky road 79", "1978005698", 12);
        Persona antonella = new Persona("Antonella", "Clerici", "[ESTERO]Santo Domingo", "3406799754", 60);
        Persona Mara = new Persona("Mara", "Povoleri", "[ESTERO]Santo Domingo", "3387954205", 73);

        ListaPersone listaPersone = new ListaPersone();
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

        return listaPersone;
    }
}
