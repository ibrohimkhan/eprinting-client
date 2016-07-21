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
		    <%@ include file="assets/css/track-search.css" %>
		</style>
		
	</head>
	
	<body>
		<div class="container">
			
			<div class="header clearfix">
		        <nav>
					<ul class="nav nav-pills pull-right menu-items">
					    <li role="presentation"><a href="index.jsp">Home</a></li>
					    <li role="presentation"><a href="order.jsp">New Order</a></li>
					    <li role="presentation" class="active"><a href="#">Track Order</a></li>
					    <li role="presentation"><a href="contact.jsp">Contact</a></li>
					</ul>
		        </nav>
		        <h3 class="text-muted">ePrinting!</h3>
		    </div>
		    
			<form class="pos form-horizontal" method="post" action="findOrder">
				<div class="form-group">
					<div class="col-sm-10">
						<input type="text" class="form-control" name="serial" placeholder="Serial">
					</div>
					<button type="submit" class="btn btn-primary">Track order</button>
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