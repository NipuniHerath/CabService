package com.web.app.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataBaseConnector {
public Connection getConnection() throws ClassNotFoundException, SQLException;
}
