package com.revature.dao;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {

	public Employee getEmployeebyCredentials(String username, String password);
	public Employee getEmployeeById(int id);
	
	public List<Employee> getEmployees();
	
	public String updateEmpUsername(int empId, String username);
	public String updateEmpPassword(int empId, String password);
	
	public Employee deleteEmployee(int empId);
	
	public Employee getIsManager(String username);
	
}
