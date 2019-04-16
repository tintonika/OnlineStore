<%-- 
    Document   : login
    Created on : 15 avr. 2019, 14:58:27
    Author     : Tatiyana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <jsp:include page="head.jsp" />
<!DOCTYPE html>
<html>
    <jsp:include page="navPanel.jsp" />
    <body>
        <div class="row">
            <div class="col-sm-3">
           
            </div>
         <div class="col-sm-4 alert-danger ">
             Vous n’êtes pas un utilisateur valide!
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3">
               
            </div>
            <div class="col-sm-4">
                <form action="login" type="post">
                    <div class="form-group">
                        <label for="nom">Email address</label>
                        <input type="email" class="form-control" id="nom" name="nom" aria-describedby="emailHelp" placeholder="Enter email">
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    </div>
                    <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input" id="check">
                        <label class="form-check-label" for="check">Check me out</label>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </body>
</html>
