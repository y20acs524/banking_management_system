package com.banking.services;

import java.util.List;

import com.banking.entity.Employee;

public interface EmployeeService {

	public boolean saveEmployee(Employee employee);
	public Employee getEmployeeId(int emp_id);
	public List<Employee> getAllEmployee();
	public boolean updateEmployeeId(Employee employee,int emp_id);
	public boolean removeEmployeeId(int emp_id);
}
