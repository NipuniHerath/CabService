package com.web.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.web.app.model.CustomerData;
import com.web.app.model.VehicleData;

public class CustomerDb {
	public static boolean createaccount(CustomerData data) throws ClassNotFoundException, SQLException {
		DataBaseConnector database=new SqlDataBase();
		Connection con = database.getConnection();
		String sqlcommand="insert into customertable (customer_name,customer_contact"+
		",customer_street,customer_city,email,password) values(?,?,?,?,?,?)";
		PreparedStatement prs = con.prepareStatement(sqlcommand);
		prs.setString(1, data.getCustomername());
		prs.setString(2,data.getCustomercontact());
		prs.setString(3, data.getCustomerstreet());
		prs.setString(4, data.getCustomercity());
		prs.setString(5, data.getEmail());
		prs.setString(6, data.getPassword());
		boolean trueorfalse = prs.executeUpdate() > 0 ;
		prs.close();
		con.close();
		return trueorfalse;
	}
	
	
	public static CustomerData login(CustomerData data) throws ClassNotFoundException, SQLException {
		
		DataBaseConnector database=new SqlDataBase();
		Connection con = database.getConnection();
		String sqlcommand="SELECT customer_name FROM webapp.customertable where email=? && password=?";
		PreparedStatement prs=con.prepareStatement(sqlcommand);
		prs.setString(1,data.getEmail() );
		prs.setString(2, data.getPassword());
		ResultSet resultset=prs.executeQuery();
		CustomerData csdata=new CustomerData();
		if(resultset.next()) {
			data=new CustomerData();
			data.setCustomername((resultset.getString("customer_name")));
			
		}
		return data;
		
	}
	
}
