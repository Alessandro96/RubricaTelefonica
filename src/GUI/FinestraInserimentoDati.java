package GUI;

import javax.swing.*;

public class FinestraInserimentoDati {
    private JFrame finestra;
    private JLabel lNome, lCognome, lIndirizzo, lTelefono, lEta;
    private JTextField tNome, tCognome, tIndirizzo, tTelefono, tEta;
    private JButton salva, annulla;

    public FinestraInserimentoDati(){
        JPanel panel = new JPanel();

        this.finestra = new JFrame();
        this.finestra.add(panel);
        this.salva = new JButton("Salva");
        panel.add(salva);
        this.annulla = new JButton("Annulla");
        panel.add(annulla);

        this.finestra.pack();
        this.finestra.setVisible(true);
    }

}
