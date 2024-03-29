package com.test.bank;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.banking.entity.Branch;
import com.banking.serviceimplementation.BranchServiceImpl;
import com.banking.services.BranchService;
import com.banking.util.HibernateUtil;

class TestBranchServ {

	static SessionFactory sessionFactory;
	static Session session;
	static BranchService branchService;
	@BeforeAll
	static void setUpTest() {
		sessionFactory=HibernateUtil.getSessionFactory();
		branchService=new BranchServiceImpl();
	}
	/*@Test
	void testCreateBranch() {
		Branch branch=new Branch(105,"sbikkd","SBI8383567","kakinada");
		assertTrue(branchService.savebranch(branch),"branch created successfully");
	}

	@Test
	void testGetById() {
		int id=104;
		Branch branch=branchService.getBranchId(id);
		assertNotNull(branch);
		assertEquals(id,branch.getBranch_id());
		}
	@Test
	void testGetAll() {
		equals(branchService.getAllBranch());
	}
	@Test
	void testUpdatedById() {
		int id=105;
		Branch branch=new Branch(id);
		branch.setBranch_id(id);
		branch.setBranch_name("sbirjy");
		branch.setIfsc_code("SBI921764");
		branch.setBranch_address("rajahmundry");
		
		assertTrue(branchService.updateBranchId(branch, id),"data updated successfully");
	}*/
	@Test
	void testDeleteById() {
		int id=105;
		assertTrue(branchService.removeBranchId(id));
	}
	@AfterAll
	static void tearDown() {
		sessionFactory.close();
	}

}
