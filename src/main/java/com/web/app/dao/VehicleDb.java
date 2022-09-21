package com.web.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.web.app.model.BookingData;
import com.web.app.model.DriverData;
import com.web.app.model.VehicleData;

public class VehicleDb {
	
	
	
	
	public static List<VehicleData>getall() throws ClassNotFoundException, SQLException{
		DataBaseConnector database=new SqlDataBase();
		Connection con = database.getConnection();
		String sqlcommand="SELECT * FROM webapp.vehicletable";
		Statement statement=con.createStatement();
		ResultSet resultset=statement.executeQuery(sqlcommand);
		List<VehicleData>vehicles=new ArrayList();
		 while(resultset.next()) {
			 
			 VehicleData vehicle=new VehicleData(resultset.getInt("id"),resultset.getString("name"),resultset.getInt("driver_id"),resultset.getDouble("paymentdetails"),resultset.getString("vehiclebranch"),resultset.getString("category"),resultset.getString("availabale"));
			 vehicles.add(vehicle);
			 
			 }
		 	statement.close();
			con.close();
		 	return vehicles;
		}
		
    public static List<VehicleData> getByID(VehicleData data) throws ClassNotFoundException, SQLException{
    	DataBaseConnector database=new SqlDataBase();
		Connection con = database.getConnection();
		String sqlcommand="SELECT * FROM webapp.vehicletable where id=?";
		PreparedStatement prs=con.prepareStatement(sqlcommand);
		prs.setInt(1, data.getId());
		ResultSet resultset=prs.executeQuery();
		List<VehicleData>vehicles=new ArrayList();
		 while(resultset.next()) {
			 
			 VehicleData vehicle=new VehicleData(resultset.getInt("id"),resultset.getString("name"),resultset.getInt("driver_id"),resultset.getDouble("paymentdetails"),resultset.getString("vehiclebranch"),resultset.getString("category"),resultset.getString("availabale"));
			 vehicles.add(vehicle);
			 
			 }
		    prs.close();
			con.close();
		 	return vehicles;
    	
    }
    public static VehicleData getBySingleID(VehicleData data) throws ClassNotFoundException, SQLException{
    	DataBaseConnector database=new SqlDataBase();
		Connection con = database.getConnection();
		String sqlcommand="SELECT * FROM webapp.vehicletable where id=?";
		PreparedStatement prs=con.prepareStatement(sqlcommand);
		prs.setInt(1, data.getId());
		ResultSet resultset=prs.executeQuery();
		
		 while(resultset.next()) {
			 
			 data=new VehicleData(resultset.getInt("id"),resultset.getString("name"),resultset.getInt("driver_id"),resultset.getDouble("paymentdetails"),resultset.getString("vehiclebranch"),resultset.getString("category"),resultset.getString("availabale"));
			 
			 
			 }
		    prs.close();
			con.close();
		 	return data;
    	
    }
	
    public static List<VehicleData> bookingvehicle() throws ClassNotFoundException, SQLException{
    	DataBaseConnector database=new SqlDataBase();
		Connection con = database.getConnection();
		String sqlcommand="SELECT id,name,paymentdetails,vehiclebranch,category,driver_id FROM webapp.vehicletable where availabale='yes'";
		Statement statement=con.createStatement();
		ResultSet resultset=statement.executeQuery(sqlcommand);
		List<VehicleData>vehicles=new ArrayList();
		 while(resultset.next()) {
			 
			 VehicleData vehicle=new VehicleData();
			 vehicle.setId(resultset.getInt("id"));
			 vehicle.setVehiclemodle(resultset.getString("name"));
			 vehicle.setCoastperhour(resultset.getDouble("paymentdetails"));
			 vehicle.setVehiclebranch(resultset.getString("vehiclebranch"));
			 vehicle.setVehiclecatergory(resultset.getString("category"));
			 vehicle.setDriverid(resultset.getInt("driver_id"));
			 vehicles.add(vehicle);
			 
			 }
		 	statement.close();
			con.close();
		 	return vehicles;
		
    	
    }
	public static boolean addvehicle(VehicleData data) throws ClassNotFoundException, SQLException {
		DataBaseConnector database=new SqlDataBase();
		Connection con = database.getConnection();
		String sqlcommand="INSERT INTO vehicletable (name,driver_id,paymentdetails,vehiclebranch,category,availabale) values(?,?,?,?,?,?)";
		PreparedStatement prs = con.prepareStatement(sqlcommand);
		prs.setString(1, data.getVehiclemodle());
		prs.setInt(2, data.getDriverid());
		prs.setDouble(3, data.getCoastperhour());
		prs.setString(4,data.getVehiclebranch());
		prs.setString(5, data.getVehiclecatergory());
		prs.setString(6, data.getAvailability());
		boolean trueorfalse = prs.executeUpdate() > 0 ;
		prs.close();
		con.close();
		return trueorfalse;
	}
	

