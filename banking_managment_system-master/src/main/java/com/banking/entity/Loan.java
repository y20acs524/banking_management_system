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

@Entity
public class Loan {
	@Id
	private int loan_id;
	@NotEmpty
	private String loan_type;
	@NotEmpty
	private double loan_amount;
	@NotEmpty
	private int max_years;
	@NotEmpty
	private LocalDate date_of_loan;
	@Generated(GenerationTime.INSERT)
	@ColumnDefault("'A'")
	private char record_status;
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;

	
	public Loan() {
		super();
	}

	public Loan(int loan_id, String loan_type, double loan_amount, int max_years, LocalDate date_of_loan, char record_status,
			Customer customer) {
		super();
		this.loan_id = loan_id;
		this.loan_type = loan_type;
		this.loan_amount = loan_amount;
		this.max_years = max_years;
		this.date_of_loan = date_of_loan;
		this.record_status = record_status;
		this.customer = customer;
	}
	

	public Loan(int loan_id, String loan_type, double loan_amount, int max_years, LocalDate date_of_loan,
			Customer customer) {
		super();
		this.loan_id = loan_id;
		this.loan_type = loan_type;
		this.loan_amount = loan_amount;
		this.max_years = max_years;
		this.date_of_loan = date_of_loan;
		this.customer = customer;
	}

	public int getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(int loan_id) {
		this.loan_id = loan_id;
	}

	public String getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}

	public double getLoan_amount() {
		return loan_amount;
	}

	public void setLoan_amount(double loan_amount) {
		this.loan_amount = loan_amount;
	}

	public int getMax_years() {
		return max_years;
	}

	public void setMax_years(int max_years) {
		this.max_years = max_years;
	}

	public LocalDate getDate_of_loan() {
		return date_of_loan;
	}

	public void setDate_of_loan(LocalDate date_of_loan) {
		this.date_of_loan = date_of_loan;
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
		return "Loan [loan_id=" + loan_id + ", loan_type=" + loan_type + ", loan_amount=" + loan_amount + ", max_years="
				+ max_years + ", date_of_loan=" + date_of_loan + ", record_status=" + record_status + ", customer="
				+ customer + "]";
	}

	

}
