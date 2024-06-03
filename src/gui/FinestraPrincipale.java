package gui;

import controllers.ControllerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

public class FinestraPrincipale implements ActionListener {

    private JFrame finestra;
    private JTable tabella;

    public FinestraPrincipale(String[][] data, String[] columns){
        this.inizializzaFinestra(data, columns);
        this.finestra.setVisible(true);
    }

    private void inizializzaFinestra(String[][] data, String[] columns){
        this.finestra = new JFrame("Rubrica Telefonica");
        this.finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image iconaFinestra = Toolkit.getDefaultToolkit().getImage("src/main/resources/icone/rubrica.png");
        this.finestra.setIconImage(iconaFinestra);
        this.finestra.setLayout(new BorderLayout());

        ModelloTabellaRubrica modello = new ModelloTabellaRubrica(data, columns);
        this.tabella = new JTable(modello);
        this.tabella.setSelectionMode(SINGLE_SELECTION);

        JScrollPane scrollPanel = new JScrollPane(this.tabella);
        this.finestra.add(scrollPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        this.finestra.add(buttonsPanel, BorderLayout.SOUTH);
        JButton nuovo = creaBottone("Nuovo", "Aggiungi un contatto", "src/main/resources/icone/nuovo.png");
        buttonsPanel.add(nuovo);
        JButton modifica = creaBottone("Modifica", "Modifica un contatto", "src/main/resources/icone/modifica.png");
        buttonsPanel.add(modifica);
        JButton elimina = creaBottone("Elimina", "Elimina un contatto", "src/main/resources/icone/elimina.png");
        buttonsPanel.add(elimina);

        this.finestra.pack();
    }

    private JButton creaBottone(String testo, String toolTip, String path) {
        JButton bottone = new JButton(testo);
        bottone.setFocusable(false);
        bottone.setToolTipText(toolTip);
        ImageIcon icona = new ImageIcon(path);
        bottone.setIcon(icona);
        bottone.setFont(new Font("Times New Roman", Font.BOLD, 20));

        bottone.addActionListener(this);

        return bottone;
    }

    private void rigaNonSelezionata(){
        JOptionPane.showMessageDialog(finestra, "Devi selezionare una riga della tabella", "Errore", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Nuovo" -> {
                EditorPersona inserimentoDati = new EditorPersona(this.finestra, -1);
            }
            case "Modifica" -> {
                if(this.tabella.getSelectedRow()==-1) rigaNonSelezionata();
                else {
                    EditorPersona inserimentoDati = new EditorPersona(this.finestra, this.tabella.getSelectedRow());}
            }
            case "Elimina" -> {
                String[] responses = {"Sì","No"};
                if(this.tabella.getSelectedRow()==-1) rigaNonSelezionata();
                else {
                    int answer = JOptionPane.showOptionDialog(
                            this.finestra,
                            "Eliminare la persona " + this.tabella.getValueAt(this.tabella.getSelectedRow(), 0) + " " + this.tabella.getValueAt(this.tabella.getSelectedRow(), 1) + "?",
                            "Elimina persona",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            responses,
                            null);
                    if (answer == 0){
                        this.finestra.dispose();
                        ControllerGUI.getInstance().eliminaPersona(this.tabella.getSelectedRow());
                    }
                }
            }
        }
    }
}
