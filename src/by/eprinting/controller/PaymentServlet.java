package by.eprinting.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.eprinting.beans.Order;
import by.eprinting.beans.Payment;
import by.eprinting.services.db.OrderDBService;
import by.eprinting.services.db.PaymentDBService;
import by.eprinting.utils.FileUtil;
import by.eprinting.utils.PaymentUtil;

/**
 * Servlet implementation class PaymentServlet
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String token = request.getParameter("stripeToken");
		String orderId = request.getParameter("orderId");
		String totalPrice = request.getParameter("totalPrice");
		
		Payment payment = PaymentUtil.createPayment(token, orderId, totalPrice);		
		
		if (payment == null) {
			Order order = OrderDBService.findOrderById(Long.valueOf(orderId));
			
			FileUtil.deleteFileFromLocalDisk(order.getDocument().getPath());
			OrderDBService.deleteOrder(order);			
			
			response.sendRedirect("systemError");
			return;
		}
		
		if (payment.isPaid()) {
			long paymentId = PaymentDBService.creatPayment(payment);
			payment.setId(paymentId);
			
			request.setAttribute("payment", payment);
			request.getRequestDispatcher("track").forward(request, response);
			
		} else {
			FileUtil.deleteFileFromLocalDisk(payment.getOrder().getDocument().getPath());
			PaymentDBService.deletePayment(payment);
			
			response.sendRedirect("unpaidResult");
		}
	}
}
