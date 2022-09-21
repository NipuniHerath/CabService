package com.web.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.web.app.model.DriverData;
import com.web.app.model.VehicleData;

public class DriverDb {

	
	public static List<DriverData> viewAll() throws ClassNotFoundException, SQLException{
		DataBaseConnector database=new SqlDataBase();
		Connection con = database.getConnection();
		String sqlcommand="SELECT * FROM drivertable";
		Statement statement=con.createStatement();
		ResultSet resultset=statement.executeQuery(sqlcommand);
		List<DriverData>drivers=new ArrayList();
		 while(resultset.next()) {
			 DriverData data=new DriverData(resultset.getInt("driverid"),resultset.getString("drivername"),resultset.getString("driverbranch"),resultset.getString("contact"));
			 drivers.add(data);
			 }
		
		return drivers;
		}
	
	
	public static boolean createDriverAccount(DriverData data) throws ClassNotFoundException, SQLException {
	DataBaseConnector database=new SqlDataBase();
	Connection con = database.getConnection();
	String sqlcommand="INSERT INTO drivertable (drivername,driverbranch,contact) values(?,?,?)";
	PreparedStatement prs = con.prepareStatement(sqlcommand);
	prs.setString(1, data.getDrivername());
	prs.setString(2, data.getDriverbranch());
	prs.setString(3, data.getContact());
	boolean trueorfalse = prs.executeUpdate() > 0 ;
	prs.close();
	con.close();
	return trueorfalse;
	}

	public static boolean update(DriverData data) throws ClassNotFoundException, SQLException {
		DataBaseConnector database=new SqlDataBase();
		Connection con = database.getConnection();
		String sqlcommand="UPDATE drivertable SET drivername=?,driverbranch=?,contact=? WHERE driverid=?";
		PreparedStatement prs = con.prepareStatement(sqlcommand);
		
		prs.setString(1, data.getDrivername());
		prs.setString(2, data.getDriverbranch());
		prs.setString(3, data.getContact());
		prs.setInt(4, data.getDriverid());
		
		boolean trueorfalse = prs.executeUpdate() > 0 ;
		prs.close();
		con.close();
		return trueorfalse;
	}
	


	   public static List<DriverData> getByID(DriverData driverdata) throws ClassNotFoundException, SQLException{
	    	DataBaseConnector database=new SqlDataBase();
			Connection con = database.getConnection();
			String sqlcommand="SELECT * FROM webapp.drivertable where driverid=?";
			PreparedStatement prs=con.prepareStatement(sqlcommand);
			prs.setInt(1, driverdata.getDriverid());
			ResultSet resultset=prs.executeQuery();
			List<DriverData>drivers=new ArrayList();
			 while(resultset.next()) {
				 DriverData data=new DriverData(resultset.getInt("driverid"),resultset.getString("drivername"),resultset.getString("driverbranch"),resultset.getString("contact"));

				 drivers.add(data);
				 
				 }
			    prs.close();
				con.close();
			 	return drivers;
	    	
	    }


	   public static DriverData getBySingleID(DriverData driverdata) throws ClassNotFoundException, SQLException{
	    	DataBaseConnector database=new SqlDataBase();
			Connection con = database.getConnection();
			String sqlcommand="SELECT * FROM webapp.drivertable where driverid=?";
			PreparedStatement prs=con.prepareStatement(sqlcommand);
			prs.setInt(1, driverdata.getDriverid());
			ResultSet resultset=prs.executeQuery();
			
			 if(resultset.next()) {
				 driverdata=new DriverData(resultset.getInt("driverid"),resultset.getString("drivername"),resultset.getString("driverbranch"),resultset.getString("contact"));

				 
				 
				 }
			    prs.close();
				con.close();
			 	return driverdata;
	    	
	    }

}
