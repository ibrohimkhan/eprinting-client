package by.eprinting.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.eprinting.beans.Track;
import by.eprinting.services.db.TrackDBService;

/**
 * Servlet implementation class SearchTrackServlet
 */
public class SearchTrackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serial = request.getParameter("serial");
		Track track = TrackDBService.findBy(serial);
		
		if (track != null) {
			request.setAttribute("track", track);
			request.getRequestDispatcher("trackResult").forward(request, response);
		
		} else {
			response.sendRedirect("searchResult");
			return;
		}
	}

}
