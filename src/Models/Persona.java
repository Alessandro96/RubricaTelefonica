package Models;
public class Persona {
    private String nome;
    private String cognome;
    private String indirizzo;
    private String telefono;
    private int eta;

    public Persona(String nome, String cognome, String indirizzo, String telefono, int eta){
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.telefono = telefono;
        this.eta = eta;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(!(obj instanceof Persona)) return false;
        Persona p = (Persona) obj;
        return p.getNome().equals(this.getNome()) && p.getCognome().equals(this.getCognome())
                && p.getIndirizzo().equals(this.getIndirizzo()) && p.getIndirizzo().equals(this.getTelefono()) && p.getEta() == this.getEta();
    }

    @Override
    public String toString(){
        return this.getNome() + ";" + this.getCognome() + ";" + this.getIndirizzo() + ";" + this.getTelefono() + ";" + this.getEta();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
