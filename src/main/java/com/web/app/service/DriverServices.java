package com.web.app.service;

import java.sql.SQLException;
import java.util.List;

import com.web.app.dao.DriverDb;
import com.web.app.model.DriverData;
import com.web.app.model.VehicleData;

public class DriverServices {
public boolean add(DriverData driver) throws ClassNotFoundException, SQLException {
	return DriverDb.createDriverAccount(driver);}

public List<DriverData> viewAll() throws ClassNotFoundException, SQLException{
	return DriverDb.viewAll();
}

public List<DriverData> viewbyID(DriverData driver) throws ClassNotFoundException, SQLException{
	return DriverDb.getByID(driver);
}

public  boolean update(DriverData data) throws ClassNotFoundException, SQLException {
	return DriverDb.update(data);
}

public  DriverData getBySingleID(DriverData driverdata) throws ClassNotFoundException, SQLException {
	return DriverDb.getBySingleID(driverdata);
}
}
