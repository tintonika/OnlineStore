
package com.model;

import java.util.Date;


public class Orders {
    private int ID;
    private Date DATE;
    private int ID_USER;
    private int ID_ARTICLE;
    private int QTY;
    private int PRICE;

    public Orders(int ID, Date DATE, int ID_USER, int ID_ARTICLE, int QTY, int PRICE) {
        this.ID = ID;
        this.DATE = DATE;
        this.ID_USER = ID_USER;
        this.ID_ARTICLE = ID_ARTICLE;
        this.QTY = QTY;
        this.PRICE = PRICE;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDATE() {
        return DATE;
    }

    public void setDATE(Date DATE) {
        this.DATE = DATE;
    }

    public int getID_USER() {
        return ID_USER;
    }

    public void setID_USER(int ID_USER) {
        this.ID_USER = ID_USER;
    }

    public int getID_ARTICLE() {
        return ID_ARTICLE;
    }

    public void setID_ARTICLE(int ID_ARTICLE) {
        this.ID_ARTICLE = ID_ARTICLE;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public int getPRICE() {
        return PRICE;
    }

    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }

    @Override
    public String toString() {
        return "Orders{" + "ID=" + ID + ", DATE=" + DATE + ", ID_USER=" + ID_USER + ", ID_ARTICLE=" + ID_ARTICLE + ", QTY=" + QTY + ", PRICE=" + PRICE + '}';
    }
    
    
}
