package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.exceptions.UsernameTakenException;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	public Employee getEmployeebyCredentials(String username, String password) {

		Employee employee = new Employee();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME = ? AND"
					+ " PASS_WORD = ?";
			
			PreparedStatement pstmt  = con.prepareStatement(sql);
			
			//Set value of the '?' to the value of parameters 
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int emp = rs.getInt("EMPLOYEE_ID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String user = rs.getString("USERNAME");
				String pass = rs.getString("PASS_WORD");
				employee = new Employee(emp, firstname, lastname, user,pass);
				
				System.out.println(employee + "dao emp");
				
//				employee.setId(rs.getInt("EMPLOYEE_ID"));
//				employee.setFirstName(rs.getString("FIRSTNAME"));
//				employee.setLastName(rs.getString("LASTNAME"));
//				employee.setUserName(rs.getString("USERNAME"));
//				employee.setPassWord(rs.getString("PASS_WORD"));
			}
			
	} catch (SQLException | IOException e){
		e.printStackTrace();
	}
		return employee;
	}

	public Employee updateEmployee(Employee employee) {
		
		employee = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			//String sql = "UPDATE EMPLOYEE SET"
			
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}

	public Employee getEmployeeById(int id) {
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			
			String sql = "SELECT EMPLOYEE_ID FROM EMPLOYEE";
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee updateEmpUsername(int empId, String username) {
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			
			String sql = "UPDATE EMPLOYEE SET USERNAME = ? "
					+ "WHERE EMPLOYEE_ID = ?";
			
			PreparedStatement pstmt  = con.prepareStatement(sql);
			
			//Set value of the '?' to the value of parameters 
			pstmt.setString(1, username);
			pstmt.setInt(2, empId);
			
			pstmt.executeUpdate();
			con.close();
			
	} catch (SQLException | IOException e){
		e.printStackTrace();
	}
		return null;
	}

	@Override
	public Employee updateEmpPassword(int empId, String password) {
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
		
			String sql = "UPDATE EMPLOYEE SET PASS_WORD = ? "
					+ "WHERE EMPLOYEE_ID = ?";
			
			PreparedStatement pstmt  = con.prepareStatement(sql);
			
			//Set value of the '?' to the value of parameters 
			pstmt.setString(1, password);
			pstmt.setInt(2, empId);
			
			pstmt.executeUpdate();
			con.close();
			
	} catch (SQLException | IOException e){
		e.printStackTrace();
	}
		return null;
	}

	@Override
	public Employee deleteEmployee(int empId) {
		
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		
		return null;
	}

}
