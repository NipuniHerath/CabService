package com.web.app.model;

public class CustomerData {

	private int Customerid;
	private String customername;
	private String customercontact;
	private String customerstreet;
	private String customercity;
	private String email;
	private String password;
	
	public CustomerData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerData(int customerid, String customername, String customercontact, String customerstreet,
			String customercity, String customerbranch, String email, String password) {
		super();
		Customerid = customerid;
		this.customername = customername;
		this.customercontact = customercontact;
		this.customerstreet = customerstreet;
		this.customercity = customercity;
		
		this.email = email;
		this.password = password;

	}
	public int getCustomerid() {
		return Customerid;
	}
	public void setCustomerid(int customerid) {
		Customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomercontact() {
		return customercontact;
	}
	public void setCustomercontact(String customercontact) {
		this.customercontact = customercontact;
	}
	public String getCustomerstreet() {
		return customerstreet;
	}
	public void setCustomerstreet(String customerstreet) {
		this.customerstreet = customerstreet;
	}
	public String getCustomercity() {
		return customercity;
	}
	public void setCustomercity(String customercity) {
		this.customercity = customercity;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
