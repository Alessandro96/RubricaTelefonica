package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

public class FinestraPrincipale {

    private JFrame finestra;
    private JTable tabella;
    private ModelloTabellaRubrica modello;

    public FinestraPrincipale(String[][] data, String[] columns){
        this.inizializzaFinestra(data, columns);
        this.mostraFinestra();
    }

    private void inizializzaFinestra(String[][] data, String[] columns){
        this.finestra = new JFrame("Rubrica Telefonica");
        this.finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.finestra.setLayout(new BorderLayout());

        this.modello = new ModelloTabellaRubrica(data, columns);
        this.tabella = new JTable(this.modello);
        //this.tabella = creaTabella(data, columns, selection);
        this.tabella.setSelectionMode(SINGLE_SELECTION);

        JScrollPane scrollPanel = new JScrollPane(this.tabella);
        this.finestra.add(scrollPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        this.finestra.add(buttonsPanel, BorderLayout.SOUTH);
        JButton nuovo = creaBottone("Nuovo", "Aggiungi un contatto", "icone/nuovo.png");
        buttonsPanel.add(nuovo);
        JButton modifica = creaBottone("Modifica", "Modifica un contatto", "icone/modifica.png");
        buttonsPanel.add(modifica);
        JButton elimina = creaBottone("Elimina", "Elimina un contatto", "icone/elimina.png");
        buttonsPanel.add(elimina);

        this.finestra.pack();
    }

    private JTable creaTabella(String[][] data, String[] columns, int selection){
        this.modello = new ModelloTabellaRubrica(data, columns);
        return new JTable(this.modello);
    }

    private JButton creaBottone(String testo, String toolTip, String path) {
        JButton bottone = new JButton(testo);
        bottone.setFocusable(false);
        bottone.setToolTipText(toolTip);
        ImageIcon icona = new ImageIcon(path);
        bottone.setIcon(icona);
        bottone.setFont(new Font("Times New Roman", Font.BOLD, 20));

        bottone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                switch (e.getActionCommand()) {
                    case "Nuovo" -> {
                        FinestraInserimentoDati inserimentoDati = new FinestraInserimentoDati();
                    }
                    case "Modifica" -> {
                        FinestraInserimentoDati inserimentoDati = new FinestraInserimentoDati();
                    }
                    case "Elimina" -> {
                        String[] responses = {"No","Sì"};
                        int answer = JOptionPane.showOptionDialog(
                                null,
                                "Eliminare la persona " + tabella.getValueAt(tabella.getSelectedRow(), 0) + " " + tabella.getValueAt(tabella.getSelectedRow(), 1) + "?",
                                "Elimina persona",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.ERROR_MESSAGE,
                                null,
                                responses,
                                null);
                        System.out.println(answer);
                    }
                }
                for(int i = 0; i< tabella.getColumnCount(); i++) System.out.println(tabella.getValueAt(tabella.getSelectedRow(), i));
            }
        });

        return bottone;
    }

    private void mostraFinestra(){
        this.finestra.setVisible(true);
    }
}
