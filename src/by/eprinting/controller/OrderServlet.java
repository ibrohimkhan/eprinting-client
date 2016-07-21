package by.eprinting.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import by.eprinting.beans.Document;
import by.eprinting.beans.Order;
import by.eprinting.services.DocumentService;
import by.eprinting.services.OrderService;
import by.eprinting.services.db.DocumentDBService;
import by.eprinting.services.db.OrderDBService;
import by.eprinting.utils.FileUtil;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if (!ServletFileUpload.isMultipartContent(request)) return;
		
		ServletFileUpload upload = new ServletFileUpload( new DiskFileItemFactory() );
		upload.setHeaderEncoding("UTF-8");
		
		List<FileItem> items = null;
		try {
			items = new ArrayList<>(upload.parseRequest(request));

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		Path path = FileUtil.saveToLocalDisk(items);
		Document document = DocumentService.createDocument(path);
		
		long documentId = DocumentDBService.creatDocument(document);
		document.setId(documentId);
		
		Order order = OrderService.createOrder(items); 
		order.setDocument(document);
		
		long orderId = OrderDBService.creatOrder(order);
		order.setId(orderId);
		
		request.setAttribute("order", order);
		request.getRequestDispatcher("charge").forward(request, response);
	}
}
