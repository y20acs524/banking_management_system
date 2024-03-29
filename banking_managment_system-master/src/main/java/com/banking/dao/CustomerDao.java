package com.banking.dao;

import java.util.List;

import com.banking.entity.Customer;

public interface CustomerDao {

	public boolean saveCustomer(Customer customer);
	public Customer getCustomerId(int cust_id);
	public List<Customer> getAllCustomer();
	public boolean updatecustomerId(Customer customer,int cust_id);
	public boolean removeCustomerId(int cust_id);
	
	
}
