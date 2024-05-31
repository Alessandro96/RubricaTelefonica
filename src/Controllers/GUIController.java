package Controllers;

import GUI.FinestraPrincipale;

public class GUIController {
    public static void avviaGUI(String[][] data, String[] columns) {
        FinestraPrincipale fp = new FinestraPrincipale(data, columns);
    }

    public static void eliminaPersona(int i){
        GestoreRubrica.eliminaPersona(i);
    }
}
