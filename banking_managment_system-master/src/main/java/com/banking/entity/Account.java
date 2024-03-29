package com.banking.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.Length;

@Entity
public class Account {

	@Id
	@Length(min = 11, max = 14)
	private long accn_no;
	@NotEmpty
	private String accn_type;
	@NotEmpty
	private LocalDate accn_date;
	@NotEmpty
	private double accn_balance;
	@Generated(GenerationTime.INSERT)
	@ColumnDefault("'A'")
	private char record_status;
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;

	
	public Account() {
		super();
	}

	public Account(@Length(min = 11, max = 14) long accn_no) {
		super();
		this.accn_no = accn_no;
	}

	public Account(long accn_no, String accn_type, LocalDate accn_date, double accn_balance, char record_status,
			Customer customer) {
		super();
		this.accn_no = accn_no;
		this.accn_type = accn_type;
		this.accn_date = accn_date;
		this.accn_balance = accn_balance;
		this.record_status = record_status;
		this.customer = customer;
	}
	

	public Account(long accn_no, String accn_type, LocalDate accn_date, double accn_balance, Customer customer) {
		super();
		this.accn_no = accn_no;
		this.accn_type = accn_type;
		this.accn_date = accn_date;
		this.accn_balance = accn_balance;
		this.customer = customer;
	}

	public long getAccn_no() {
		return accn_no;
	}

	public void setAccn_no(long accn_no) {
		this.accn_no = accn_no;
	}

	public String getAccn_type() {
		return accn_type;
	}

	public void setAccn_type(String accn_type) {
		this.accn_type = accn_type;
	}

	public LocalDate getAccn_date() {
		return accn_date;
	}

	public void setAccn_date(LocalDate accn_date) {
		this.accn_date = accn_date;
	}

	public double getAccn_balance() {
		return accn_balance;
	}

	public void setAccn_balance(double accn_balance) {
		this.accn_balance = accn_balance;
	}

	

	public char getRecord_status() {
		return record_status;
	}

	public void setRecord_status(char record_status) {
		this.record_status = record_status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accn_no=" + accn_no + ", accn_type=" + accn_type + ", accn_date=" + accn_date
				+ ", accn_balance=" + accn_balance + ", record_status=" + record_status + ", customer=" + customer
				+ "]";
	}

	

}
