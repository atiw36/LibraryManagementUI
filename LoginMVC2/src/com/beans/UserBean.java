package com.beans;

public class UserBean {
	// required properties for bean
	// reusable component , part of model
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String bookName;
	private String bookId;
	private String authorName;
	private int price ;
	public boolean valid;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	public String getBookname() {
		return bookName;
	}
	
	public void setBookname(String bookName) {
		this.bookName = bookName;
	}
	
	public String getBookId() {
		return bookId;
	}
	
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getAuthorName() {
		return authorName;
	}
	
	
	public void setAuthorName (String authorName) {
		this.authorName = authorName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice (int price) {
		this.price = price;
	}
	
}
