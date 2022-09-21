package com.web.app.service;

import java.sql.SQLException;
import java.util.List;

import com.web.app.dao.VehicleDb;
import com.web.app.model.BookingData;
import com.web.app.model.CustomerData;
import com.web.app.model.DriverData;
import com.web.app.model.VehicleData;

public class VehicleServices {
	
	public List<VehicleData> getAll() throws ClassNotFoundException, SQLException{
		
		return VehicleDb.getall();
		
	}

	public boolean addvehicle(VehicleData vdata) throws ClassNotFoundException, SQLException {
		
		return VehicleDb.addvehicle(vdata);
		
	}
	
	
	public List<VehicleData> getByID(VehicleData data) throws ClassNotFoundException, SQLException {
		return VehicleDb.getByID(data);
	}

	public boolean updatevehicle(VehicleData vdata) throws ClassNotFoundException, SQLException {
		return VehicleDb.update(vdata);
	}
	public boolean delete(VehicleData vdata) throws ClassNotFoundException, SQLException {
		return VehicleDb.delete(vdata);
	}
	
	public  List<VehicleData> bookingvehicle() throws ClassNotFoundException, SQLException{
		return VehicleDb.bookingvehicle();
		
	}
	
	public  VehicleData getBySingleID(VehicleData data) throws ClassNotFoundException, SQLException {
		return VehicleDb.getBySingleID(data);
	}
	
	public  boolean bookNow(BookingData data) throws ClassNotFoundException, SQLException {
		
		return VehicleDb.bookNow(data);
	}
	public static List<BookingData> viewBookingDriver(BookingData data) throws ClassNotFoundException, SQLException{
		
	return	VehicleDb.viewBookingDriver(data);
	}
}