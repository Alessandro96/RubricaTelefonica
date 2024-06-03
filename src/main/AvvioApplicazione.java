package main;

import controllers.ControllerGUI;
import controllers.GestoreRubrica;
import controllers.GestoreUtenti;

import java.io.IOException;

public class AvvioApplicazione {

    public static void run(){
        //Inizializzazione controllers
        GestoreRubrica gr = GestoreRubrica.getInstance();
        GestoreUtenti gu = GestoreUtenti.getInstance();
        ControllerGUI cgui = ControllerGUI.getInstance();

        //Lettura da file
        try {
            //gr.popolaFile();
            gr.leggiDaFile();
            //gu.popolaFile();
            gu.leggiDaFile();
        }catch(IOException e){System.out.println(e.getMessage());}

        //Avvio interfaccia grafica
        cgui.avviaGUI(gr.getListaPersone().formatoTabella(gr.getColumns()), gr.getColumns());
    }
}
