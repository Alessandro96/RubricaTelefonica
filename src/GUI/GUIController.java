package GUI;

import javax.swing.*;

import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

public class GUIController {
    public static void avviaGUI(String[][] data, String[] columns) {

        FinestraPrincipale fp = new FinestraPrincipale(data, columns);
    }
}
