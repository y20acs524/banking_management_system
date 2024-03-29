package com.banking.serviceimplementation;

import java.util.List;

import com.banking.dao.LoanDao;
import com.banking.daoimplementation.LoanDaoImpl;
import com.banking.entity.Loan;
import com.banking.services.LoanService;

public class LoanServiceImpl implements LoanService{

	LoanDao loanDao=new LoanDaoImpl();
	@Override
	public boolean saveLoan(Loan loan) {
		return loanDao.saveLoan(loan);
		
	}

	@Override
	public Loan getLoanId(int loan_id) {
		return loanDao.getLoanId(loan_id);
	}

	@Override
	public List<Loan> getAllLoan() {
		return loanDao.getAllLoan();
	}

	@Override
	public boolean updateLoanId(Loan loan, int loan_id) {
		return loanDao.updateLoanId(loan, loan_id);
	}

	@Override
	public boolean removeLoanId(int loan_id) {
		return loanDao.removeLoanId(loan_id);
		
	}
	public List<Loan> getAllActiveLoans(){
		return loanDao.getAllActiveLoans();
		
	}
	public double getLoanAmountByLoanType(String loanType) {
		return loanDao.getLoanAmountByLoanType(loanType);
	}
	public long getLaonCount() {
		return loanDao.getLaonCount();
	}

}
