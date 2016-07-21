package by.eprinting.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.eprinting.beans.Bill;
import by.eprinting.beans.Order;
import by.eprinting.services.BillingService;

/**
 * Servlet implementation class ChargeServlet
 */
public class ChargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Order order = (Order) request.getAttribute("order");
		Bill bill = BillingService.getTotalPrice(order.getDocument().getFormat(), order.getDocument().getTotalPage());
		
		request.setAttribute("bill", bill);		
		request.getRequestDispatcher("paymentView").forward(request, response);
	}

}
