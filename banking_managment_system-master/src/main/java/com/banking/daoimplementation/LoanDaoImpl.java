package com.banking.daoimplementation;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.banking.dao.LoanDao;
import com.banking.entity.Loan;
import com.banking.util.HibernateUtil;

public class LoanDaoImpl implements LoanDao {

	@Override
	public boolean saveLoan(Loan loan) {
		try (Session session = HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(loan);
			session.getTransaction().commit();

			return true;
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public Loan getLoanId(int loan_id) {
		try (Session session = HibernateUtil.getSession()) {
			Loan loan = session.get(Loan.class, loan_id);
			return loan;
		}

	}

	@Override
	public List<Loan> getAllLoan() {
		try (Session session = HibernateUtil.getSession()) {
			List<Loan> listLoan = session.createQuery("from Loan", Loan.class).getResultList();
			return listLoan;
		}

	}

	@Override
	public boolean updateLoanId(Loan loan, int loan_id) {
		try (Session session = HibernateUtil.getSession()) {
			Loan loan1 = session.get(Loan.class, loan_id);
			loan1.setLoan_id(loan_id);
			loan1.setLoan_type(loan.getLoan_type());
			loan1.setDate_of_loan(loan.getDate_of_loan());
			loan1.setLoan_amount(loan.getLoan_amount());
			loan1.setMax_years(loan.getMax_years());
			loan1.setRecord_status('A');
			loan1.setCustomer(loan.getCustomer());

			session.beginTransaction();
			session.saveOrUpdate(loan1);
			session.getTransaction().commit();

			return true;
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean removeLoanId(int loan_id) {
		try (Session session = HibernateUtil.getSession()) {
			Loan loan = session.get(Loan.class, loan_id);

			session.beginTransaction();
			if (loan != null) {
				loan.setRecord_status('I');
				session.saveOrUpdate(loan);
				session.getTransaction().commit();
			}
			return true;
		} catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public List<Loan> getAllActiveLoans(){
		try (Session session = HibernateUtil.getSession()) {
		Query query=session.createQuery("SELECT l from Loan l WHERE l.record_status='A'");
		
		return query.getResultList();
		}
		catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public double getLoanAmountByLoanType(String loanType) {
		try (Session session = HibernateUtil.getSession()) {
			Query query=session.createQuery("SELECT SUM(l.loan_amount) FROM Loan l WHERE l.loan_type=:loanType");
			query.setParameter("loanType",loanType);
			return (double) query.getSingleResult();
		}
		catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@Override
	public long getLaonCount() {
		try (Session session = HibernateUtil.getSession()) {
			Query query=session.createQuery("SELECT COUNT(*) FROM Loan");
			return (long) query.getSingleResult();
		}
		catch (HibernateException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

}
