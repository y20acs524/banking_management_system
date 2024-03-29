package com.banking.services;

import java.util.List;

import com.banking.entity.Loan;

public interface LoanService {

	public boolean saveLoan(Loan loan);
	public Loan getLoanId(int loan_id);
	public List<Loan> getAllLoan();
	public boolean updateLoanId(Loan loan,int loan_id);
	public boolean removeLoanId(int loan_id);
	
	public List<Loan> getAllActiveLoans();
	public double getLoanAmountByLoanType(String loanType);
	public long getLaonCount();
}
