package aithammou.badr.listview;

public class User{

    private String nom;
    private String prenom;
    private String pays;
    private String ville;
    private int nombre_de_post;

    public User(String nom, String pays, String ville, int nombre_de_post) {
        this.nom = nom;
        this.pays = pays;
        this.ville = ville;
        this.nombre_de_post = nombre_de_post;
    }

    public User(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getNombre_de_post() {
        return nombre_de_post;
    }

    public void setNombre_de_post(int nombre_de_post) {
        this.nombre_de_post = nombre_de_post;
    }
}
