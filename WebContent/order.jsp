<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ePrinting!</title>
		
		<style type="text/css">
		    <%@ include file="assets/css/bootstrap.min.css" %>
		    <%@ include file="assets/css/jumbotron-narrow.css" %>
		</style>
	</head>
	
	<body>
		<div class="container">
		
			<div class="header clearfix">
		        <nav>
					<ul class="nav nav-pills pull-right menu-items">
					    <li role="presentation"><a href="index.jsp">Home</a></li>
					    <li role="presentation" class="active"><a href="#">New Order</a></li>
					    <li role="presentation"><a href="track.jsp">Track Order</a></li>
					    <li role="presentation"><a href="contact.jsp">Contact</a></li>
					</ul>
		        </nav>
		        <h3 class="text-muted">ePrinting!</h3>
		    </div>
		    
			<form class="form-horizontal" method="post" encType="multipart/form-data" action="order">
				
				<div class="form-group">
	                <label for="fullname" class="col-sm-3 control-label">Full name</label>
	                <div class="col-sm-8">
                        <input type="text" name="fullname" id="fullname" value="" class="form-control" />
	                </div>
	            </div>
            
            	<div class="form-group">
    				<label for="email" class="col-sm-3 control-label">Email</label>
    				<div class="col-sm-8">
      					<input type="email" class="form-control" id="email" name="email" value="" />
    				</div>
  				</div>
  				
  				<div class="form-group">
    				<label for="phone" class="col-sm-3 control-label">Phone</label>
    				<div class="col-sm-8">
      					<input type="tel" class="form-control" id="phone" name="phone" value="" />
    				</div>
  				</div>
            
            	<div class="form-group">
            		<label for="address" class="col-sm-3 control-label">Address</label>
    				<div class="col-sm-8">
    					<textarea id="address" class="form-control" rows="3" name="address" value=""></textarea>
    				</div>
            	</div>
            	</br>
            	
            	<div class="form-group">
    				<label for="inputFile" class="col-sm-3 control-label">File input</label>
    				<div class="col-sm-8">
    					<input type="file" id="inputFile" name="inputFile">
    					<p class="help-block">Supported formats: MS Office, PDF, Images</p>
    				</div>
  				</div>
            
            	</br>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-8">
                		<button type="submit" class="btn btn-default col-md-4">Order</button>
                	</div>
            	</div>
            	
			</form>
			
			<footer class="footer">
        		<div class="container"><p>&copy; ePrinting! Inc. 2015</p></div>
		    </footer>
		</div>	
		
		<script src="assets/js/jquery-2.1.3.min.js"></script>	
		<script src="assets/js/bootstrap.min.js"></script>	
	</body>
</html>