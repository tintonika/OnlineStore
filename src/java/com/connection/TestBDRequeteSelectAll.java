package com.connection;




import com.dao.ArticleDAO;
import com.model.Articles;
import com.model.Categories;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TestBDRequeteSelectAll {


public static void main(String[] args) throws SQLException {
// TODO Auto-generated method stub
ArrayList<Articles> retour = ArticleDAO.ArticlesAll();
            for (Articles art : retour) {
                 System.out.println("ID : " + art.getID());
                 System.out.println("Name: " + art.getName());
                 System.out.println("Category : " + art.getNameCategory());
                 System.out.println("Photo : " + art.getPHOTO());
                 System.out.println("qty : " + art.getQTY());
                 System.out.println(" price : " + art.getPRICE());
                 System.out.println(" active : " + art.getACTIVE());
               
            }

            ArrayList<Categories> retour1 = ArticleDAO.CategoryAll();
            for (Categories art : retour1) {
                 System.out.println("ID : " + art.getID());
                 System.out.println("Name: " + art.getName());
               
            }

                
           ArrayList<Articles> retour2 = ArticleDAO.ArticleID(4);
     for (Articles art2 : retour2) {
                 System.out.println("ID : " + art2.getID());
                 System.out.println("Name: " + art2.getName());
                 System.out.println("Category : " + art2.getNameCategory());
                 System.out.println("Photo : " + art2.getPHOTO());
                 System.out.println("qty : " + art2.getQTY());
                 System.out.println(" price : " + art2.getPRICE());
                 System.out.println(" active : " + art2.getACTIVE());
               
            }
        }}