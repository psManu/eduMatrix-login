package com.psmanu;

public class Institute {
	
	private int instId;
	private String instName;
	private String managerId;
	private String instCity;
	
	
	public Institute() {
		
	}
	
	public Institute(int instId, String instName, String managerId, String instCity) {
		super();
		this.instId = instId;
		this.instName = instName;
		this.managerId = managerId;
		this.setInstCity(instCity);	
	}
	public int getInstId() {
		return instId;
	}
	public void setInstId(int instId) {
		this.instId = instId;
	}
	public String getInstName() {
		return instName;
	}
	public void setInstName(String instName) {
		this.instName = instName;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getInstCity() {
		return instCity;
	}

	public void setInstCity(String instCity) {
		this.instCity = instCity;
	}
	
	

}
