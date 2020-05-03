package com.javalearners.libraryapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.javalearners.libraryapp.model.Customer;

public class CustomerDAO {
	private static List<Customer> customers = new ArrayList<>();
	private static File registry = new File("src/main/resources/customer/Customers.data");

	@SuppressWarnings("unchecked")
	public static List<Customer> getCustomers() {
		if (customers.isEmpty()) {
			try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(registry))) {
				customers = (ArrayList<Customer>) oos.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println("Class not found");
			} catch (FileNotFoundException e1) {
				System.out.println("File not found, no existing users");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return customers;
	}

	public static void saveCustomers() {
		if (!customers.isEmpty()) {
			try {
				registry.getParentFile().mkdirs();
				registry.createNewFile();
			} catch (IOException e1) {
				System.out.println("Unable to create a new file");
			}
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(registry, false))) {
				oos.writeObject(customers);
			} catch (FileNotFoundException e) {
				System.out.println("Unable to create the file, user may not have permission");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void removeCustomer(Customer c) {
		if (c != null) {
			customers.remove(c);
		}
	}

	public static void addCustomer(Customer c) {
		if (c != null) {
			customers.add(c);
		}
	}

}
