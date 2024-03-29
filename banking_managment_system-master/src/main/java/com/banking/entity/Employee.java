package com.banking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
public class Employee {

	@Id
	private int emp_id;
	private String emp_name;
	private double emp_salary;
	private String emp_addr;
	@Generated(GenerationTime.INSERT)
	@ColumnDefault("'A'")
	private char record_status;
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;

	
	public Employee() {
		super();
	}

	public Employee(int emp_id) {
		super();
		this.emp_id = emp_id;
	}

	public Employee(int emp_id, String emp_name, double emp_salary, String emp_addr, char record_status, Branch branch) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
		this.emp_addr = emp_addr;
		this.record_status = record_status;
		this.branch = branch;
	}
	

	public Employee(int emp_id, String emp_name, double emp_salary, String emp_addr, Branch branch) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
		this.emp_addr = emp_addr;
		this.branch = branch;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public double getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(double emp_salary) {
		this.emp_salary = emp_salary;
	}

	public String getEmp_addr() {
		return emp_addr;
	}

	public void setEmp_addr(String emp_addr) {
		this.emp_addr = emp_addr;
	}

	

	public char getRecord_status() {
		return record_status;
	}

	public void setRecord_status(char record_status) {
		this.record_status = record_status;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_salary=" + emp_salary + ", emp_addr="
				+ emp_addr + ", record_status=" + record_status + ", branch=" + branch + "]";
	}

	
}
