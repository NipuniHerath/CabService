package com.web.app.service;

import java.sql.SQLException;

import com.web.app.dao.CustomerDb;
import com.web.app.model.CustomerData;

public class CustomerServices {
	public  boolean createaccount(CustomerData data) throws ClassNotFoundException, SQLException {
		return CustomerDb.createaccount(data);
		
		
	}
	
public CustomerData login(CustomerData data) throws ClassNotFoundException, SQLException {
		
		return CustomerDb.login(data);
	}
	
}
