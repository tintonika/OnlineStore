
<jsp:include page="head.jsp" />
<!DOCTYPE html>
<html>
    <body>
        <jsp:include page="navPanel.jsp" />
        <h3 style="text-align: center">Insert Article</h3></br></br>
        <div class="row">
            <div class="col-2">
                
            </div>
            <div class="col-10">
               <form>
                    <div class="form-inline">
                        <div class="form-group mb-2 w-80">
                            <label for="title">Title&nbsp;</label>
                            <input type="text" class="form-control" id="title" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </div>
                        <div class="form-group mb-2">
                            <label for="qty">Qty&nbsp;</label>
                            <input type="email" class="form-control w-50" id="qty"  >

                        </div>
                        <div class="form-group mb-2">
                            <label for="price">Price&nbsp;</label>
                            <input type="email" class="form-control w-50" id="price" >&nbsp;&nbsp;

                        </div>
                    </div>
                    <div class="form">
                        <div class="form-group col-4">
                            <label for="selectCategory">Category</label>
                            <select class="form-control" name="category" id="selectCategory">
                                    <option value="3">Bells</option>
                                    <option value="2">Candleholde</option>
                                    <option value="1">Mugs</option>
                                    <option value="4">PiggyBanks</option>
                            </select>
                        </div>
                        
                        <div class="form-group col-4">
                            <label for="file">Choose Photo</label>
                            <input type="file" class="form-control-file" id="file">
                        </div>
                        <div class="form-check ">
                            <input class="form-check-input" type="checkbox" id="Checkbox" value="check">
                            <label class="form-check-label" for="Checkbox">Active</label>
                         </div>
                    </div>
                    <button type="submit" class="btn btn-primary mb-2">Confirm</button>
                </form> 
            </div>
            
        </div>
        
    </body>
</html>