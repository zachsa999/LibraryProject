package com.javalearners.libraryapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6377397939836943218L;
	private String firstName;
	private String lastName;
	private UserAccount userAccount;
	private List<Book> booksBorrowed;


	public Customer(String name, String lastName, UserAccount userAccount) {
		this.firstName = name;
		this.lastName = lastName;
		this.userAccount = userAccount;
		this.booksBorrowed = new ArrayList<>();
	}
	
	public void displayCustomerInformation() {
		StringBuilder sb = new StringBuilder("");
		sb.append("Name: ").append(this.firstName).append(System.getProperty("line.separator")).
		append("Last name: ").append(this.lastName).append(System.getProperty("line.separator")).
		append("Books owed: ").append(this.booksBorrowed.size());
		System.out.println(sb.toString());
	}
	
	public void setName(String name) {
		this.firstName = name;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void addBook(Book book) {
		this.booksBorrowed.add(book);
	}
	
	public void removeBook(Book book) {
		if(this.booksBorrowed.contains(book)) {
			this.booksBorrowed.remove(book);
		}
	}
	
	public List<Book> getBorrowedList() {
		return this.booksBorrowed;
	}
	
	public UserAccount getUserAccount() {
		return this.userAccount;
	}
	
	public String getName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
}
