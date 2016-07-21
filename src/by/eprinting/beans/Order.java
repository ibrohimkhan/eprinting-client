package by.eprinting.beans;

import java.util.Date;

public class Order {
	private long id;
	private String fullName;
	private String email;
	private String phone;
	private String address;
	private Document document;
	private Date date;	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}	
}
