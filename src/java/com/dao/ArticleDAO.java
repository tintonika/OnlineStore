
package com.dao;

import com.connection.connectionDB;
import com.model.Articles;
import com.model.Categories;
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
    public static ArrayList<Articles> ArticleListById;
    public static ArrayList<Categories> CategoryAll;
    
    ///select active articles for customers
    
     public static Articles ArticleById(int id) throws SQLException {        
        PreparedStatement preparedStatement = null;
        Connection con = null;
        Articles Articl =null;      

        try {
            con = connectionDB.createConnection();
            String query = "select * from articles "
                    + "     where id = '"+ id +"'";
            
            preparedStatement = con.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            
                Articl.setID(rs.getInt("ID"));
                Articl.setName(rs.getString("NAME"));
                Articl.setID_CATEGORY(rs.getInt("ID_CATEGORY"));
                Articl.setPRICE(rs.getInt("PRICE"));
                Articl.setACTIVE(rs.getInt("ACTIVE"));
                Articl.setQTY(rs.getInt("QTY"));
                Articl.setPHOTO(rs.getString("PHOTO"));
           
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
        return Articl;
    }
     
        
    
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
    
     
     
     public static ArrayList<Articles> ArticleID(int id) throws SQLException {
        
        PreparedStatement preparedStatement = null;
        Connection con = null;
        ArticleListById = new ArrayList<Articles>();
      

        try {
            con = connectionDB.createConnection();
           String query = "select * from articles "
                    + "     where id = '"+ id +"'";
            preparedStatement = con.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("ID");
                String NAME = rs.getString("NAME");
               int ID_CATEGORY = rs.getInt("ID_CATEGORY");
                double PRICE = rs.getDouble("PRICE");
                int QTY = rs.getInt("QTY");
                 int ACTIVE = rs.getInt("ACTIVE");
                String PHOTO= rs.getString("PHOTO");

                ArticleListById.add(new Articles(
                        ID, 
                        NAME, 
                        ID_CATEGORY,
                        PRICE,
                        QTY,
                        ACTIVE,
                        PHOTO));
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
        return ArticleListById;
    }
     
     
     
     
    
     ///select all articles for admins
    public static ArrayList<Articles> ArticlesAll() throws SQLException {        
        PreparedStatement preparedStatement = null;
        Connection con = null;
        ArticleListAll = new ArrayList<Articles>();      

        try {
            con = connectionDB.createConnection();
            String query = "select a.*, c.name nameCat"
                    + "     from articles a, categorys c"
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
                    + "     from articles a, categorys c"
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
                double PRICE = rs.getDouble("PRICE");
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
    
        public void insertArticle(String ArtName, int IdCategorie, double Price, int Qty, int Active, String Photo) throws SQLException{
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
        
         public void insertArticle2( Articles art) throws SQLException{
        try {
         con = connectionDB.createConnection();   
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        stmt = con.createStatement();
          
        
        String queryInsert = "INSERT INTO articles(NAME,ID_CATEGORY,PRICE,QTY,ACTIVE,PHOTO) "
                + "VALUES('"+ art.getName() +"','"+ art.getID_CATEGORY() +"','"+ art.getPRICE()+"','"+ art.getQTY()+"','"+ art.getACTIVE()+"','"+ art.getPHOTO()+"')";
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
        
         public void updateArticle( Articles art) throws SQLException{
        try {
         con = connectionDB.createConnection();   
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        stmt = con.createStatement();    
     
        
        String queryInsert = "update articles set "
                + "NAME        ='"+ art.getName()    +"',"
                + "ID_CATEGORY ='"+ art.getID_CATEGORY() +"',"
                + "PRICE       ='"+ art.getPRICE()       +"',"
                + "QTY         ='"+ art.getQTY()         +"',"
                + "ACTIVE      ='"+ art.getACTIVE()      +"',"
                + "PHOTO       ='"+ art.getPHOTO()       +"' "
                + "where id    ='"+ art.getID()       +"'";
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
     
        
        String queryInsert = "delete from articles  where id='"+IDArt+"'";
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
    
        public static ArrayList<Categories> CategoryAll() throws SQLException {        
        PreparedStatement preparedStatement = null;
        Connection con = null;
        CategoryAll = new ArrayList<Categories>();      

        try {
            con = connectionDB.createConnection();
            String query = "select *  from categorys ";
            preparedStatement = con.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("ID");
                String NAME = rs.getString("NAME");

                CategoryAll.add(new Categories(
                        ID, 
                        NAME));
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
        return CategoryAll;
    }
      
    
}