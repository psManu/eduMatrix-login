package com.psmanu;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserManagementDAOImpl implements UserManagementDAO{

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate db;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.db = new JdbcTemplate(dataSource);
	}
	
	public User getUserAuthenticated(int instId, String username, String password) {
		
		String sql = "SELECT COUNT(*) FROM useraccounts WHERE inst_id=? AND username=? AND password=?";
		int userCount = db.queryForObject(sql, Integer.class, instId, username, password);
		if(userCount != 1){
			return null;
		}else{
			sql = "SELECT * FROM useraccounts WHERE inst_id=? AND username=? AND password=?";
			User user = db.queryForObject(sql, new Object[] {instId, username, password}, new UserMapper());
			user.setSchemaName(db.queryForObject("SELECT schema_name FROM institutes WHERE inst_id=?",
				       new Object[] {user.getInstId()}, 
				       String.class));
			sql = String.format("SELECT auth_level FROM %s.inst_useraccounts WHERE user_id=?", user.getSchemaName());
			user.setAuthLevel(db.queryForObject(sql,
					       new Object[] {user.getUserId()}, 
					       String.class));
			
			
			return user;
			
		} 
		
	}
	

	private static final class UserMapper implements RowMapper<User> {
	
	    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	        User user = new User();
	        user.setInstId(rs.getInt("inst_id"));
	        user.setName(rs.getString("user_name"));
	        user.setUserId(rs.getInt("user_id"));
	        user.setUserName(rs.getString("username"));
	        return user;
	    }
	}

}
