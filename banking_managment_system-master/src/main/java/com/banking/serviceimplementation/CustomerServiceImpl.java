package com.banking.serviceimplementation;

import java.util.List;

import com.banking.dao.CustomerDao;
import com.banking.daoimplementation.CustomerDaoImpl;
import com.banking.entity.Customer;
import com.banking.services.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	CustomerDao customerDao=new CustomerDaoImpl();
	@Override
	public boolean saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}

	@Override
	public Customer getCustomerId(int cust_id) {
		return customerDao.getCustomerId(cust_id);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

	@Override
	public boolean updateCustomerId(Customer customer, int cust_id) {
		return customerDao.updatecustomerId(customer, cust_id);
	}

	@Override
	public boolean removeCustomerId(int cust_id) {
		return customerDao.removeCustomerId(cust_id);
		
	}

}
