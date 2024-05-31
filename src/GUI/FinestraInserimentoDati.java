package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinestraInserimentoDati implements ActionListener{
    private JDialog finestra;
    //private JLabel lNome, lCognome, lIndirizzo, lTelefono, lEta;
    //private JTextField tNome, tCognome, tIndirizzo, tTelefono, tEta;

    public FinestraInserimentoDati(JFrame frame){
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

        creaTextField("nome", 1, 0, gbc, dataPanel);
        creaTextField("cognome", 1, 1, gbc, dataPanel);
        creaTextField("indirizzo",1, 2, gbc, dataPanel);
        creaTextField("telefono", 1, 3, gbc, dataPanel);
        creaTextField("eta", 1, 4, gbc, dataPanel);

        JButton salva = this.creaBottone("Salva", "Salva le modifiche", "icone/salva.png");
        buttonsPanel.add(salva);
        JButton annulla = this.creaBottone("Annulla", "Annulla le modifiche", "icone/annulla.png");
        buttonsPanel.add(annulla);

        this.finestra.add(buttonsPanel, BorderLayout.SOUTH);
        this.finestra.add(dataPanel, BorderLayout.CENTER);
        this.finestra.pack();
        this.finestra.setVisible(true);
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

    public void creaTextField(String text, int x, int y, GridBagConstraints gbc, JPanel panel){
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,30));
        textField.setFont(new Font("Consolas",Font.PLAIN,20));
        textField.setForeground(new Color(0x00FF00));
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.white);
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(textField, gbc);
    }

    public void creaLabel (String testo, int x, int y, GridBagConstraints gbc, JPanel panel){
        JLabel label = new JLabel(testo);
        label.setPreferredSize(new Dimension(100,30));
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(label, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Salva" ->{
                System.out.println("Hai salvato");
                this.finestra.dispose();
            }
            case "Annulla" -> {
                System.out.println("Non hai salvato");
                this.finestra.dispose();
            }
        }
    }
}
