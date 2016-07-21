<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ePrinting!</title>
		<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/assets/css/jumbotron-narrow.css" rel="stylesheet">
	</head>
	
	<body>
		<div class="container">
			<div class="header clearfix">
		        <nav>
					<ul class="nav nav-pills pull-right menu-items">
					    <li id="home-item" role="presentation"><a href="index.jsp">Home</a></li>
					    
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
				<h2>Bad Result</h2>
				</br>
				<p class="lead">
					You have provided wrong serial number. Please, check it again carefully and try one more time.
				</p>
				</br>
				<p>
					<a class="btn btn-lg btn-danger" href="track.jsp" role="button">Track it</a>
				</p>
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