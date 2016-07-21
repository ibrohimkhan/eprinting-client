package by.eprinting.beans;

import java.util.Formatter;

public class Payment {
	private long id;
	private Order order;
	private long amountInCents;
	private String token;
	private String chargeId;
	private String status;
	private boolean paid;
	private long date;
	private String amount;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public long getAmountInCents() {
		return amountInCents;
	}
	
	public void setAmountInCents(long amountInCents) {
		this.amountInCents = amountInCents;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean isPaid() {
		return paid;
	}
	
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getAmount() {
		Formatter formatter = new Formatter();
		
		amount = formatter.format("%.2f", amountInCents / 100.00).toString();
		formatter.close();
		
		return amount;
	}	
}
