import GUI.GUIController;
import Models.*;

public class GestoreRubrica {
    public static void testManuale(){
        Persona gianni = new Persona("Gianni", "Sperti", "Via della pace 9", "3334449876", 57);
        Persona gianniNuovo = new Persona("Gianni", "Sperti", "Via Cavour 74", "3334449876", 57);
        Persona jematria = new Persona("Jematria", "Joshua", "Lucky road 79", "1978005698", 12);
        Persona antonella = new Persona("Antonella", "Clerici", "[ESTERO]Santo Domingo", "3406799754", 60);
        Persona Mara = new Persona("Mara", "Povoleri", "[ESTERO]Santo Domingo", "3387954205", 73);

        ListaPersone rubrica = new ListaPersone();
        rubrica.aggiungiPersona(gianni);
        rubrica.aggiungiPersona(jematria);
        rubrica.aggiungiPersona(antonella);

        System.out.println(rubrica);

        rubrica.eliminaPersona(antonella);
        rubrica.aggiungiPersona(Mara);
        rubrica.modificaPersona(gianni, gianniNuovo);
        rubrica.modificaPersona(gianni, antonella);
        rubrica.modificaPersona(new Persona("", "", "", "", 0), antonella);
        rubrica.aggiungiPersona(gianniNuovo);

        System.out.println("*************************\nMODIFICHE AVVENUTE CORRETTAMENTE\n*************************");
        System.out.println(rubrica);

        System.out.println("*************************\nSTAMPO UNA RUBRICA VUOTA\n*************************");
        System.out.println(new ListaPersone());
        System.out.println("*************************\nRUBRICA VUOTA STAMPATA\n*************************");

        GUIController.avviaGUI(rubrica);
    }
}
