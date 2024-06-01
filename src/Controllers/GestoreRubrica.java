package Controllers;

import Models.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class GestoreRubrica {
    private ListaPersone listaPersone;
    private static GestoreRubrica instance = null;
    private final String path = "informazioni.txt";
    private final String []columns = {"Nome", "Cognome", "Telefono"};

    private GestoreRubrica(){}

    public static synchronized GestoreRubrica getInstance(){
        if(instance == null) instance = new GestoreRubrica();
        return instance;
    }

    public void run(){
        this.listaPersone = new ListaPersone();

        //Codice relativo alla persistenza
        try {
            //GestoreRubrica.getInstance().popolaFile();
            GestoreRubrica.getInstance().leggiDaFile();
        }catch(IOException e){System.out.println(e.getMessage());}
        System.out.println(this.listaPersone);

        //Codice relativo all'interfaccia grafica
        ControllerGUI.getInstance().avviaGUI(listaPersone.formatoTabella(columns), columns);
    }

    private void popolaFile(){
        Persona gianni = new Persona("Gianni", "Sperti", "Via della pace 9", "3334449876", 57);
        Persona gianniNuovo = new Persona("Gianni", "Sperti", "Via Cavour 74", "0000000000", 57);
        Persona jematria = new Persona("Jematria", "Joshua", "Lucky road 79", "1978005698", 12);
        Persona antonella = new Persona("Antonella", "Clerici", "[ESTERO]Santo Domingo", "3406799754", 60);
        Persona mara = new Persona("Mara", "Povoleri", "[ESTERO]Santo Domingo", "3387954205", 73);
        Persona vuota = new Persona("","","","",-1);
        Persona francesca = new Persona("Francesca", "Bonomelli", "Via Brombeis", "3785941098", 24);

        File file = new File(path);
        PrintStream print;
        try {
            print = new PrintStream(file);
            String s = gianni.toString()+gianniNuovo.toString()+jematria.toString()+antonella.toString()+mara.toString()+vuota.toString()+francesca.toString();
            print.append(s);
            print.close();
        }catch(IOException e){System.out.println(e.getMessage());}
    }

    private void leggiDaFile() throws IOException{
        File file = new File(this.path);
        int eta;
        String[] split;
        file.createNewFile();
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            split = scanner.nextLine().split(";");
            if(split.length == 5){
                try{
                    eta = Integer.parseInt(split[4]);
                    this.listaPersone.aggiungiPersona(new Persona(split[0], split[1], split[2], split[3], eta));
                }
                catch(NumberFormatException e){}
            }
        }
        scanner.close();
    }

    public void eliminaPersona(int i){
        this.listaPersone.eliminaPersona(this.listaPersone.getPersona(i));
        File file = new File(this.path);
        Scanner scanner;
        PrintStream print;
        String s = "";
        try{
            scanner = new Scanner(file);
            int j = 0;
            while(scanner.hasNextLine()){
                if(j!=i) s += scanner.nextLine()+"\n";
                else scanner.nextLine();
                j++;
            }
            print = new PrintStream(file);
            print.append(s);
            scanner.close();
            print.close();
        }catch(IOException e){System.out.println(e.getMessage()+"\nNon è stato possibile aggiungere la persona.");}
        ControllerGUI.getInstance().avviaGUI(this.listaPersone.formatoTabella(this.columns), this.columns);
    }

    public void aggiungiPersona(String nome, String cognome, String indirizzo, String telefono, int eta){
        Persona persona = new Persona(nome, cognome, indirizzo, telefono, eta);
        File file = new File(this.path);
        Scanner scanner;
        PrintStream print;
        String s = "";
        try{
            scanner = new Scanner(file);
            while(scanner.hasNextLine()) s += scanner.nextLine()+"\n";
            s += persona.toString();
            print = new PrintStream(file);
            print.append(s);
            scanner.close();
            print.close();
        }catch(IOException e){System.out.println(e.getMessage()+"\nNon è stato possibile aggiungere la persona.");}
        this.listaPersone.aggiungiPersona(persona);
        ControllerGUI.getInstance().avviaGUI(this.listaPersone.formatoTabella(this.columns), this.columns);
    }

    public void modificaPersona(String nome, String cognome, String indirizzo, String telefono, int eta, int i){
        Persona vecchia = this.listaPersone.getPersona(i);
        Persona nuova = new Persona(nome, cognome, indirizzo, telefono, eta);
        File file = new File(this.path);
        Scanner scanner;
        PrintStream print;
        String s = "";
        try{
            scanner = new Scanner(file);
            int j = 0;
            while(scanner.hasNextLine()){
                if(j==i){
                    s += nuova.toString();
                    scanner.nextLine();
                }
                else s += scanner.nextLine()+"\n";
                j++;
            }
            print = new PrintStream(file);
            print.append(s);
            scanner.close();
            print.close();
        }catch(IOException e){System.out.println(e.getMessage()+"\nNon è stato possibile aggiungere la persona.");}
        this.listaPersone.modificaPersona(vecchia, nuova);
        ControllerGUI.getInstance().avviaGUI(this.listaPersone.formatoTabella(this.columns), this.columns);
    }

    public String[] getStringArrayPersona(int i){
        if(i==-1) return new String[]{"","","","",""};
        Persona p = this.listaPersone.getPersona(i);
        return new String[]{p.getNome(), p.getCognome(), p.getIndirizzo(), p.getTelefono(), ""+p.getEta()};
    }
}
