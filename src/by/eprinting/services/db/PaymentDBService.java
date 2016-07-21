package by.eprinting.services.db;

import by.eprinting.beans.Payment;
import by.eprinting.dao.BaseDAO;
import by.eprinting.dao.PaymentJdbcImpl;

public class PaymentDBService {
	private static BaseDAO pay = new PaymentJdbcImpl();
	
	public static long creatPayment(Payment payment) {
		return pay.insert(payment);
	}
	
	public static Payment findPaymentById(long id) {
		return pay.selectById(id);
	}
	
	public static void deletePayment(Payment payment) {
		DocumentDBService.deleteDocument(payment.getOrder().getDocument());
	}
}
