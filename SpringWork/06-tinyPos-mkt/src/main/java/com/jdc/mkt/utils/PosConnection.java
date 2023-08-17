package com.jdc.mkt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PosConnection {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/tinypos_db";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
