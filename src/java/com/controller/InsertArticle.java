
package com.controller;

import static com.controller.Login.CLE_DONNEE;
import com.dao.ArticleDAO;
import com.model.Articles;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertArticle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
                String name = request.getParameter("name");
		String Iprice = request.getParameter("price");
		String Iqty = request.getParameter("qty");
		String Iid_category = request.getParameter("id_category");
		String Iactiv = request.getParameter("active");
		String photo = request.getParameter("photo");
                
               
	double price = Double.parseDouble(Iprice);
        int qty = Integer.parseInt(Iqty);
        int id_category = Integer.parseInt(Iid_category);
        int activ = Integer.parseInt(Iactiv);
	
                
		Articles newart = new Articles(name,id_category,price, qty, activ, photo );			
		
                 ArticleDAO dao = new ArticleDAO();
                
                //dao.insertArticle(name, id_category, price, qty, activ, photo);
                dao.insertArticle2(newart);
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
            Logger.getLogger(InsertArticle.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InsertArticle.class.getName()).log(Level.SEVERE, null, ex);
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
