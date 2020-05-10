package com.javalearners.libraryapp.data;

import java.util.List;
import java.util.Optional;
import com.javalearners.libraryapp.model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerDAO extends FileDAO<Customer>{
	private static String pathToObjectFile = "src/main/resources/customer/Customers.data";
	private static Logger logger = LogManager.getLogger();

	public CustomerDAO(){
		super(logger, pathToObjectFile);
	}

	@Override
	public Optional<Customer> getObject(String[] args){
		List<Customer> list = super.getList();
		// implement algorithm to retrieve Customer object from list based on arguments supplied to this method
		return Optional.empty(); // CHANGE THIS!!!
	}

	@Override
	public void update(Customer customer, String[] args){

		// retrieve Customer with getObject method
		List<Customer> list = super.getList();
		Customer updateCustomer = list.get(list.indexOf(customer));

		// use setter methods and values from args to change Customer object

		// replace old customer object with updateCustomer in the list
		list.set(list.indexOf(customer), updateCustomer);

		// save changes to file
		super.getFileUtils().saveListToFile(getList(), pathToObjectFile);

	}

	@Override
	public void delete(Customer customer){
		// delete customer from list
		List<Customer> list = super.getList();
		list.remove(customer);

		// save changes to file
		super.getFileUtils().saveListToFile(getList(), pathToObjectFile);
	}

	@Override
	public void add(Customer customer){
		// add customer to list
		List<Customer> list = super.getList();
		list.add(customer);

		// write customer object to file
		super.getFileUtils().saveListToFile(getList(), pathToObjectFile);
	}

}
