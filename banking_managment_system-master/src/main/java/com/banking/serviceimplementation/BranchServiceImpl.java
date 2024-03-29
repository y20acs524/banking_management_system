package com.banking.serviceimplementation;

import java.util.List;

import com.banking.dao.BranchDao;
import com.banking.daoimplementation.BranchDaoImpl;
import com.banking.entity.Branch;
import com.banking.services.BranchService;

public class BranchServiceImpl implements BranchService{

	BranchDao branchDao=new BranchDaoImpl();
	@Override
	public boolean savebranch(Branch branch) {
		return branchDao.savebranch(branch);
		
	}

	@Override
	public Branch getBranchId(int branch_id) {
		return branchDao.getBranchId(branch_id);
	}

	@Override
	public List<Branch> getAllBranch() {
		return branchDao.getAllBranch();
	}

	@Override
	public boolean updateBranchId(Branch branch, int branch_id) {
		return branchDao.updateBranchId(branch, branch_id);
	}

	@Override
	public boolean removeBranchId(int branch_id) {
		return branchDao.removeBranchId(branch_id);
		
	}

}
