package com.revature.beans;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	
	public Reimbursement(int employeeId, String firstname, String lastname, int managerId) {
		super();
		this.employeeId = employeeId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.managerId = managerId;
	}

	public Reimbursement() {
		super();
	}
	private int reimId;
	private int employeeId;
	private Blob image;
	private double amount;
	private String dateTime;
	private int managerId;
	private int status;
	private String firstname;
	private String lastname;
	private String purpose;
	
	
	

	public Reimbursement(int reimId,int employeeId, Blob image, double amount, String dateTime, int managerId, int status) {
		super();
		this.reimId = reimId;
		this.employeeId = employeeId;
		this.image = image;
		this.amount = amount;
		this.dateTime = dateTime;
		this.managerId = managerId;
		this.status = status;
	}
	
	public Reimbursement(int reimId, int employeeId, int managerId, String firstname, String lastname, int status, double amount, String purpose) {
		this.reimId = reimId;
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.status = status;
		this.amount = amount;
		this.purpose = purpose;
		
	}

	public int getEmployeeId() {return employeeId;}
	public void setEmployeeId(int employeeId) {this.employeeId = employeeId;}
	
	public Blob getImage() {return image;}
	public void setImage(Blob image) {this.image = image;}
	
	public double getAmount() {return amount;}
	public void setAmount(double amount) {this.amount = amount;}
	
	public String getDateTime() {return dateTime;}
	public void setDateTime(String dateTime) {this.dateTime = dateTime;}
	
	public int getManagerId() {return managerId;}
	public void setManagerId(int managerId) {this.managerId = managerId;}
	
	public int getStatus() {return status;}
	public void setStatus(int status) {this.status = status;}
	
	public int getReimId() {return reimId;}
	public void setReimId(int reimId) {this.reimId = reimId;}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime * result + employeeId;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + managerId;
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + reimId;
		result = prime * result + status;
		return result;
	}

	

	public String getFirstname() {return firstname;}
	public void setFirstname(String firstname) {this.firstname = firstname;}

	public String getLastname() {return lastname;}
	public void setLastname(String lastname) {this.lastname = lastname;}

	public String getPurpose() {return purpose;}
	public void setPurpose(String purpose) {this.purpose = purpose;}

	@Override
	public String toString() {
		return "Reimbursement [reimId=" + reimId + ", employeeId=" + employeeId + ", image=" + image + ", amount="
				+ amount + ", dateTime=" + dateTime + ", managerId=" + managerId + ", status=" + status + ", firstname="
				+ firstname + ", lastname=" + lastname + ", purpose=" + purpose + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (managerId != other.managerId)
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (reimId != other.reimId)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	
	
	
	
	
	
}
