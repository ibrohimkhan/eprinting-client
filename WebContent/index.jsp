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
		    <%@ include file="assets/css/index.css" %>
		</style>
	</head>
	
	<body>
		<div class="container">
			<div class="header clearfix">
		        <nav>
					<ul class="nav nav-pills pull-right menu-items">
					    <li id="home-item" role="presentation" class="active"><a href="#">Home</a></li>
					    
					    <li class="dropdown">
	                        <a href="#" class="dropdown-toggle" role="button" data-toggle="dropdown">Services<span class="caret" /></a>
	                        <ul class="dropdown-menu">
	                            <li><a href="order.jsp">New Order</a></li>
	                            <li><a href="track.jsp">Track Order</a></li>
	                        </ul>
	                    </li>
					    
					    <li id="contacts-item" role="presentation"><a href="contact.jsp">Contact</a></li>
					</ul>
		        </nav>
		        <h3 class="text-muted">ePrinting!</h3>
		    </div>

			<div class="jumbotron">
				<h1>Print & Get!</h1>
				<p class="lead">
					Upload any digital resource (text, image, 3D Model) and get it printed just in few steps. It has never been so close in your door! 
				</p>
				<p>
					<a class="btn btn-lg btn-success" href="order.jsp" role="button">Let's print it!</a>
				</p>
			</div>
			
			<div class="row marketing">
				<div class="col-lg-6">
					<div class="features top">
						<h4>User friendly</h4>
						<p>ePrinting! provides easy to use web interface to make your digital resource physically available.</p>
					</div>
					
					<div class="features">
						<h4>High range of supported format</h4>
						<p>You can print documents with the following formats: MS Office, PDF, Kindle, EPUB, HTML. You can print any images and 3D Models</p>
					</div>
					
					<div class="features">
						<h4>Transparent proccess</h4>
						<p>Your order is possible to track through our tracking system. So it is transparent for you. You will be informed regarding the state of your order.</p>
					</div>
				</div>
				
				<div class="col-lg-6">
					<div class="features top">
						<h4>Geography</h4>
						<p>We are growing too fast. And soon our service will be available for you in all over the world!</p>
					</div>
					
					<div class="features">
						<h4>Delivery</h4>
						<p>It's possible to deliver your order by ordinary post or express post in all over the world. It is up to you where you want it!</p>
					</div>
					
					<div class="features">
						<h4>We are:</h4>
						<p>trying to change the world and make it a little bit easier for you, so take a part in our revolution and let's change the world together!</p>
					</div>
				</div>
			</div>
			
			<footer class="footer">
        		<div class="container"><p>&copy; ePrinting! Inc. 2015</p></div>
		    </footer>		
		</div>
		
		<script src="assets/js/jquery-2.1.3.min.js"></script>	
		<script src="assets/js/bootstrap.min.js"></script>	
		<script src="assets/js/eprinting.js"></script>	
	</body>
</html>