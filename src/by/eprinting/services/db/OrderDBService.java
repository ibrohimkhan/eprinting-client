package by.eprinting.services.db;

import by.eprinting.beans.Order;
import by.eprinting.dao.BaseDAO;
import by.eprinting.dao.OrderJdbcImpl;

public class OrderDBService {
	private static BaseDAO order = new OrderJdbcImpl();
	
	public static long creatOrder(Order newOrder) {
		return order.insert(newOrder);
	}
	
	public static Order findOrderById(long id) {
		return order.selectById(id);
	}
	
	public static void deleteOrder(Order thisOrder) {
		DocumentDBService.deleteDocument(thisOrder.getDocument());
	}
}
