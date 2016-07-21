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
					    <li id="home-item" role="presentation"><a href="index.jsp">Home</a></li>
					    <li role="presentation"><a href="order.jsp">New Order</a></li>
					    <li role="presentation"><a href="track.jsp">Track Order</a></li>
					    <li role="presentation" class="active"><a href="#">Contact</a></li>
					</ul>
		        </nav>
		        <h3 class="text-muted">ePrinting!</h3>
		    </div>
		    
		    <div>
		    	<!-- http://embedgooglemaps.com/?page_id=2&lang=en -->
		    	<iframe frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="700" height="443" src="https://maps.google.com/maps?hl=en&q=Богдановича 55, Минск&ie=UTF8&t=roadmap&z=6&iwloc=B&output=embed"><div><small><a href="http://embedgooglemaps.com">embedgooglemaps.com</a></small></div><div><small><a href="http://premiumlinkgenerator.com/keep2share-cc">keep2share premium link generator</a></small></div></iframe>
		    </div>
		    
			<div class="row contacts">
				<h4>Our contacts:</h4>
				<p><b>Address:</b> Republic of Belarus, Minsk, 55 Bogdanovich str., 63 apt.</p>
				<p><b>Phone:</b> (<i>+375</i>) 44 511 9202</p>
				<p><b>Email:</b> ibrohimkhan@gmail.com</p>
			</div>
			
			<footer class="footer">
        		<div class="container"><p>&copy; ePrinting! Inc. 2015</p></div>
		    </footer>
		</div>
		
		<script src="assets/js/jquery-2.1.3.min.js"></script>	
		<script src="assets/js/bootstrap.min.js"></script>	
	</body>
	</body>
</html>