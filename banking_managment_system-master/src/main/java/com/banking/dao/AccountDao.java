package com.banking.dao;

import java.util.List;

import com.banking.entity.Account;

public interface AccountDao {

	public boolean saveAccount(Account account);
	public Account getAccountId(long accn_no);
	public List<Account> getAllAccount();
	public boolean updateAccountId(Account account,long accn_no);
	public boolean removeAccountId(long accn_no);
	
	public boolean withdrawAmount(long accn_no,double amouunt);
	public boolean depositeAmount(long accn_no,double amount);
	public boolean transferAmount(long fromAccnNo, long toAccnNo, double amount);
}
