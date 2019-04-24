package com.revature.beans;

public class ManagerService {
	
	public ManagerService() {
		super();
	}

	private int managerId;
	private int reimId;
	private int decision;
	private String datetime;
	
	public ManagerService(int managerId, int reimId, int decision, String datetime) {
		super();
		this.managerId = managerId;
		this.reimId = reimId;
		this.decision = decision;
		this.datetime = datetime;
	}

	
	public int getManagerId() {return managerId;}
	public void setManagerId(int managerId) {this.managerId = managerId;}
	
	public int getReimId() {return reimId;}
	public void setReimId(int reimId) {this.reimId = reimId;}
	
	public int getDecision() {return decision;}
	public void setDecision(int decision) {this.decision = decision;}
	
	public String getDatetime() {return datetime;}
	public void setDatetime(String datetime) {this.datetime = datetime;}
	
	@Override
	public String toString() {
		return "ManagerService [managerId=" + managerId + ", reimId=" + reimId + ", decision=" + decision
				+ ", datetime=" + datetime + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datetime == null) ? 0 : datetime.hashCode());
		result = prime * result + decision;
		result = prime * result + managerId;
		result = prime * result + reimId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManagerService other = (ManagerService) obj;
		if (datetime == null) {
			if (other.datetime != null)
				return false;
		} else if (!datetime.equals(other.datetime))
			return false;
		if (decision != other.decision)
			return false;
		if (managerId != other.managerId)
			return false;
		if (reimId != other.reimId)
			return false;
		return true;
	}
	
	

}
