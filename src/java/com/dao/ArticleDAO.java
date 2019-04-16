
package com.dao;

import com.connection.connectionDB;
import com.model.Articles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class ArticleDAO {
    
    PreparedStatement preparedStatement = null;
    Statement stmt = null;
    Connection con = null;
    ResultSet rs = null;
    
    int ID_CATEGORY;
    public static ArrayList<Articles> ArticleListActiv;
    public static ArrayList<Articles> ArticleListAll;
    public static ArrayList<Articles> ArticleListByCategories;
    
    ///affichage d'articleList
    public ArrayList<Articles> showArticles() throws SQLException {

        PreparedStatement preparedStatement = null;
        Connection con = null;
        ArticleListAll = new ArrayList<Articles>();

        try {
             con = connectionDB.createConnection();
            String query = "select a.*, c.name nameCat"
                    + "     from articles a, category c"
                    + "     where a.id_category = c.id "
                    + "     ORDER BY a.active, a.name";
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            //preparedStatement.setInt(1, 1001);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("ID");
                String NAME = rs.getString("NAME");
                String CATEGORY_NAME = rs.getString("NAMECAT");
                int ACTIVE = rs.getInt("ACTIVE");
                int PRICE = rs.getInt("PRICE");
                int QTY = rs.getInt("QTY");
                String PHOTO= rs.getString("PHOTO");
                ArticleListAll.add(new Articles(
                        ID, 
                        NAME, 
                        CATEGORY_NAME,
                        PRICE,
                        QTY,
                        PHOTO,
                        ACTIVE));
            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (con != null) {
                con.close();
            }

        }
        return ArticleListAll;
    }
    ///select active articles for customers
    
     public ArrayList<Articles> ArticlesActiv() throws SQLException {
        
        PreparedStatement preparedStatement = null;
        Connection con = null;
        ArticleListActiv = new ArrayList<Articles>();
      

        try {
            con = connectionDB.createConnection();
            String query = "select a.*, c.name nameCat"
                    + "     from articles a, category c"
                    + "     where a.id_category = c.id "
                    + "     and active=1 "
                    + "     ORDER BY a.name";
            preparedStatement = con.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("ID");
                String NAME = rs.getString("NAME");
                String CATEGORY_NAME = rs.getString("NAMECAT");
                int PRICE = rs.getInt("PRICE");
                int QTY = rs.getInt("QTY");
                 int ACTIVE = rs.getInt("ACTIVE");
                String PHOTO= rs.getString("PHOTO");

                ArticleListActiv.add(new Articles(
                        ID, 
                        NAME, 
                        CATEGORY_NAME,
                        PRICE,
                        QTY,
                        PHOTO,
                        ACTIVE));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return ArticleListActiv;
    }
    
     ///select all articles for admins
    public ArrayList<Articles> ArticlesAll() throws SQLException {        
        PreparedStatement preparedStatement = null;
        Connection con = null;
        ArticleListAll = new ArrayList<Articles>();      

        try {
            con = connectionDB.createConnection();
            String query = "select a.*, c.name nameCat"
                    + "     from articles a, category c"
                    + "     where a.id_category = c.id "
                    + "     ORDER BY a.active, a.name";
            preparedStatement = con.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("ID");
                String NAME = rs.getString("NAME");
                String CATEGORY_NAME = rs.getString("NAMECAT");
                int ACTIVE = rs.getInt("ACTIVE");
                int PRICE = rs.getInt("PRICE");
                int QTY = rs.getInt("QTY");
                String PHOTO= rs.getString("PHOTO");

                ArticleListAll.add(new Articles(
                        ID, 
                        NAME, 
                        CATEGORY_NAME,
                        PRICE,
                        QTY,
                        PHOTO,
                        ACTIVE));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return ArticleListAll;
    }
    
    ///select articles by categories
     public ArrayList<Articles> ArticlesByCategories(int idcat) throws SQLException {
        
        PreparedStatement preparedStatement = null;
        Connection con = null;
        ArticleListByCategories = new ArrayList<Articles>();
      
        try {
            con = connectionDB.createConnection();
            String query = "select a.*, c.name nameCat"
                    + "     from articles a, category c"
                    + "     where a.id_category = c.id "
                    + "     and active=1 "
                    + "     and a.id_category= '"+ idcat +"'"
                    + "     ORDER BY a.name";
            preparedStatement = con.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("ID");
                String NAME = rs.getString("NAME");
                String CATEGORY_NAME = rs.getString("NAMECAT");
                int PRICE = rs.getInt("PRICE");
                int QTY = rs.getInt("QTY");
                 int ACTIVE = rs.getInt("ACTIVE");
                String PHOTO= rs.getString("PHOTO");

                ArticleListByCategories.add(new Articles(
                        ID, 
                        NAME, 
                        CATEGORY_NAME,
                        PRICE,
                        QTY,
                        PHOTO,
                        ACTIVE));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return ArticleListByCategories;
    }
    
    ///insert into Articles
    
        public void insertArticle(String ArtName, int IdCategorie, int Price, int Qty, int Active, String Photo) throws SQLException{
        try {
         con = connectionDB.createConnection();   
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        stmt = con.createStatement();
        
      //  String querySelectID = "SELECT ID from categorys WHERE name = '"+ NameCat +"'";
      //  preparedStatement = con.prepareStatement(querySelectID);        
      //  ResultSet rs = preparedStatement.executeQuery();        
        
      //  while (rs.next()) {
      //          ID_VOL = rs.getInt("ID");
      //  }
        
        String queryInsert = "INSERT INTO articles(NAME,ID_CATEGORY,PRICE,QTY,ACTIVE,PHOTO) "
                + "VALUES('"+ ArtName +"','"+ IdCategorie +"','"+ Price+"','"+ Qty+"','"+ Active+"','"+ Photo+"')";
        stmt.executeUpdate(queryInsert);
        }
        catch(SQLException e){
             System.out.println(e.getMessage());
        
        } finally {

            if (stmt != null) {
                stmt.close();
            }

            if (con != null) {
                con.close();
            }
        }
    }
        
         public void updateArticle( int IDArt, String ArtName, int IdCategorie, int Price, int Qty, int Active, String Photo) throws SQLException{
        try {
         con = connectionDB.createConnection();   
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        stmt = con.createStatement();    
     
        
        String queryInsert = "update articles set "
                + "NAME        ='"+ ArtName     +"',"
                + "ID_CATEGORY ='"+ IdCategorie +"',"
                + "PRICE       ='"+ Price       +"',"
                + "QTY         ='"+ Qty         +"',"
                + "ACTIVE      ='"+ Active      +"',"
                + "PHOTO       ='"+ Photo       +"' "
                + "where id    ='"+ IDArt       +"'";
        stmt.executeUpdate(queryInsert);
        }
        catch(SQLException e){
             System.out.println(e.getMessage());
        
        } finally {

            if (stmt != null) {
                stmt.close();
            }

            if (con != null) {
                con.close();
            }
        }
    }
         
         
    public void deleteArticle( int IDArt) throws SQLException{
        try {
         con = connectionDB.createConnection();   
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        stmt = con.createStatement();    
     
        
        String queryInsert = "update articles set ACTIVE = 0 where id='"+IDArt+"'";
        stmt.executeUpdate(queryInsert);
        }
        catch(SQLException e){
             System.out.println(e.getMessage());
        
        } finally {

            if (stmt != null) {
                stmt.close();
            }

            if (con != null) {
                con.close();
            }
        }
    }
}
