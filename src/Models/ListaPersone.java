package Models;

import java.util.Collection;
import java.util.Vector;

public class ListaPersone {

    private Vector<Persona> rubrica;

    public ListaPersone(){
        this.rubrica = new Vector<>();
    }

    public void aggiungiPersona(Persona p){
        this.rubrica.add(p);
    }

    public void eliminaPersona(Persona p){
        this.rubrica.remove(p);
    }

    public void modificaPersona(Persona vecchia, Persona nuova){
        int i = this.rubrica.indexOf(vecchia);
        if(i != -1) this.rubrica.set(i, nuova);
    }

    public Vector<Persona> getRubrica(){ return this.rubrica; }

    public void setRubrica(Collection<Persona> rubrica){ this.rubrica.addAll(rubrica); }

    @Override
    public String toString(){
        String s = "";
        for(Persona p : this.getRubrica()) s += p.toString() + "\n";
        if(!s.isEmpty()) s = s.substring(0, s.length()-1);
        return s;
    }

    public String[][] formatoTabella(String[] columns){
        String[][] tabella = new String[this.getRubrica().size()][columns.length];
        for(int i = 0; i<tabella.length; i++){
            for(int j = 0; j<columns.length; j++){
                switch(columns[j]){
                    case "Nome" -> tabella[i][j] = this.getRubrica().get(i).getNome();
                    case "Cognome" -> tabella[i][j] = this.getRubrica().get(i).getCognome();
                    case "Indirizzo" -> tabella[i][j] = this.getRubrica().get(i).getIndirizzo();
                    case "Telefono" -> tabella[i][j] = this.getRubrica().get(i).getTelefono();
                    case "Eta" -> tabella[i][j] = "" + this.getRubrica().get(i).getEta();
                }
            }
        }
        return tabella;
    }

}
