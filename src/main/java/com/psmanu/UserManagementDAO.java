package com.psmanu;

public interface UserManagementDAO {

	public User getUserAuthenticated(int instId, String username, String password);

}
