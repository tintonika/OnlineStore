
<jsp:include page="head.jsp" />
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="navPanel.jsp" />
        <h3 style="text-align: center">Insert Article</h3></br></br>
        <div class="row">
            <div class="col-4">
                
            </div>
            <div class="col-8">
                <form action="insertArticle" type="POST">
                   <div class="form">
                       <div class="form-group mb-2 w-50">
                            <label for="title">Title&nbsp;&nbsp;&nbsp;</label>
                            <input type="text" class="form-control" id="title" name="name">
                        </div>
                   </div>
                    <div class="form-inline">
                        
                        <div class="form-group mb-2">
                            <label for="qty">Qty&nbsp;</label>
                            <input  class="form-control w-50" id="qty" name="qty" required pattern="^[0-9\.]+$"  >

                        </div>
                        <div class="form-group mb-2">
                            <label for="price">Price&nbsp;</label>
                            <input  class="form-control w-50" id="price" name="price" required pattern="^[0-9\.]+$" >

                        </div>
                    </div><br/>
                    <div class="form">
                        <div class="form-group mb-2">
                            <label for="selectCategory">Category</label>
                            <select class="form-control w-50" name="id_category" id="selectCategory">
                                    <option value="3">Bells</option>
                                    <option value="2">Candleholde</option>
                                    <option value="1">Mugs</option>
                                    <option value="4">PiggyBanks</option>
                            </select>
                        </div><br/>
                        
                        <div class="form-group-inline mb-2">
                            <label for="file">Choose Photo</label>
                            <input type="file" class="form-control-file" id="file" name="photo">
                        </div><br/>
                        <div class="form-check mb-2">
                            <input class="form-check-input" type="checkbox" name="active" value="1" id="Checkbox" checked>
                            <label class="form-check-label" for="Checkbox" >Active</label>
                         </div>
                    </div><br/>
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
                </form> 
                
            </div>
            
        </div>
        
    </body>
</html>