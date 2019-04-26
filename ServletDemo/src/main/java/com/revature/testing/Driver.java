package com.revature.testing;

import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimbursementDAOImpl;

public class Driver {

	public static void main(String[] args) {
		

		EmployeeDAOImpl emplDAO = new EmployeeDAOImpl();
		ReimbursementDAOImpl reimDAO = new ReimbursementDAOImpl();
		

		//System.out.println(emplDAO.getEmployeebyCredentials("Padilla157", "12345"));
		//System.out.println(reimDAO.getEmplReimbursements(1));
		//System.out.println(emplDAO.getIsManager("Padilla157"));
		System.out.println(emplDAO.getEmployees());

	}

}
