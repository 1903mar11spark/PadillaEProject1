package com.revature.dao;

import java.io.InputStream;
import java.util.List;

import com.revature.beans.ManagerService;

public interface ManagerServiceDAO {
	
	public ManagerService createService(int managerId, int reimId, int decision);
	public List<ManagerService> getDecisions();
	

}
