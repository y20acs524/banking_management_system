package com.banking.serviceimplementation;

import java.util.List;

import com.banking.dao.AccountDao;
import com.banking.daoimplementation.AccountDaoImpl;
import com.banking.entity.Account;
import com.banking.services.AccountService;

public class AccountServiceImpl implements AccountService{

	AccountDao accountDao=new AccountDaoImpl();

	@Override
	public boolean saveAccount(Account account) {
		return accountDao.saveAccount(account);
		
	}

	@Override
	public Account getAccountId(long accn_no) {
		return accountDao.getAccountId(accn_no);
	}

	@Override
	public List<Account> getAllAccount() {
		return accountDao.getAllAccount();
	}

	@Override
	public boolean updateAccountId(Account account, long accn_no) {
		
		return accountDao.updateAccountId(account, accn_no);
	}

	@Override
	public boolean removeAccountId(long accn_no) {
		return accountDao.removeAccountId(accn_no);
		
	}

	@Override
	public boolean withdrawAmount(long accn_no, double amount) {
		
		return accountDao.withdrawAmount(accn_no, amount);
	}
	
	public boolean depositeAmount(long accn_no,double amount) {
		return accountDao.depositeAmount(accn_no, amount);
	}
	public boolean transferAmount(long fromAccnNo, long toAccnNo, double amount) {
		return accountDao.transferAmount(fromAccnNo, toAccnNo, amount);
	}
}
