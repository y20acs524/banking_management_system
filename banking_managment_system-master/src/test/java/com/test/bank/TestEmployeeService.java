package com.test.bank;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.banking.entity.Branch;
import com.banking.entity.Employee;
import com.banking.serviceimplementation.EmployeeServiceImpl;
import com.banking.services.EmployeeService;
import com.banking.util.HibernateUtil;

class TestEmployeeService {

	static SessionFactory sessionFactory;
	static Session session;
	static EmployeeService employeeService;

	@BeforeAll
	static void setUpTest() {
		sessionFactory = HibernateUtil.getSessionFactory();
		employeeService = new EmployeeServiceImpl();
	}

	@Test
	void testCreateEmployee() {
		Branch branch = new Branch(104);
		Employee employee = new Employee(4, "sri", 35000, "amalapuram", branch);

		assertTrue(employeeService.saveEmployee(employee), "data inserted successfully");

	}

	/*
	 * @Test void testGetEmployeeId() { int id=2; Employee
	 * employee=employeeService.getEmployeeId(id); assertNotNull(employee);
	 * equals(employee.getEmp_id());
	 * 
	 * }
	 * 
	 * @Test void testGetAllEmployee() { equals(employeeService.getAllEmployee()); }
	 * 
	 * @Test void testUpdateEmployeeById() { int branch_id=104; Branch branch=new
	 * Branch(branch_id); int id=2; Employee employee=new Employee();
	 * employee.setEmp_id(id); employee.setEmp_name("kavya");
	 * employee.setEmp_salary(30000); employee.setEmp_addr("kothapeta");
	 * employee.setBranch(branch);
	 * assertTrue(employeeService.updateEmployeeId(employee,
	 * id),"data updated successfully"); }
	 * 
	 * @Test void testDeleteByEmployeeId() { int id=2;
	 * assertTrue(employeeService.removeEmployeeId(id)); }
	 */
	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}
}
