package by.eprinting.services.db;

import by.eprinting.dao.RateJdbcImpl;

public class RateDBService {
	private static RateJdbcImpl rate = new RateJdbcImpl();
	
	public static double getPrice(String format) {
		return rate.findByFormat(format).getPrice();
	}
}
