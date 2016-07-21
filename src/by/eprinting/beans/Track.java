package by.eprinting.beans;

public class Track {
	private long id;
	private Payment payment;
	private String trackNumber;
	private String state;
	private long startDate;
	private long endDate;
	private String serial;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Payment getPayment() {
		return payment;
	}
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public String getTrackNumber() {
		return trackNumber;
	}
	
	public void setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public long getStartDate() {
		return startDate;
	}
	
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}
	
	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public String getSerial() {
		serial = trackNumber.substring(0, 12);
		return serial;
	}
}