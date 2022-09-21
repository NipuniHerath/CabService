package com.web.app.model;

public class DriverData {
private int driverid;
private String drivername;
private String driverbranch;
private String contact;
public DriverData() {
	super();
	// TODO Auto-generated constructor stub
}

public DriverData(int driverid, String drivername, String driverbranch, String contact) {
	super();
	this.driverid = driverid;
	this.drivername = drivername;
	this.driverbranch = driverbranch;
	this.contact = contact;
}

public int getDriverid() {
	return driverid;
}
public void setDriverid(int driverid) {
	this.driverid = driverid;
}
public String getDrivername() {
	return drivername;
}
public void setDrivername(String drivername) {
	this.drivername = drivername;
}
public String getDriverbranch() {
	return driverbranch;
}
public void setDriverbranch(String driverbranch) {
	this.driverbranch = driverbranch;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}


}
