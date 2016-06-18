package com.psmanu;

public class User {
	
	private int userId;
	private String userName;
	private String name;
	private int instId;
	private String schemaName;
	private String authLevel;
	
	
	
	public User() {
		
	}
	public User(int userId, String userName, String name, int instId, String schemaName, String authLevel) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.instId = instId;
		this.schemaName = schemaName;
		this.setAuthLevel(authLevel);
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInstId() {
		return instId;
	}
	public void setInstId(int instId) {
		this.instId = instId;
	}
	public String getSchemaName() {
		return schemaName;
	}
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	public String getAuthLevel() {
		return authLevel;
	}
	public void setAuthLevel(String authLevel) {
		this.authLevel = authLevel;
	}
	

}
