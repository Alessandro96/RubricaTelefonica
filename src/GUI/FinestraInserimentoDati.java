package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controllers.GUIController;

public class FinestraInserimentoDati implements ActionListener{
    private JDialog finestra;

    private JFrame finestraPrincipale;
    private int selectedRow;
    private JTextField tNome, tCognome, tIndirizzo, tTelefono, tEta;

    public FinestraInserimentoDati(JFrame frame, int selectedRow){
        this.finestraPrincipale = frame;
        this.selectedRow = selectedRow;
        String[] personaSelezionata = GUIController.getInstance().getPersona(selectedRow);
        JPanel buttonsPanel = new JPanel();
        JPanel dataPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        this.finestra = new JDialog(frame, false);
        this.finestra.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);

        creaLabel("Nome", 0, 0, gbc, dataPanel);
        creaLabel("Cognome", 0, 1, gbc, dataPanel);
        creaLabel("Indirizzo", 0, 2, gbc, dataPanel);
        creaLabel("Telefono", 0, 3, gbc, dataPanel);
        creaLabel("Età", 0, 4, gbc, dataPanel);

        this.tNome = creaTextField(personaSelezionata[0], 1, 0, gbc, dataPanel);
        this.tCognome = creaTextField(personaSelezionata[1], 1, 1, gbc, dataPanel);
        this.tIndirizzo = creaTextField(personaSelezionata[2],1, 2, gbc, dataPanel);
        this.tTelefono = creaTextField(personaSelezionata[3], 1, 3, gbc, dataPanel);
        this.tEta = creaTextField(personaSelezionata[4], 1, 4, gbc, dataPanel);

        JButton salva = this.creaBottone("Salva", "Salva le modifiche", "icone/salva.png");
        buttonsPanel.add(salva);
        JButton annulla = this.creaBottone("Annulla", "Annulla le modifiche", "icone/annulla.png");
        buttonsPanel.add(annulla);

        JPanel titlePanel = new JPanel();
        JLabel titolo = new JLabel("Inserisci i dati della persona");
        titolo.setFont(new Font("Times New Roman", Font.BOLD, 24));
        titlePanel.add(titolo, BorderLayout.CENTER);

        this.finestra.add(buttonsPanel, BorderLayout.SOUTH);
        this.finestra.add(dataPanel, BorderLayout.CENTER);
        this.finestra.add(titolo, BorderLayout.NORTH);
        this.finestra.pack();
        this.finestra.setVisible(true);
    }

    public JButton creaBottone(String testo, String toolTip, String path) {
        JButton bottone = new JButton(testo);
        bottone.setFocusable(false);
        bottone.setToolTipText(toolTip);
        ImageIcon icona = new ImageIcon(path);
        bottone.setIcon(icona);
        bottone.setFont(new Font("Times New Roman", Font.BOLD, 20));

        bottone.addActionListener(this);

        return bottone;
    }

    public JTextField creaTextField(String text, int x, int y, GridBagConstraints gbc, JPanel panel){
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,30));
        textField.setFont(new Font("Times New Roman",Font.PLAIN,16));
        textField.setText(text);
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(textField, gbc);
        return textField;
    }

    public void creaLabel (String testo, int x, int y, GridBagConstraints gbc, JPanel panel){
        JLabel label = new JLabel(testo);
        label.setPreferredSize(new Dimension(100,30));
        label.setFont(new Font("Times New Roman",Font.PLAIN,16));
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(label, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Salva" ->{
                int eta;
                try{ eta = Integer.parseInt(tEta.getText());}
                catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(this.finestra, "Il campo età deve contenere un intero", "Avvertenza", JOptionPane.WARNING_MESSAGE);
                    break;
                }
                this.finestra.dispose();
                this.finestraPrincipale.dispose();
                if(this.selectedRow == -1) GUIController.getInstance().aggiungiPersona(this.tNome.getText(), this.tCognome.getText(), this.tIndirizzo.getText(), this.tTelefono.getText(), eta);
                else GUIController.getInstance().modificaPersona(this.tNome.getText(), this.tCognome.getText(), this.tIndirizzo.getText(), this.tTelefono.getText(), eta, this.selectedRow);
            }
            case "Annulla" -> this.finestra.dispose();
        }
    }
}
