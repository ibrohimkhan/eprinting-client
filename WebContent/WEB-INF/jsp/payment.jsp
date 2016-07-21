<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ePrinting!</title>
		<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/assets/css/jumbotron-narrow.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/assets/css/payment.css" rel="stylesheet">
	</head>
	
	<body>
		<jsp:useBean id="order" type="by.eprinting.beans.Order" scope="request" />
		<jsp:useBean id="bill" type="by.eprinting.beans.Bill" scope="request" />
		
		<div class="container">
			
			<div class="header-payment clearfix">
		        <nav>
					<ul class="nav nav-pills pull-right menu-items">
					    <li><h3><span class="label menu-item-color"><jsp:getProperty name="order" property="fullName" /></span></h3></li>
					    <li><h3><span class="label label-info">Order # <span class="badge"><jsp:getProperty name="order" property="id" /></span></span></h3></li>
					</ul>
		        </nav>
		        <h3><span class="label menu-item-color">ePayment!</span></h3>
		    </div>
		    
			<table class="table table-condensed">
				<tr class="active">
					<th>Email</th>
					<td><jsp:getProperty name="order" property="email" /></td>
				</tr>
				
				<tr class="active">
					<th>Phone</th>
					<td><jsp:getProperty name="order" property="phone" /></td>
				</tr>
				
				<tr class="active">
					<th>Address</th>
					<td><jsp:getProperty name="order" property="address" /></td>
				</tr>
					
				<tr class="active">	
					<th>Document</th>
					<td>${order.document.name}</td>
				</tr>
				
				<tr class="active">
					<th>Total page</th>
					<td>${order.document.totalPage}</td>
				</tr>
				
				<tr class="active">
					<th>Cost per page</th>	
					<td><jsp:getProperty name="bill" property="price" /> USD</td>
				</tr>
				
				<tr class="success">
					<th>Total amount</th>
					<td><jsp:getProperty name="bill" property="formatedTotalPrice" /> USD</td>
				</tr>
			</table>		
			
			<form class="row" action="cancelOrder" method="post">
				<div class="col-sm-6">
					<input type="hidden" name="orderId" value="${order.id}" />
				</div>
				
				<div class="col-sm-6">
					<button type="submit" id="cancelOrderBtn" class="btn btn-danger pull-right">Cancel Order</button>
				</div>
			</form>

			<p><h5><i>Enter your card information:</i></h5></p>
				
			<form class="row form-horizontal" action="payment" method="POST" id="payment-form">
				
				<input type="hidden" name="orderId" value="${order.id}" />
				<input type="hidden" name="totalPrice" value="${bill.totalPrice}" />
				
				<div class="col-lg-6">
					<span class="payment-errors"></span>
					
					<table class="table table-condensed">
						<tr class="info">
							<th>
								<span>Card Number</span>
							</th>
							<td>
								<div class="form-row">
									<input type="text" size="20" data-stripe="number"/>
								</div>
							</td>
						</tr>
						
						<tr class="info">
							<th>
								<span>CVC</span>								
							</th>
							<td>
								<div class="form-row">
							    	<input type="text" size="4" data-stripe="cvc"/>
								</div>
							</td>
						</tr>
						
						<tr class="info">
							<th>
						    	<span>Expiration (MM/YYYY)</span>
							</th>
							<td>
								<div class="form-row">
								    <input type="text" size="2" data-stripe="exp-month"/>
								    <span> / </span>
								    <input type="text" size="4" data-stripe="exp-year"/>
								</div>
							</td>
						</tr>
						
						<tr class="info">
							<th></th>
							<td>
								<button type="submit" class="btn btn-default">Submit Payment</button>
							</td>
						</tr>
					</table>				
				</div>
			</form>
			
			<footer class="footer">
        		<div class="container"><p>&copy; ePrinting! Inc. 2015</p></div>
		    </footer>
		</div>
		
		<script src="assets/js/jquery-2.1.3.min.js"></script>	
		<script src="assets/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
		<script type="text/javascript">
			Stripe.setPublishableKey('');
		</script>
		<script src="assets/js/eprinting.js"></script>
		
	</body>
</html>