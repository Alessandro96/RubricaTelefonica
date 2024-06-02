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

    public Persona getPersona(int i){
        return this.rubrica.get(i);
    }

    public Vector<Persona> getRubrica(){ return this.rubrica; }

    public void setRubrica(Collection<Persona> rubrica){ this.rubrica.addAll(rubrica); }

    @Override
    public String toString(){
        String s = "";
        for(Persona p : this.getRubrica()) s += p.toString();
        return s;
    }

    public String[][] formatoTabella(String[] columns){
        String[][] datiTabella = new String[this.getRubrica().size()][columns.length];
        for(int i = 0; i<datiTabella.length; i++){
            for(int j = 0; j<columns.length; j++){
                switch(columns[j]){
                    case "Nome" -> datiTabella[i][j] = this.getRubrica().get(i).getNome();
                    case "Cognome" -> datiTabella[i][j] = this.getRubrica().get(i).getCognome();
                    case "Indirizzo" -> datiTabella[i][j] = this.getRubrica().get(i).getIndirizzo();
                    case "Telefono" -> datiTabella[i][j] = this.getRubrica().get(i).getTelefono();
                    case "Eta" -> datiTabella[i][j] = "" + this.getRubrica().get(i).getEta();
                }
            }
        }
        return datiTabella;
    }

}
