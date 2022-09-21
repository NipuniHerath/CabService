package com.web.app.model;

public class BookingData {

	private int order_id;
	private String customername;
	private String fromstreet;
	private String fromlocation;
	private String tostreet;
	private String tolocation;
	private double hours;
	private double coast;
	private String date;
	private String drivernumber;
	private String status;
	public BookingData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingData(int order_id, String customername, String fromstreet, String fromlocation, String tostreet,
			String tolocation, double hours, double coast, String date, String drivernumber, String status) {
		super();
		this.order_id = order_id;
		this.customername = customername;
		this.fromstreet = fromstreet;
		this.fromlocation = fromlocation;
		this.tostreet = tostreet;
		this.tolocation = tolocation;
		this.hours = hours;
		this.coast = coast;
		this.date = date;
		this.drivernumber = drivernumber;
		this.status = status;
	}

	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getFromstreet() {
		return fromstreet;
	}
	public void setFromstreet(String fromstreet) {
		this.fromstreet = fromstreet;
	}
	public String getFromlocation() {
		return fromlocation;
	}
	public void setFromlocation(String fromlocation) {
		this.fromlocation = fromlocation;
	}
	public String getTostreet() {
		return tostreet;
	}
	public void setTostreet(String tostreet) {
		this.tostreet = tostreet;
	}
	public String getTolocation() {
		return tolocation;
	}
	public void setTolocation(String tolocation) {
		this.tolocation = tolocation;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}
	public double getCoast() {
		return coast;
	}
	public void setCoast(double coast) {
		this.coast = coast;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getDrivernumber() {
		return drivernumber;
	}

	public void setDrivernumber(String drivernumber) {
		this.drivernumber = drivernumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	
}
