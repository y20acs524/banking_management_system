package com.banking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.Length;

@Entity
public class Customer {

	@Id
	private int cust_id;

	@NotEmpty(message = "name must not be empty")
	private String cust_name;

	@NotEmpty
	@Length(max = 10)
	private long cust_phoneNo;

	@NotNull
	private String cust_addr;
	@Generated(GenerationTime.INSERT)
	@ColumnDefault("'A'")
	private char record_status;
	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;

	
	public Customer() {
		super();
	}

	public Customer(int cust_id, String cust_name, long cust_phoneNo, String cust_addr, char record_status, Branch branch) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_phoneNo = cust_phoneNo;
		this.cust_addr = cust_addr;
		this.record_status = record_status;
		this.branch = branch;
	}
	

	public Customer(int cust_id, String cust_name, long cust_phoneNo, String cust_addr, Branch branch) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_phoneNo = cust_phoneNo;
		this.cust_addr = cust_addr;
		this.branch = branch;
	}
	

	public Customer(int cust_id) {
		super();
		this.cust_id = cust_id;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public long getCust_phoneNo() {
		return cust_phoneNo;
	}

	public void setCust_phoneNo(long cust_phoneNo) {
		this.cust_phoneNo = cust_phoneNo;
	}

	public String getCust_addr() {
		return cust_addr;
	}

	public void setCust_addr(String cust_addr) {
		this.cust_addr = cust_addr;
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
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_phoneNo=" + cust_phoneNo
				+ ", cust_addr=" + cust_addr + ", record_status=" + record_status + ", branch=" + branch + "]";
	}

	
}
