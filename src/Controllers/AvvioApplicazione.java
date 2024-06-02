package Controllers;

import java.io.IOException;

public class AvvioApplicazione {

    public static void run(){
        GestoreRubrica gr = GestoreRubrica.getInstance();
        GestoreUtenti gu = GestoreUtenti.getInstance();
        ControllerGUI cgui = ControllerGUI.getInstance();

        //Codice relativo alla persistenza
        try {
            //gr.popolaFile();
            gr.leggiDaFile();
            //gu.popolaFile();
            gu.leggiDaFile();
        }catch(IOException e){System.out.println(e.getMessage());}

        //Codice relativo all'interfaccia grafica
        cgui.avviaGUI(gr.getListaPersone().formatoTabella(gr.getColumns()), gr.getColumns());
    }
}
