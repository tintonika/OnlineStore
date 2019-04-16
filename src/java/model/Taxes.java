
package com.model;

public class Taxes {
   private int ID;
   private String Nom;
   private double Value;

    public Taxes(int ID, String Nom, double Value) {
        this.ID = ID;
        this.Nom = Nom;
        this.Value = Value;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public double getValue() {
        return Value;
    }

    public void setValue(double Value) {
        this.Value = Value;
    }

    @Override
    public String toString() {
        return "Taxes{" + "ID=" + ID + ", Nom=" + Nom + ", Value=" + Value + '}';
    }
   
   
}
