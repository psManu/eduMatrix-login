package com.psmanu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class InstituteManagementDAOImpl implements InstituteManagementDAO{

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate db;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.db = new JdbcTemplate(dataSource);
	}
	
	
	
	public Institute getInstituteNameById(int inst_id) {
		
		String sql = "SELECT * FROM institutes WHERE inst_id=?";
		return db.queryForObject(sql, new Object[] {inst_id}, new InstituteMapper());
		
	}
	
	@Override
	public List<Institute> fetchAllInstitutes() {
		
		return db.query("SELECT * FROM institutes", new InstituteMapper());
	}
	
	private static final class InstituteMapper implements RowMapper<Institute> {
		
	    public Institute mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Institute institute = new Institute();
	        institute.setInstId(rs.getInt("inst_id"));
	        institute.setInstName(rs.getString("inst_name"));
	        institute.setInstCity(rs.getString("inst_city"));
	        return institute;
	    }
	}

	

}
