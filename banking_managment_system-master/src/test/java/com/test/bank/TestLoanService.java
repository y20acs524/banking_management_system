package com.test.bank;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.banking.entity.Customer;
import com.banking.entity.Loan;
import com.banking.serviceimplementation.LoanServiceImpl;
import com.banking.services.LoanService;
import com.banking.util.HibernateUtil;

class TestLoanService {

	static SessionFactory sessionFactory;
	static Session session;
	static LoanService loanService;
	@BeforeAll
	static void setUpTest() {
		sessionFactory=HibernateUtil.getSessionFactory();
		loanService=new LoanServiceImpl();
	}
	/*@Test
	void testCreateLoan() {
		Customer customer=new Customer(104);
		Loan loan=new Loan(2, "HousingLoan", 150000, 2, LocalDate.parse("2024-02-15"), customer);
		assertTrue(loanService.saveLoan(loan));
		System.out.println(loan);
	}*/
	/*@Test
	void testGetLoanById() {
		int id=2;
		Loan loan=loanService.getLoanId(id);
		assertNotNull(loan);
		equals(loan);
		System.out.println(loan);
	}
	@Test
	void testGetAllLoan() {
		List<Loan> loans=loanService.getAllLoan();
		equals(loans);
		for(Loan loan:loans) {
			System.out.println(loan);
		}
	}
	@Test
	void testUpdateLoanById() {
		int id=2;
		Loan loan=new Loan();
		loan.setLoan_id(id);
		loan.setLoan_type("EducationLoan");
		loan.setLoan_amount(200000);
		loan.setMax_years(3);
		loan.setDate_of_loan(LocalDate.parse("2024-02-18"));
		Customer customer=new Customer(102);
		loan.setCustomer(customer);
		boolean value=loanService.updateLoanId(loan, id);
		assertTrue(value);
		System.out.println(value);
		
	}
	@Test
	void testDeleteLoanById() {
		int loan_id=2;
		assertTrue(loanService.removeLoanId(loan_id));
	}
	@Test
	void getAllActiveLoans() {
		equals(loanService.getAllActiveLoans());
	}
	@Test
	void getLoanAmountByLoanType() {
		String loanType="EducationLoan";
		equals(loanService.getLoanAmountByLoanType(loanType));
	}*/
	@Test
	void getLoancount() {
		equals(loanService.getLaonCount());
	}
	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}
}
