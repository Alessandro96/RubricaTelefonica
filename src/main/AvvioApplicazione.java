package main;

import controllers.*;

public class AvvioApplicazione {

    public static void run(){
        //Inizializzazione controllers
        ControllerDB.getInstance();
        GestoreRubrica gr = GestoreRubrica.getInstance();
        GestoreUtenti gu = GestoreUtenti.getInstance();
        ControllerGUI cgui = ControllerGUI.getInstance();

        //Lettura database
        gr.leggiDaFile();
        gu.leggiDaFile();

        //Avvio programma
        cgui.avviaGUI(gr.getListaPersone().formatoTabella(gr.getColumns()), gr.getColumns());
    }
}
