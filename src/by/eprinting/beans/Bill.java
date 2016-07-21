package by.eprinting.beans;

import java.util.Formatter;

public class Bill {
	private double price;
	private double totalPrice;
	private String formatedTotalPrice;

	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getFormatedTotalPrice() {
		Formatter formatter = new Formatter();
		formatedTotalPrice = formatter.format("%.2f", totalPrice).toString();
		formatter.close();
		
		return formatedTotalPrice;
	}
}