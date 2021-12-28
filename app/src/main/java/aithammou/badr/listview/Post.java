package aithammou.badr.listview;

import android.os.Parcel;
import android.os.Parcelable;

public class Post  {

   private int id;
   private String titre;
   private String desc;
   private String duree;
   private String img;
   private double eva;

    public Post( String titre, String desc, String duree,  double eva) {
        this.titre = titre;
        this.desc = desc;
        this.duree = duree;
        this.eva = eva;
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

    public double getEva() {
        return eva;
    }

    public void setEva(double eva) {
        this.eva = eva;
    }
}
