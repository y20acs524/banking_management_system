package com.banking.app;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.banking.util.HibernateUtil;


public class BankingApp {
public static void main(String[] args) {
	
	SessionFactory factory=HibernateUtil.getSessionFactory();
	
	Session session=factory.openSession();
	
	Transaction tx=session.beginTransaction();
	MainOperations.mainOper();
	session.getTransaction().commit();
}
}
