
package com.dao;

import com.connection.connectionDB;
import static com.dao.ArticleDAO.ArticleListActiv;
import com.model.Articles;
import com.model.Taxes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TaxeDao {
     PreparedStatement preparedStatement = null;
    Statement stmt = null;
    Connection con = null;
    ResultSet rs = null;
    
     public static ArrayList<Taxes> TaxesList;
     
       public ArrayList<Taxes> TaxesAll() throws SQLException {
        
        PreparedStatement preparedStatement = null;
        Connection con = null;
        TaxesList = new ArrayList<Taxes>();
      
        try {
            con = connectionDB.createConnection();
            String query = "select * from taxes ";
            preparedStatement = con.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("ID");
                String NAME = rs.getString("NOM");
                double VALUE = rs.getDouble("VALUE");

                TaxesList.add(new Taxes(
                        ID, 
                        NAME, 
                        VALUE));
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
        return TaxesList;
    }
}
