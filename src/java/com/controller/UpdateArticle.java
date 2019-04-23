
package com.controller;

import static com.controller.Login.CLE_DONNEE;
import com.dao.ArticleDAO;
import com.model.Articles;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UpdateArticle", urlPatterns = {"/updateArticle"})
public class UpdateArticle extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
         ArticleDAO dao = new ArticleDAO(); 
      int idArt = Integer.parseInt(request.getParameter("Artid"));	
      
		ArrayList<Articles> listArticle = ArticleDAO.ArticleID(idArt);
        
                String name = request.getParameter("name");
		double price =  Double.parseDouble(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int id_category = Integer.parseInt(request.getParameter("id_category"));
		String Iactiv = request.getParameter("active");
		String photo = request.getParameter("photo");
                
                if(photo==""){
                     for (Articles article : listArticle) {
                photo=article.getPHOTO();
                }}
                
                
                /////
                int activ;
               
            if (Iactiv==null){
             activ=0;
            } else { 
             activ = Integer.parseInt(Iactiv);}
    
        
                 
		Articles newart = new Articles(idArt,name,id_category,price, qty, activ, photo );			
		
               
                dao.updateArticle(newart);
                
                 if (ArticleDAO.ArticlesAll()!=null) {
                request.setAttribute(CLE_DONNEE, ArticleDAO.ArticlesAll());   
                }
		request.getRequestDispatcher("adminPanel.jsp").forward(request, response);
        }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateArticle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
