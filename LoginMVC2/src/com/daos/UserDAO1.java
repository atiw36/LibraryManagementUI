package com.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beans.UserBean;
import com.utils.ConnectionManager;

// building db layer , it is DAO , part of model
public class UserDAO1 {
	static Connection currentCon = null;
	
	static ResultSet rs1 = null;

	public static UserBean login(UserBean bean) {
		// preparing some objects for connection
		Statement stmt = null;
		// username & password created through bean getter
		String bookName = bean.getBookname();
		
		// search query to find out for specific user
	
		
		String searchQuery1 = "select * from book where bookname='"+bookName+"' ";
		// "System.out.println" prints in the console; Normally used to trace
		// the process
		
		System.out.println("Query: " + searchQuery1);
		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			System.out.println("Connection is "+currentCon);
			stmt = currentCon.createStatement();
		
			rs1 = stmt.executeQuery(searchQuery1);
			System.out.println("Resultset is "+rs1);
			boolean more = rs1.next();
			System.out.println("Resultset boolean is "+more);
			// if user does not exist set the isValid
			// variable more to false
			if (!more) {
				System.out
						.println("Sorry, This book is not available");
				bean.setValid(false);
			} // if user exists set the isValid variable to true
			else if (more) {
				String bookId = rs1.getString("bookId");
				String authorName = rs1.getString("author");
				int price =Integer.parseInt(rs1.getString("price"));
				
				bean.setBookId(bookId);
				bean.setAuthorName(authorName);
				bean. setPrice( price);
				bean.setValid(true);
			}
			// some exception handling
		} catch (SQLException sqlEx) {
			System.out.println(" DB Exception has occurred! "
					+ sqlEx);
		} catch (Exception ex) {
			System.out.println(" An Exception has occurred! "
					+ ex);
		}
		// Free the database resources
		finally {
			if (rs1 != null) {
				try {
					rs1.close();
				} catch (Exception e) {
				}
				rs1 = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {

				}
				stmt = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {

				}
				currentCon = null;
			}
		}
		return bean;
	}
}
