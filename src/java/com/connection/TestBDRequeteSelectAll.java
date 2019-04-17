package com.connection;




import com.dao.ArticleDAO;
import com.model.Articles;
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


}
        }