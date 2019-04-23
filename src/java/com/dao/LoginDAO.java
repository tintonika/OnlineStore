/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.connection.connectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rick
 */
public class LoginDAO {
   public boolean verification(String nom, String pass) throws SQLException {
        boolean result = false;
        String psw = null;
        PreparedStatement preparedStatement = null;
        Connection con = null;
        
//        if(nom == null || pass==null){
//            return false;
//        }
        try {
        con = connectionDB.createConnection();
        String query = "SELECT Password from admins WHERE Login = '"+ nom +"'";
        preparedStatement = con.prepareStatement(query); 

        ResultSet rs = preparedStatement.executeQuery();
         
        while (rs.next()) {
               psw = rs.getString("PASSWORD");
        }
        if(psw!=null){
            if (psw.equals(pass))
                   result = true;
        }
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
        finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
        }         
}
