package by.eprinting.beans;

public class Rate {
	private long id;
	private String format;
	private double price;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
