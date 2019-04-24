<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.ArrayList" %>
<%@page import ="com.model.Articles" %>
<%@page import ="com.controller.Login" %>
<%@page import ="com.controller.AdminArticle" %>
  
<%  
   ArrayList<Articles> listArticle = (ArrayList)request.getAttribute(Login.CLE_DONNEE);
   
%>

 <jsp:include page="head.jsp" />
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="navPanel.jsp" />
        <div class="container">
            <div class="row">
              <div class="col-sm">
              </div>
              <div class="col-sm">
                 Administrator Panel 
              </div>
              <div class="col-sm">
                  <a href="/insertArticle.jsp" type="button" class="btn btn-primary btn-sm float-right" >
                    Add new article
                </a>
              </div>
            </div>
        </div>
        
        <div class="mainContainer">
            <div class="row">
                <div class="col-sm-2 ">
                    <div class="list-group" id="list-tab" role="tablist">
                        <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list" href="#list-home" role="tab" aria-controls="home">Home</a>
                        <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list" href="#list-profile" role="tab" aria-controls="profile">Profile</a>
                        <a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list" href="#list-messages" role="tab" aria-controls="messages">Messages</a>
                        <a class="list-group-item list-group-item-action" id="list-settings-list" data-toggle="list" href="#list-settings" role="tab" aria-controls="settings">Settings</a>
                    </div>
                </div>
                <div class="col-sm-8">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col"></th>
                                <th scope="col">Photo</th>
                                <th scope="col">Title</th>
                                <th scope="col">Category</th>
                                <th scope="col">Qty</th>
                                <th scope="col">Price</th>
                                <th scope="col">Active</th>
                                <th scope="col">* * *</th>
                            </tr>
                        </thead>
                        <tbody>
                         <%
                            if(listArticle!=null){
                            for (Articles article : listArticle) {
                          %>   
                            <tr>
                                <th scope="row"></th>
                                
                                <td>
                                    <img alt="no image" src="img/<%= article.getPHOTO()%>" height="70" width="60"/>
                                </td>
                                <td><%= article.getName()%></td>
                                <td><%= article.getNameCategory()%></td>
                                <td><%= article.getQTY()%></td>
                                <td><%= article.getPRICE()%></td>
                                 <%
                                 String active;
                                    if(article.getACTIVE()==1){
                                        active="Active";
                                    }else{
                                        active="No active";
                                    }
                                  %> 
                                <td><%= active%></td>
                                <td><a href="/updateArticle.jsp?Id_Art=<%= article.getID()%>"> <i class="far fa-edit">&nbsp;&nbsp;&nbsp;</i></a>
                                    <a href="deleteArticle?Id_Art=<%= article.getID()%>" > <i class="far fa-trash-alt"></i></a></td>   
                                <td><input type="hidden" name="Artid" value="<%=article.getID()%>"></td>
                                
                                
                            </tr>
                             <% }}
                              %>

                        </tbody>
                    </table>
                </div>
            </div>
       
        </div> <!--mainContainer-->
    </body>
</html>
