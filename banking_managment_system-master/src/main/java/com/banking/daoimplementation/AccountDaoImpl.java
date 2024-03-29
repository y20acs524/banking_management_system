package com.banking.daoimplementation;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.banking.dao.AccountDao;
import com.banking.entity.Account;
import com.banking.util.HibernateUtil;

public class AccountDaoImpl implements AccountDao{

	@Override
	public boolean saveAccount(Account account) {
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(account);
			session.getTransaction().commit();
			
			return true;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	}

	@Override
	public Account getAccountId(long accn_no) {
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			Account account=session.get(Account.class,accn_no);
			return account;
		}
	}

	@Override
	public List<Account> getAllAccount() {
		try(Session session=HibernateUtil.getSession()){
			List<Account> listAccn=session.createQuery("from Account",Account.class).getResultList();
			return listAccn;
		}
	}

	@Override
	public boolean updateAccountId(Account account, long accn_no) {
		try(Session session=HibernateUtil.getSession()){
			
			Account account1=session.get(Account.class,accn_no);
			
			account1.setAccn_no(accn_no);
			account1.setAccn_type(account.getAccn_type());
			account1.setAccn_date(account.getAccn_date());
			account1.setAccn_balance(account.getAccn_balance());
			account1.setRecord_status('A');
			account1.setCustomer(account.getCustomer());
			
			session.beginTransaction();
			session.saveOrUpdate(account1);
			session.getTransaction().commit();
			
			return true;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	}

	@Override
	public boolean removeAccountId(long accn_no) {
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			Account account=session.get(Account.class,accn_no);
			if(account!=null) {
				account.setRecord_status('I');
				session.saveOrUpdate(account);
				session.getTransaction().commit();
			}
			
			return true;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean withdrawAmount(long accn_no, double amount) {
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			Account account=session.get(Account.class, accn_no);
			if(account.getRecord_status()!='I'&&account.getAccn_balance()>=amount) {
				account.setAccn_no(accn_no);
				account.setAccn_balance(account.getAccn_balance()-amount);
				session.saveOrUpdate(account);
				session.getTransaction().commit();
				return true;
			}
			else {
				System.out.println("Account does not exist");
			}
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean depositeAmount(long accn_no, double amount) {
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			Account account=session.get(Account.class, accn_no);
			if(account.getRecord_status()!='I') {
				account.setAccn_no(accn_no);
				account.setAccn_balance(account.getAccn_balance()+amount);
				session.saveOrUpdate(account);
				session.getTransaction().commit();
				return true;
			}
			else {
				System.out.println("account does not exist");
			}
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public boolean transferAmount(long fromAccnNo, long toAccnNo, double amount) {
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			Account fromAccount=session.get(Account.class,fromAccnNo);
			Account toAccount=session.get(Account.class,toAccnNo);
			if(fromAccount!=null && toAccount!=null && fromAccount.getAccn_balance()>=amount) {
				fromAccount.setAccn_balance(fromAccount.getAccn_balance()-amount);
				session.saveOrUpdate(fromAccount);
				
				//credit account
				toAccount.setAccn_balance(toAccount.getAccn_balance()+amount);
				session.saveOrUpdate(toAccount);
				session.getTransaction().commit();
				return true;
			}
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return false;
		
	}
	

}
