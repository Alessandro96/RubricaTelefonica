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

        this.finestra = new JDialog(frame, false);
        this.finestra.setLayout(new GridLayout(6,1));
        this.finestra.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);



        JButton salva = this.creaBottone("Salva", "Salva le modifiche", "icone/salva.png");
        buttonsPanel.add(salva);
        JButton annulla = this.creaBottone("Annulla", "Annulla le modifiche", "icone/annulla.png");
        buttonsPanel.add(annulla);

        this.finestra.add(buttonsPanel);
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

    public JTextField creaTextField(String text){
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(250,30));
        textField.setFont(new Font("Consolas",Font.PLAIN,20));
        textField.setForeground(new Color(0x00FF00));
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.white);
        return textField;
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
