package com.psmanu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private UserManagementDAO userManagementDAO;
	
	public User getUserAuthenticated(int instId, String username, String password) {
		
		return userManagementDAO.getUserAuthenticated(instId, username, password);
	}

}
