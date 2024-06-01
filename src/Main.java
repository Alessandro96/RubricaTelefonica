import Controllers.GestoreRubrica;

public class Main {
    public static void main(String[] args) {
        GestoreRubrica.getInstance().run();
        /*javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUIController.createAndShowGUI();
            }
        });*/
    }
}