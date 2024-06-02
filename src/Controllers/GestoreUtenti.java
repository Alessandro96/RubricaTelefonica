package Controllers;

import Models.ListaUtenti;
import Models.Utente;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class GestoreUtenti {

    private ListaUtenti listaUtenti = new ListaUtenti();
    private final String path = "utenti.txt";
    private static GestoreUtenti instance = null;
    private GestoreUtenti(){
    }

    public static GestoreUtenti getInstance(){
        if(instance==null) instance = new GestoreUtenti();
        return instance;
    }

    public void leggiDaFile() throws IOException{
        File file = new File(path);
        file.createNewFile();
        Scanner scanner = new Scanner(file);
        String[] s;
        while(scanner.hasNextLine()){
            s = scanner.nextLine().split(";");
            if(s.length == 2) this.listaUtenti.aggiungiUtente(s[0], s[1]);
        }
        scanner.close();
    }

    public void popolaFile(){
        Utente u1 = new Utente("utente", "password");
        Utente u2 = new Utente("utente2", "password2");
        Utente u3 = new Utente("utente3", "password3");

        File file = new File(path);
        PrintStream print;
        try {
            print = new PrintStream(file);
            String s = u1.toString()+u2.toString()+ u3.toString();
            print.append(s);
            print.close();
        }catch(IOException e){System.out.println(e.getMessage());}
    }

    public boolean eseguiLogin(String username, String password){
        Utente login = new Utente(username, password);
        for(Utente u : this.listaUtenti.getListaUtenti()) if(u.equals(login)) return true;
        return false;
    }
}
