package gui;

import controllers.ControllerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {

    private JDialog finestraLogin;

    private JTextField username, password;

    public Login(){
        this.finestraLogin = new JDialog();
        this.finestraLogin.setTitle("Login");
        Image iconaFinestra = Toolkit.getDefaultToolkit().getImage("src/main/resources/icone/rubrica.png");
        this.finestraLogin.setIconImage(iconaFinestra);
        this.finestraLogin.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 5, 0, 5);

        JPanel dataPanel = new JPanel(new GridBagLayout());
        creaLabel("Username", 0, 0, gbc, dataPanel);
        creaLabel("Password", 0, 1, gbc, dataPanel);
        this.username = creaTextField(1, 0, gbc, dataPanel);
        this.password = creaTextField(1, 1, gbc, dataPanel);

        JPanel buttonPanel = new JPanel();
        creaBottone("Avanti", "Esegui il login", "src/main/resources/icone/login.png", buttonPanel);

        JPanel titlePanel = new JPanel();
        JLabel titolo = new JLabel("Accedi");
        titolo.setFont(new Font("Times New Roman", Font.BOLD, 24));
        titolo.setVerticalAlignment(JLabel.CENTER);
        titolo.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titolo);

        this.finestraLogin.add(dataPanel, BorderLayout.CENTER);
        this.finestraLogin.add(buttonPanel, BorderLayout.SOUTH);
        this.finestraLogin.add(titlePanel, BorderLayout.NORTH);
        this.finestraLogin.pack();
        this.finestraLogin.setVisible(true);
    }

    public void creaBottone(String testo, String toolTip, String path, JPanel panel) {
        JButton bottone = new JButton(testo);
        bottone.setFocusable(false);
        bottone.setToolTipText(toolTip);
        ImageIcon icona = new ImageIcon(path);
        bottone.setIcon(icona);
        bottone.setFont(new Font("Times New Roman", Font.BOLD, 20));
        bottone.setHorizontalTextPosition(SwingConstants.LEADING);
        panel.add(bottone);

        bottone.addActionListener(this);
    }

    public JTextField creaTextField(int x, int y, GridBagConstraints gbc, JPanel panel){
        JTextField tf = new JTextField();
        tf.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        tf.setPreferredSize(new Dimension(250,30));
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(tf, gbc);
        return tf;
    }

    public void creaLabel(String text, int x, int y, GridBagConstraints gbc, JPanel panel){
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(100,30));
        label.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setVerticalAlignment(JLabel.CENTER);
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(label, gbc);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ControllerGUI controller = ControllerGUI.getInstance();
        if(controller.eseguiLogin(this.username.getText(), this.password.getText())){
            this.finestraLogin.dispose();
            controller.avviaFinestraPrincipale();
        }
        else{
            JOptionPane.showMessageDialog(this.finestraLogin, "Username o Password errati", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}
