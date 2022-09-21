package com.web.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDataBase implements DataBaseConnector {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/webapp";
	    String userName="root";
		String password="123456";
		return DriverManager.getConnection(url,userName,password);
	}
	

}
