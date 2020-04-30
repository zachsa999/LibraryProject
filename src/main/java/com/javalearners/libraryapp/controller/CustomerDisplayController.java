package com.javalearners.libraryapp.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.javalearners.libraryapp.model.Customer;

public class CustomerDisplayController {
	private static List<Customer> customers;
	
	static {
		List<Customer> temp = CustomerDAO.getCustomers();
		for(Customer c : temp) {
			customers.add(c);
		}
	}
	
	public static List<Customer> getCustomers() {
		return customers;
	}
	
	public static List<Customer> listCustomers(String attribute) throws IllegalArgumentException {
		List<Customer> temporary = null;
		if(!attribute.equalsIgnoreCase("Name") && !attribute.equalsIgnoreCase("Last name")) {
			throw new IllegalArgumentException("Currently search is only possible using \"name\" & \"Last name\"");
		} else if(attribute.equalsIgnoreCase("Name")) {
			return temporary = customers.stream().sorted(Comparator.comparing(Customer::getName).thenComparing(Customer::getLastName)).
					collect(Collectors.toList());
		} else if(attribute.equalsIgnoreCase("Last name")) {
			return temporary = customers.stream().sorted(Comparator.comparing(Customer::getLastName).thenComparing(Customer::getName)).
						collect(Collectors.toList());
		}
		return temporary;
	
	}
	
	public static List<Customer> searchForCustomer(String name) {
		List<Customer> temporary = new ArrayList<>();
		for(Customer c : customers) {
			if(c.getName().equalsIgnoreCase(name)) {
				temporary.add(c);
			}
		}
		return temporary;
	}
}
