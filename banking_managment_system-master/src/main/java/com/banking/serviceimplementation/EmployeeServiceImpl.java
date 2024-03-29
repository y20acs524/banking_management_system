package com.banking.serviceimplementation;

import java.util.List;

import com.banking.dao.EmployeeDao;
import com.banking.daoimplementation.EmployeeDaoImpl;
import com.banking.entity.Employee;
import com.banking.services.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDao employeeDao=new EmployeeDaoImpl();
	@Override
	public boolean saveEmployee(Employee employee) {
		return employeeDao.saveEmployee(employee);
	}

	@Override
	public Employee getEmployeeId(int emp_id) {
		return employeeDao.getemployeeId(emp_id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	@Override
	public boolean updateEmployeeId(Employee employee, int emp_id) {
		return employeeDao.updateEmployeeId(employee, emp_id);
	}

	@Override
	public boolean removeEmployeeId(int emp_id) {
		return employeeDao.removeEmployeeId(emp_id);
		
	}

}
