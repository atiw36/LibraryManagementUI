package com.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beans.UserBean;
import com.utils.ConnectionManager;

public class SignUpDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public static UserBean register(UserBean bean) {
		// preparing some objects for connection
		Statement stmt = null;
		// username & password created through bean getter
		String firstname=bean.getFirstName();
		String lastname=bean.getLastName();
		String username = bean.getUsername();
		String password = bean.getPassword();
		// search query to find out for specific user
		String insertQuery = "insert into users values (?,?,?,?)";
		// "System.out.println" prints in the console; Normally used to trace
		// the process
		System.out.println("Your First name"+firstname);
		System.out.println("Your Last name"+lastname);
		System.out.println("Your are " + username);
		System.out.println("Your password is " + password);
		System.out.println("Query: " + insertQuery);
		PreparedStatement statement = null;
		try { // connect to DB
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			statement = currentCon.prepareStatement(insertQuery);
			statement.setString(1, firstname);
			statement.setString(2, lastname);
			statement.setString(3, username);
			statement.setString(4, password);
		//	statement.setString(5, item.getCategory());
		//	statement.setString(6, item.getAvailability());
			statement.executeUpdate();
		//	logger.info("Inserted Sucessfully");
			System.out.println("Inserted");
			
			
			
			
			
			/*rs = stmt.executeQuery(insertQuery);
			boolean more = rs.next(); 
			if (!more) {
				System.out
						.println("Sorry, you are not a registered user! Please sign up first");
				bean.setValid(false);
			} // if user exists set the isValid variable to true
			else if (more) {
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				System.out.println("Welcome " + firstName);
				bean.setFirstName(firstName);
				bean.setLastName(lastName);
				bean.setValid(true);
			}*/
			// some exception handling
		} catch (SQLException sqlEx) {
			System.out.println("Log In failed: DB Exception has occurred! "
					+ sqlEx);
		}
		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}
		// Free the database resources
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
				rs = null;
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