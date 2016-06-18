package com.psmanu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituteManagementServiceImpl implements InstituteManagementService {

	@Autowired
	private InstituteManagementDAO instituteManagementDAO;
	
	@Override
	public Institute getInstituteNameById(int inst_id) {
		
		return instituteManagementDAO.getInstituteNameById(inst_id);
	}

	@Override
	public List<Institute> fetchAllInstitutes() {
		
		return instituteManagementDAO.fetchAllInstitutes();
	}

}