	public static boolean update(VehicleData data) throws ClassNotFoundException, SQLException {
		DataBaseConnector database=new SqlDataBase();
		Connection con = database.getConnection();
		String sqlcommand="UPDATE vehicletable SET name=?,driver_id=?,paymentdetails=?,vehiclebranch=?,"+
		"category=?,availabale=? WHERE id=?;";
		PreparedStatement prs = con.prepareStatement(sqlcommand);
		prs.setString(1, data.getVehiclemodle());
		prs.setInt(2, data.getDriverid());
		prs.setDouble(3, data.getCoastperhour());
		prs.setString(4, data.getVehiclebranch());
		prs.setString(5, data.getVehiclecatergory());
		prs.setString(6, data.getAvailability());
		prs.setInt(7, data.getId());
		
		boolean trueorfalse = prs.executeUpdate() > 0 ;
		prs.close();
		con.close();
		return trueorfalse;
	}
	
	public static boolean delete(VehicleData data) throws ClassNotFoundException, SQLException {
		
		DataBaseConnector database=new SqlDataBase();
		Connection con = database.getConnection();
		String sqlcommand="DELETE  FROM vehicletable WHERE  id=?;";
		PreparedStatement prs = con.prepareStatement(sqlcommand);
		
		prs.setInt(1, data.getId());
		
		boolean trueorfalse = prs.executeUpdate() > 0 ;
		prs.close();
		con.close();
		return trueorfalse;
	}
	
	public static boolean bookNow(BookingData data) throws ClassNotFoundException, SQLException {
		DataBaseConnector database=new SqlDataBase();
		Connection con = database.getConnection();
		String sqlcommand="INSERT INTO vehicleorder (customername,from_street,from_location,to_street,to_location,hours,"
				+ "coast,date,driver_contact,status) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prs = con.prepareStatement(sqlcommand);
		prs.setString(1,data.getCustomername());
		prs.setString(2,data.getFromstreet());
		prs.setString(3,data.getFromlocation());
		prs.setString(4,data.getTostreet());
		prs.setString(5,data.getTolocation());
		prs.setDouble(6, data.getHours());
		prs.setDouble(7, data.getCoast());
		prs.setString(8,data.getDate());
		prs.setString(9,data.getDrivernumber());
		prs.setString(10,data.getStatus());
		boolean trueorfalse = prs.executeUpdate() > 0 ;
		prs.close();
		con.close();
		return trueorfalse;
		
	}
	
	public static List<BookingData> viewBookingDriver(BookingData data) throws ClassNotFoundException, SQLException {
		
		DataBaseConnector database=new SqlDataBase();
		Connection con = database.getConnection();
		String sqlcommand="SELECT * FROM webapp.vehicleorder where driver_contact=? && status='pending'";
		PreparedStatement prs=con.prepareStatement(sqlcommand);
		prs.setString(1, data.getDrivernumber());
		ResultSet resultset=prs.executeQuery();
		List<BookingData>bookingdata=new ArrayList();
		while(resultset.next()) {
			 
			BookingData order=new BookingData(resultset.getInt("order_id"),resultset.getString("customername"),
					resultset.getString("from_street"),resultset.getString("from_location"),resultset.getString("to_street"),
					resultset.getString("to_location"),resultset.getDouble("hours"),resultset.getDouble("coast"),
					resultset.getString("date"),resultset.getString("driver_contact"),resultset.getString("status"));
			
			bookingdata.add(order);
			 
			 }
		
		    prs.close();
			con.close();
		 	return bookingdata;
	
		
		
		
	}
}
