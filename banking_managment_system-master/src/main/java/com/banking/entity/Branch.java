package com.banking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;


@Entity
public class Branch {

	@Id
	private int branch_id;

	@NotEmpty(message = "branch name not empty")
	private String branch_name;

	@Column(length = 10, nullable = false, unique = true)
	@NotEmpty(message = "ifsc-code not must be empty")
	@Pattern(regexp = "^[A-Z]{3}[0-9]{7}$", message = "first 4 are alphabets and next are numbers")
	private String ifsc_code;

	@NotNull
	private String branch_address;
	@Generated(GenerationTime.INSERT)
	@ColumnDefault("'A'") 
	private char record_status;

	public Branch() {
		super();
	}

	public Branch(int branch_id, String branch_name, String ifsc_code, String branch_address,char record_status) {
		super();
		this.branch_id = branch_id;
		this.branch_name = branch_name;
		this.ifsc_code = ifsc_code;
		this.branch_address = branch_address;
		this.record_status=record_status;
		
	}
	

	public Branch(int branch_id, String branch_name, String ifsc_code, String branch_address) {
		super();
		this.branch_id = branch_id;
		this.branch_name = branch_name;
		this.ifsc_code = ifsc_code;
		this.branch_address = branch_address;
	}
	

	public Branch(int branch_id) {
		super();
		this.branch_id = branch_id;
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getIfsc_code() {
		return ifsc_code;
	}

	public void setIfsc_code(String ifsc_code) {
		this.ifsc_code = ifsc_code;
	}

	public String getBranch_address() {
		return branch_address;
	}

	public void setBranch_address(String branch_address) {
		this.branch_address = branch_address;
	}

	
	public char getRecord_status() {
		return record_status;
	}

	public void setRecord_status(char record_status) {
		this.record_status = record_status;
	}

	@Override
	public String toString() {
		return "Branch [branch_id=" + branch_id + ", branch_name=" + branch_name + ", ifsc_code=" + ifsc_code
				+ ", branch_address=" + branch_address + ", record_status=" + record_status + "]";
	}

	

}
