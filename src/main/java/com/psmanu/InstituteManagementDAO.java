package com.psmanu;

import java.util.List;

public interface InstituteManagementDAO {

	public Institute getInstituteNameById(int inst_id);
	public List<Institute> fetchAllInstitutes();
}
