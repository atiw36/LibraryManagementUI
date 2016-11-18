package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// DB connectivity done 
// connection object is being returned by static getConnection()
//part of model
public class ConnectionManager {
	static Connection con;
	static String url;

	public static Connection getConnection() {
		try {
			// DB URL
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			// assuming SQL Server's user is "root"
			// and password is "root"
			String dbUser = "system";
			String dbPassword = "system";
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				con = DriverManager.getConnection(url, dbUser, dbPassword);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException cnfe) {
			cnfe.getStackTrace();
		}

		return con;
	}
}
