
package com.model;

import java.util.Objects;

public class Articles {
    private int ID;
    private String Name;
    private int ID_CATEGORY;
    private double PRICE;
    private int QTY;
    private int ACTIVE;
    private String PHOTO;
    private String NameCategory;


    public Articles() {
    }


    public Articles(int ID, String Nom, int ID_CATEGORY, double PRICE, int QTY, int ACTIVE, String Photo ){
        this.ID = ID;
        this.Name = Nom;
        this.ID_CATEGORY = ID_CATEGORY;
        this.PRICE = PRICE;
        this.QTY = QTY;
        this.ACTIVE=ACTIVE;
        this.PHOTO=Photo;
    }
    
        public Articles(String Nom, int ID_CATEGORY, double PRICE, int QTY, int ACTIVE, String Photo ){        
        this.Name = Nom;
        this.ID_CATEGORY = ID_CATEGORY;
        this.PRICE = PRICE;
        this.QTY = QTY;
        this.ACTIVE=ACTIVE;
        this.PHOTO=Photo;
    }
    
    public Articles(int ID, String Nom, String NameCategory, double PRICE, int QTY, String Photo, int Activ ){
        this.ID = ID;
        this.Name = Nom;
        this.NameCategory = NameCategory;
        this.PRICE = PRICE;
        this.QTY = QTY;        
        this.PHOTO=Photo;
        this.ACTIVE=Activ;
    }
       public Articles( String Nom, String NameCategory, double PRICE, int QTY, String Photo, int Activ ){
        this.ID = ID;
        this.Name = Nom;
        this.NameCategory = NameCategory;
        this.PRICE = PRICE;
        this.QTY = QTY;        
        this.PHOTO=Photo;
        this.ACTIVE=Activ;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Nom) {
        this.Name = Nom;
    }

    public int getID_CATEGORY() {
        return ID_CATEGORY;
    }

    public void setID_CATEGORY(int ID_CATEGORY) {
        this.ID_CATEGORY = ID_CATEGORY;
    }

    public double getPRICE() {
        return PRICE;
    }

    public void setPRICE(double PRICE) {
        this.PRICE = PRICE;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

  

    public int getACTIVE() {
        return ACTIVE;
    }

    public void setACTIVE(int ACTIVE) {
        this.ACTIVE = ACTIVE;
    }

    public String getPHOTO() {
        return PHOTO;
    }

    public void setPHOTO(String PHOTO) {
        this.PHOTO = PHOTO;
    }

   

    public String getNameCategory() {
        return NameCategory;
    }

    public void setNameCategory(String NameCategory) {
        this.NameCategory = NameCategory;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Articles other = (Articles) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Articles{" + "ID=" + ID + ", Name=" + Name + ", ID_CATEGORY=" + ID_CATEGORY + ", PRICE=" + PRICE + ", QTY=" + QTY + ", ACTIVE=" + ACTIVE + ", PHOTO=" + PHOTO + '}';
    }

  
    
    
    
}
