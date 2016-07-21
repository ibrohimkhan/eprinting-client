package by.eprinting.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.eprinting.beans.Order;
import by.eprinting.services.db.OrderDBService;
import by.eprinting.utils.FileUtil;

/**
 * Servlet implementation class CancelOrderServlet
 */
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		Order order = OrderDBService.findOrderById(Long.valueOf(orderId));	
		
		FileUtil.deleteFileFromLocalDisk(order.getDocument().getPath());
		OrderDBService.deleteOrder(order);
		
		response.sendRedirect("index.jsp");
	}

}
