package by.eprinting.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.eprinting.beans.Payment;
import by.eprinting.beans.Track;
import by.eprinting.utils.EmailUtil;
import by.eprinting.utils.PropertiesUtil;
import by.eprinting.utils.TrackUtil;

/**
 * Servlet implementation class TrackServlet
 */
public class TrackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Payment pay = (Payment) request.getAttribute("payment");
		Track track = TrackUtil.creatTrack(pay);
		
		Properties properties = PropertiesUtil.getEmailProperties(getServletContext());
		EmailUtil.sendEmail(track, properties); // it makes slow UI that's why I should run it somehow in background
		
		request.setAttribute("track", track);
		request.getRequestDispatcher("trackResult").forward(request, response);
	}
}