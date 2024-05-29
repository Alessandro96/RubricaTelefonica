package GUI;

import javax.swing.*;

import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

public class FinestraPrincipale {

    private JFrame finestra;
    private JTable tabella;
    private ModelloTabellaRubrica modello;

    public FinestraPrincipale(String[][] data, String[] columns){
        this.finestra = new JFrame();
        this.finestra.setTitle("Rubrica Telefonica");

        this.modello = new ModelloTabellaRubrica(data, columns);

        this.tabella = new JTable(this.modello);
        this.tabella.setSelectionMode(SINGLE_SELECTION);
        JScrollPane sp = new JScrollPane(tabella);

        finestra.add(sp);
        finestra.pack();
        finestra.setVisible(true);
    }
}
