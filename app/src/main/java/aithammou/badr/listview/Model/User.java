package aithammou.badr.listview.Model;

public class User{

    private String nom;
    private String img_user;
    private String chattext;
    // private String interet;
    // id
    // boolean interet


    public User(String nom,  String chattext) {
        this.nom = nom;

        this.chattext = chattext;
    }

    public String getImg_user() {
        return img_user;
    }

    public void setImg_user(String img_user) {
        this.img_user = img_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getChattext() {
        return chattext;
    }

    public void setChattext(String chattext) {
        this.chattext = chattext;
    }
}

