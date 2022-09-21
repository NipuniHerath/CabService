package com.web.app.model;

public class VehicleData {
private int id;
private String vehiclemodle;
private int driverid;
private double coastperhour;
private String vehiclebranch;
private String vehiclecatergory;
private String availability;
public VehicleData() {
	super();
	// TODO Auto-generated constructor stub
}



public VehicleData(int id, String vehiclemodle, int driverid, double coastperhour, String vehiclebranch,
		String vehiclecatergory, String availability) {
	super();
	this.id = id;
	this.vehiclemodle = vehiclemodle;
	this.driverid = driverid;
	this.coastperhour = coastperhour;
	this.vehiclebranch = vehiclebranch;
	this.vehiclecatergory = vehiclecatergory;
	this.availability = availability;
}




public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getVehiclemodle() {
	return vehiclemodle;
}
public void setVehiclemodle(String vehiclemodle) {
	this.vehiclemodle = vehiclemodle;
}


public int getDriverid() {
	return driverid;
}


public void setDriverid(int driverid) {
	this.driverid = driverid;
}


public double getCoastperhour() {
	return coastperhour;
}
public void setCoastperhour(double coastperhour) {
	this.coastperhour = coastperhour;
}
public String getVehiclebranch() {
	return vehiclebranch;
}
public void setVehiclebranch(String vehiclebranch) {
	this.vehiclebranch = vehiclebranch;
}
public String getVehiclecatergory() {
	return vehiclecatergory;
}
public void setVehiclecatergory(String vehiclecatergory) {
	this.vehiclecatergory = vehiclecatergory;
}

public String getAvailability() {
	return availability;
}

public void setAvailability(String availability) {
	this.availability = availability;
}



}
