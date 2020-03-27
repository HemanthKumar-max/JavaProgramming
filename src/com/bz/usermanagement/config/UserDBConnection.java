package com.bz.usermanagement.config;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class UserDBConnection {
	static String path = "F:\\java\\Kentropy work accessment\\Bootstrap\\ServletCrudProject\\src\\dbase.properties";

	public static Connection getConnection() {
		Properties props = new Properties();
		FileInputStream file = null;
		Connection con = null;
		try {
			file = new FileInputStream(path);
			props.load(file);
			Class.forName(props.getProperty("DB_DRIVER_CLASS1"));
			con = DriverManager.getConnection(props.getProperty("DB_URL1"), props.getProperty("DB_USERNAME1"),
					props.getProperty("DB_PASSWORD1"));
		} catch (Exception e) {

			e.printStackTrace();
		}
		return con;
	}
}
