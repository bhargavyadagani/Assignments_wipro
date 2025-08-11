package com.curd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.curd.exception.DeptException;


public class Database_con {
	public static Connection getConnection() {
	    String url = "jdbc:mysql://localhost:3306/bus";
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, "root", "Bhargav@2001");
	        System.out.println("Database connected.");  // Add this
	        return con;
	    } catch (ClassNotFoundException e) {
	        System.out.println("JDBC Driver not found.");
	        throw new DeptException(e.getMessage());
	    } catch (SQLException e) {
	        System.out.println("Database connection failed: " + e.getMessage());
	        throw new DeptException(e.getMessage());
	    }
	}

}
