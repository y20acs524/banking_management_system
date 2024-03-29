package com.banking.services;

import java.util.List;

import com.banking.entity.Customer;

public interface CustomerService {

	public boolean saveCustomer(Customer customer);
	public Customer getCustomerId(int cust_id);
	public List<Customer> getAllCustomer();
	public boolean updateCustomerId(Customer customer,int cust_id);
	public boolean removeCustomerId(int cust_id);
	
}
