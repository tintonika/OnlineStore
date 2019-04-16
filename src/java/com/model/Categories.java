
package com.model;


public class Categories {
    private int ID;
    private String Name;

    public Categories(int ID, String Nom) {
        this.ID = ID;
        this.Name = Nom;
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

    @Override
    public String toString() {
        return "Categories{" + "ID=" + ID + ", Nom=" + Name + '}';
    }
    
    
}
