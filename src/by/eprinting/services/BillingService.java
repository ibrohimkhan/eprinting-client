package by.eprinting.services;

import by.eprinting.beans.Bill;
import by.eprinting.services.db.RateDBService;

public class BillingService {

	public static Bill getTotalPrice(String documentFormat, int totalPage) {
		double price = RateDBService.getPrice(documentFormat);
		
		Bill bill = new Bill();
		bill.setPrice(price);
		bill.setTotalPrice(totalPage * price);
		
		return bill;
	}
}
