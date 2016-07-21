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
		<jsp:useBean id="track" type="by.eprinting.beans.Track" scope="request"/>
	
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
			
			</br></br>
			<div class="panel panel-default">
				<div class="panel-heading">Status of your order:</div>
				
				<table class="table table-condensed">
					<tr>
						<th>Name</th>
						<td>${track.payment.order.fullName}</td>
					</tr>
					<tr>
						<th>Email</th>
						<td>${track.payment.order.email}</td>
					</tr>
					<tr>
						<th>Address</th>
						<td>${track.payment.order.address}</td>
					</tr>	
					<tr>
						<th>Document</th>
						<td>${track.payment.order.document.name}</td>
					</tr>
					<tr>
						<th>Pages</th>
						<td>${track.payment.order.document.totalPage}</td>
					</tr>
					<tr>
						<th>Amount in USD</th>
						<td>${track.payment.amount}</td>
					</tr>
					<tr class="danger">
						<th>Printing State</th>
						<td>${track.state}</td>
					</tr>
				</table>
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