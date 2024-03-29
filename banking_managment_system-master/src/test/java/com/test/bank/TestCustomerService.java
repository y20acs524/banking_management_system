package com.test.bank;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.banking.entity.Branch;
import com.banking.entity.Customer;
import com.banking.entity.Employee;
import com.banking.serviceimplementation.CustomerServiceImpl;
import com.banking.services.CustomerService;
import com.banking.util.HibernateUtil;

class TestCustomerService {
	
	static SessionFactory sessionFactory;
	static Session session;
	static CustomerService customerService;
	@BeforeAll
	static void setUpTest() {
		sessionFactory=HibernateUtil.getSessionFactory();
		customerService=new CustomerServiceImpl();
	}
	/*@Test
	void testCreateCustomer() {
		Branch branch=new Branch(104);
		Customer customer=new Customer(104, "vishali",9382737472L,"kothapet", branch);
		assertTrue(customerService.saveCustomer(customer));
	}*/
	@Test
	void testGetCustomerdById() {
		int id=103;
		Customer customer=customerService.getCustomerId(id);
		assertNotNull(customer);
		System.out.println(customer);
		equals(customer.getCust_id());
	}
	@Test
	void testGetAllCustomers() {
		equals(customerService.getAllCustomer());
	}
	@Test
	void updateCustomerById() {
		Branch branch=new Branch(104);
		int id=104;
		Customer customer=new Customer();
		customer.setCust_id(id);
		customer.setCust_name("vignesh");
		customer.setCust_phoneNo(8293746582L);
		customer.setCust_addr("amalapuram");
		customer.setBranch(branch);
		System.out.println(customer);
		assertTrue(customerService.updateCustomerId(customer, id));
	}
	@Test 
	void deleteCustomerById() {
		int id=101;
		Customer customer=new Customer(id);
		assertTrue(customerService.removeCustomerId(id));
		System.out.println(customer);
	}
	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}
}
