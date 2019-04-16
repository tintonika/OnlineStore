
package com.model;


public class Users {
    
    private int ID;
    private String Login;
    private String Password;
    private String Name;
    private String Adresse;
    private int Telephone;

    public Users(int ID, String Login, String Password, String Name, String Adresse, int Telephone) {
        this.ID = ID;
        this.Login = Login;
        this.Password = Password;
        this.Name = Name;
        this.Adresse = Adresse;
        this.Telephone = Telephone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public int getTelephone() {
        return Telephone;
    }

    public void setTelephone(int Telephone) {
        this.Telephone = Telephone;
    }

    @Override
    public String toString() {
        return "Users{" + "ID=" + ID + ", Login=" + Login + ", Password=" + Password + ", Name=" + Name + ", Adresse=" + Adresse + ", Telephone=" + Telephone + '}';
    }
    
    
}
