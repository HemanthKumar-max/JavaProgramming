package com.bridgelabz.crud.config;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class StudentConnection {

	static String path = "F:\\java\\Kentropy work accessment\\Bootstrap\\JDBC CRUD\\src\\db.properties";

	public static Connection getConnection() {
		Properties props = new Properties();
		FileInputStream file = null;
		Connection con = null;
		try {
			file = new FileInputStream(path);
			props.load(file);
			Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			con = DriverManager.getConnection(props.getProperty("DB_URL"), props.getProperty("DB_USERNAME"),
					props.getProperty("DB_PASSWORD"));
		} catch (Exception e) {

			e.printStackTrace();
		}
		return con;
	}
}