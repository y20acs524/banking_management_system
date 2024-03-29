package com.banking.daoimplementation;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.banking.dao.EmployeeDao;
import com.banking.entity.Employee;
import com.banking.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public boolean saveEmployee(Employee employee) {
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
			
			return true;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public Employee getemployeeId(int emp_id) {
		try(Session session=HibernateUtil.getSession()){
			Employee employee=session.get(Employee.class,emp_id);
			return employee;
		}
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		try(Session session=HibernateUtil.getSession()){
			List<Employee> listEmployee=session.createQuery("from Employee",Employee.class).getResultList();
			return listEmployee;
		}
		
	}

	@Override
	public boolean updateEmployeeId(Employee employee, int emp_id) {
		try(Session session=HibernateUtil.getSession()){
			Employee emp=session.get(Employee.class,emp_id );
			
			emp.setEmp_id(emp_id);
			emp.setEmp_name(employee.getEmp_name());
			emp.setEmp_salary(employee.getEmp_salary());
			emp.setEmp_addr(employee.getEmp_addr());
			emp.setRecord_status('A');
			
			session.beginTransaction();
			session.saveOrUpdate(emp);
			session.getTransaction().commit();
			
			return true;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean removeEmployeeId(int emp_id) {
		try(Session session=HibernateUtil.getSession()){
			Employee employee=session.get(Employee.class,emp_id);
			
			session.beginTransaction();
			if(employee!=null) {
				employee.setRecord_status('I');
				session.saveOrUpdate(employee);
				session.getTransaction().commit();
			}
			return true;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	}

}
