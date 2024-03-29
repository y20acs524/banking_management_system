package com.banking.daoimplementation;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.banking.dao.BranchDao;
import com.banking.entity.Branch;
import com.banking.util.HibernateUtil;

public class BranchDaoImpl implements BranchDao{

	@Override
	public boolean savebranch(Branch branch) {
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			session.save(branch);
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
	public Branch getBranchId(int branch_id) {
		try(Session session=HibernateUtil.getSession()){
			Branch branch=session.get(Branch.class,branch_id);
			return branch;
		}
	}

	@Override
	public List<Branch> getAllBranch() {
		try(Session session=HibernateUtil.getSession()){
			List<Branch> listBranch=session.createQuery("from Branch",Branch.class).getResultList();
			return listBranch;
		}
		
	}

	@Override
	public boolean updateBranchId(Branch branch, int branch_id) {
		try(Session session=HibernateUtil.getSession()){
			Branch branch1=session.get(Branch.class,branch_id);
			
			branch1.setBranch_id(branch_id);
			branch1.setBranch_name(branch.getBranch_name());
			branch1.setIfsc_code(branch.getIfsc_code());
			branch1.setBranch_address(branch.getBranch_address());
			branch1.setRecord_status('A');
			session.beginTransaction();
			session.saveOrUpdate(branch1);
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
	public boolean removeBranchId(int branch_id) {
		try(Session session=HibernateUtil.getSession()){
			session.beginTransaction();
			Branch branch=session.get(Branch.class,branch_id);
			
			if(branch!=null) {
				branch.setRecord_status('I');
				session.saveOrUpdate(branch);
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
