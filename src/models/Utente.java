package models;

public class Utente {

    private String username;
    private String password;

    public Utente(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Utente)) return false;
        Utente u = (Utente) obj;
        return (u.getUsername().equals(this.username) && u.getPassword().equals(this.password));
    }

    @Override
    public String toString(){
        return this.username+";"+this.password+"\n";
    }
}
