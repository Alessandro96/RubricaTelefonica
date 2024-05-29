package GUI;

import Models.ListaPersone;

import javax.swing.*;

public class GUIController {
    public static void avviaGUI(ListaPersone l) {
        String []columns = {"Nome", "Cognome", "Telefono"};
        FinestraPrincipale fp = new FinestraPrincipale(l.formatoTabella(columns), columns);
    }
}
