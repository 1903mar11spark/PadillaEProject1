package com.revature.dao;

import java.io.InputStream;
import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {

	public boolean createReimbursement(int employeeId, int managerId, String purpose, double amount);
	public List<Reimbursement> getEmplReimbursements(int emplId);
	public List<Reimbursement> getManReimbursements();
	public Reimbursement updateStatus(int reimId, int status);
	public Reimbursement updateAmount(int reimId, double amount);
	
}
