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

import com.banking.entity.Account;
import com.banking.entity.Customer;
import com.banking.serviceimplementation.AccountServiceImpl;
import com.banking.services.AccountService;
import com.banking.util.HibernateUtil;

class TestAccountService {

	static SessionFactory sessionFactory;
	static Session session;
	static AccountService accountService;
	@BeforeAll
	static void setUpTest() {
		sessionFactory=HibernateUtil.getSessionFactory();
		accountService=new AccountServiceImpl();
	}

	/*@Test
	void testCreateAccount() {
		Customer customer=new Customer(103);
		Account account=new Account(34567890123L,"SavingsAccount", LocalDate.parse("2024-03-13"), 2000, customer);
		assertTrue(accountService.saveAccount(account));
	}*/
	/*@Test
	void testGetAccountById() {
		long accn_no=12345678901L;
		Account account=accountService.getAccountId(accn_no);
		assertNotNull(account);
		equals(account);
		System.out.println(account);
	}
	@Test
	void testGetAllAccounts() {
		List<Account> accounts=accountService.getAllAccount();
		equals(accounts);
		for(Account account:accounts) {
			System.out.println(account);
		}
	}
	@Test
	void testUpdateAccountById() {
		
		long accn_no=23456789012L;
		Account account=new Account();
		account.setAccn_no(accn_no);
		account.setAccn_type("SavingsAccount");
		account.setAccn_date(LocalDate.parse("2024-02-15"));
		account.setAccn_balance(20000);
		Customer customer=new Customer(103);
		account.setCustomer(customer);
		account.setCustomer(customer);
		
		boolean value=accountService.updateAccountId(account, accn_no);
		assertTrue(value);
		System.out.println(value);
	}
	@Test
	void testDeleteAccountById() {
		long accn_no=12345678901L;
		Account account=new Account(accn_no);
		assertTrue(accountService.removeAccountId(accn_no));
	}*/
	/*@Test
	void testWithdrawAmount() {
		long accn_no=23456789012L;
		double amount=2500;
		Account account=new Account();
		account.setAccn_no(accn_no);
		assertTrue(accountService.withdrawAmount(accn_no,amount));
	}
	@Test
	void testDepositeAmount() {
		long accn_no=34567890123L;
		double amount=15000;
		Account account=new Account();
		assertTrue(accountService.depositeAmount(accn_no, amount));
	}*/
	@Test
	void testTransferAmount() {
		long fromAccountNo=23456789012l;
		long toAccountNo=34567890123l;
		double amount=1500;
		assertTrue(accountService.transferAmount(fromAccountNo, toAccountNo, amount));
	}
	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}
}
