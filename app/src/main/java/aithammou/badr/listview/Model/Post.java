package aithammou.badr.listview.Model;


public class Post  {

   private int id;
   private String titre;
   private String desc;
   private String duree;
   private String img;


    public Post( String titre, String desc, String duree,String img) {
        this.titre = titre;
        this.desc = desc;
        this.duree = duree;
        this.img = img;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}
