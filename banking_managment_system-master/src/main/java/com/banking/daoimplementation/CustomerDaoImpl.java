package com.banking.daoimplementation;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.banking.dao.CustomerDao;
import com.banking.entity.Customer;
import com.banking.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public boolean saveCustomer(Customer customer) {
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(customer);
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
	public Customer getCustomerId(int cust_id) {
		try(Session session=HibernateUtil.getSession()){
			Customer customer=session.get(Customer.class,cust_id);
			return customer;
		}
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		try(Session session=HibernateUtil.getSession()){
			List<Customer> listCustomer=session.createQuery("from Customer",Customer.class).getResultList();
			return listCustomer;
		}
		
	}

	@Override
	public boolean updatecustomerId(Customer customer, int cust_id) {
		try(Session session=HibernateUtil.getSession()){
			
			Customer customer1=session.get(Customer.class,cust_id);
			
			customer1.setCust_id(cust_id);
			customer1.setCust_name(customer.getCust_name());
			customer1.setCust_phoneNo(customer.getCust_phoneNo());
			customer1.setCust_addr(customer.getCust_addr());
			customer1.setRecord_status('A');
			
			session.beginTransaction();
			session.saveOrUpdate(customer1);
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
	public boolean removeCustomerId(int cust_id) {
		try(Session session=HibernateUtil.getSession()){
			Customer customer=session.get(Customer.class,cust_id);
			
			session.beginTransaction();
			if(customer!=null) {
				customer.setRecord_status('I');
				session.saveOrUpdate(customer);
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

}
