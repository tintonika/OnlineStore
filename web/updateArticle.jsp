
<%@page import="com.dao.ArticleDAO"%>
<%@page import="com.controller.AdminArticle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Articles"%>

<jsp:include page="head.jsp" />
<%  
   
 int idArt = Integer.parseInt(request.getParameter("Id_Art"));	
   
   ArrayList<Articles> listArticle = ArticleDAO.ArticleID(idArt);
   
 
 //ArrayList<Articles> listArticle = (ArrayList)request.getAttribute(AdminArticle.ARTICLE);
     
%>

<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="navPanel.jsp" />
        <h3  class="text-warning" style="text-align: center">Update Article</h3></br></br>
        <div class="row">
            <div class="col-4">
                
            </div>
            <div class="col-8">
                <form action="updateArticle" type="POST">
                   <div class="form">
                       <div class="form-group mb-2 w-50">
                            <%
                            if(listArticle!=null){
                            for (Articles article : listArticle) {
                          %>   
                            <label for="title">Title&nbsp;&nbsp;&nbsp;</label>
                            <input type="text" class="form-control" id="title" name="name" value="<%=(article!=null?article.getName():"")%>">
                        </div>
                   </div>
                    <div class="form-inline">
                        
                        <div class="form-group mb-2">
                            <label for="qty">Qty&nbsp;</label>
                            <input  class="form-control w-50" id="qty" name="qty" value="<%=(article!=null?article.getQTY():"")%>" required pattern="^[0-9\.]+$"  >

                        </div>
                        <div class="form-group mb-2">
                            <label for="price">Price&nbsp;</label>
                            <input  class="form-control w-50" id="price" name="price" value="<%=(article!=null?article.getPRICE():"")%>" required pattern="^[0-9\.]+$" >

                        </div>
                    </div><br/>
                    <div class="form">
                        <div class="form-group mb-2">
                            <label for="selectCategory">Category</label>
                            <select class="form-control w-50" name="id_category" selectitem="<%=(article!=null?article.getID_CATEGORY():"")%>" id="selectCategory" required>
                                    <option value="3">Bells</option>
                                    <option value="2">Candleholde</option>
                                    <option value="1">Mugs</option>
                                    <option value="4">PiggyBanks</option>
                            </select>
                        </div><br/>
                        
                             <div class="form-group mb-2">                             
                                    <img alt="no image" src="img/<%= article.getPHOTO()%>" height="70" width="60"/>
                                    </div>
                        <div class="form-group mb-2">
     
                                    <label for="file">Choose new photo</label>
                            <input type="file" class="form-control-file" id="file" name="photo">
                            
                        </div><br/>
                        <div class="form-check mb-2">
                              <%
                              String activ;
                            if(article.getACTIVE()==1){
                            activ="1";
                            }else {
                                activ="0";
                            }
                            
                            if (activ=="1"){
                          %>  
                            <input class="form-check-input" type="checkbox" name="active" value="<%= activ%>" id="Checkbox" checked>
                            <label class="form-check-label" for="Checkbox" >Active</label>
                             <%}else { %> 
                               <input class="form-check-input" type="checkbox" name="active" value="<%= activ%>" id="Checkbox" >
                            <label class="form-check-label" for="Checkbox" >Active</label>
                              <%}%>
                              <td><input type="hidden" name="Artid" value="<%=article.getID()%>"></td>
                              
                         </div>
                    </div><br/>
                     <% }}
                              %>
                      <table class="table table-borderless">
                        <thead>
                            <tr>
                                <td>
                    <button type="submit" class="btn btn-primary mb-2">Save</button>
                     </form> 
                </td>
                <td>
                  <form action="adminPanel.jsp" type="POST">               
                    <button type="submit" class="btn btn-info mb-2">Back</button>
                </form> 
                </table>
                </td>
              </tr>
            </div>
            
        </div>
        
    </body>
</html>