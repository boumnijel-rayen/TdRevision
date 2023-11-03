package Classes;

public class Client {
    private int code;
    private String nom;
    private String prenom;
    public Client(int code, String nom, String prenom) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int hashCode() {
        return code;
    }

    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj==null) return false;
        if(obj.getClass()!=this.getClass())
            return false;
        Client C=(Client) obj;
        if(C.code==code)
            return true;
        return false;
    }

    public String toString() {
        return "Code : "+code+" Nom : "+nom+" Prenom : "+prenom;
    }
}
