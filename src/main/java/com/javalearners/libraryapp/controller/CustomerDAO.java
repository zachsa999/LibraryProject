package com.javalearners.libraryapp.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.javalearners.libraryapp.model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerDAO {
	private static List<Customer> customers = new ArrayList<>();
	private static File registry = new File("src/main/resources/customer/Customers.data");
	private static Logger logger = LogManager.getLogger();

	@SuppressWarnings("unchecked")
	public static List<Customer> getCustomers() {
		if (customers.isEmpty()) {
			try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(registry))) {
				customers = (ArrayList<Customer>) oos.readObject();
			} catch (ClassNotFoundException e) {
				logger.error("Class not found");
			} catch (FileNotFoundException e1) {
				logger.error("File not found, no existing users");
			} catch (IOException e1) {
				e1.printStackTrace();
				logger.error("Threw a IOException in CustomerDAO::getCustomers(), full stack trace follows:", e1);
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
				logger.error("Unable to create a new file");
			}
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(registry, false))) {
				oos.writeObject(customers);
			} catch (FileNotFoundException e) {
				logger.error("Unable to create the file, user may not have permission");
			} catch (IOException e) {
				logger.error("Threw a IOException in CustomerDAO::saveCustomers(), full stack trace follows:", e);
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
