package com.banking.services;

import java.util.List;

import com.banking.entity.Branch;

public interface BranchService {

	public boolean savebranch(Branch branch);
	public Branch getBranchId(int branch_id);
	public List<Branch> getAllBranch();
	public boolean updateBranchId(Branch branch,int branch_id);
	public boolean removeBranchId(int branch_id);
	
}
