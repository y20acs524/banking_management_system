package com.banking.dao;

import java.util.List;

import com.banking.entity.Employee;

public interface EmployeeDao {

	public boolean saveEmployee(Employee employee);
	public Employee getemployeeId(int emp_id);
	public List<Employee> getAllEmployee();
	public boolean updateEmployeeId(Employee employee,int emp_id);
	public boolean removeEmployeeId(int emp_id);
	
	
}
