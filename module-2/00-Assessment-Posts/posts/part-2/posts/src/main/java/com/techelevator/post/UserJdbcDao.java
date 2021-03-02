package com.techelevator.post;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class UserJdbcDao implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public UserJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// To insert a date into a prepared statement, wrap the date in
	// `Date.valueOf()`
	// method: `Date.valueOf(myObject.getCreated())`

	@Override
	public void save(User newUser) {
		
		String saveUser = "INSERT into USERS (id, first_name, last_name, email, role, created) " +
						  "VALUES(?, ?, ?, ?, ?, ?)";
		
		newUser.setId(GetNextUserID());
		
		jdbcTemplate.update(saveUser, newUser.getId(), newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), newUser.getRole(), Date.valueOf(newUser.getCreated()));

	}

	@Override
	public List<User> getAllUsers() {
		List<User> listOfUsers = new ArrayList();
		
		User aUser = null;
		
		String sqlAllUsers = "SELECT id, first_name, last_name, email, role, created " + 
							 "FROM users";
		
		SqlRowSet allUsers = jdbcTemplate.queryForRowSet(sqlAllUsers);
		
		while(allUsers.next()) {
			aUser = mapRowToUser(allUsers);
			listOfUsers.add(aUser);
		}
		return listOfUsers;
	}

	private User mapRowToUser(SqlRowSet results) {
		User userRow = new User();
		userRow.setId(results.getLong("id"));
		userRow.setFirstName(results.getString("first_name"));
		userRow.setLastName(results.getString("last_name"));
		userRow.setEmail(results.getString("email"));
		userRow.setRole(results.getString("role"));
		userRow.setCreated(results.getDate("created").toLocalDate());
		return userRow;
	}
	
	public long GetNextUserID() {
		
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('users_id_seq')");
		
		if(nextIdResult.next()) {               
			return nextIdResult.getLong(1);    
		} else {                               
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}

}
