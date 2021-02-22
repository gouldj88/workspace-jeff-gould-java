package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<Department> getAllDepartments() {
		List<Department> listOfDepartments = new ArrayList<Department>();
		
		Department aDepartment = null;
		
		String getAllDepartmentsSQL = "SELECT department_id, name FROM department";
		
		
		SqlRowSet theDepartments = jdbcTemplate.queryForRowSet(getAllDepartmentsSQL); // since there are no placeholders in the SQL, nothing else is coded.
		
		while(theDepartments.next()) {
			aDepartment = MapRowToDepartment(theDepartments);  // Note MapRowToDepartment needs to be written
			listOfDepartments.add(aDepartment);
				
			}
		
		return listOfDepartments;
		}
		
		
	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		
		List<Department> namesList = new ArrayList<Department>();
		
		Department aDepartment = null;
		
		String departmentNameSql = "SELECT department_id, name FROM department where name = ?";
		
		SqlRowSet departmentNames = jdbcTemplate.queryForRowSet(departmentNameSql, nameSearch);
		
		if(departmentNames.next()) {
			aDepartment = MapRowToDepartment(departmentNames);
			namesList.add(aDepartment);
		}
		return namesList;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		
		String insertDepartment = "UPDATE department set name = ? where department_id = ?";
		
		jdbcTemplate.update(insertDepartment, updatedDepartment.getName(), updatedDepartment.getDepartmentId());
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		
		String insertDepartment = "INSERT INTO Department(department_id, name) " +
							      "VALUES(?, ?)";
		
		newDepartment.setDepartmentId(GetNextDepartmentID());
	
		jdbcTemplate.update(insertDepartment, newDepartment.getDepartmentId(),
										      newDepartment.getName());
		
		
		
		Department newCreatedDepartment = newDepartment;
		
		return newCreatedDepartment;
	}

	@Override
	public Department getDepartmentById(Long id) {
		
		Department aDepartment = null;
		
		String sqlGetDepartmentById = "SELECT department_id, name FROM department where department_id = ?";
		
		SqlRowSet departmentById = jdbcTemplate.queryForRowSet(sqlGetDepartmentById, id);
		
		
		if(departmentById.next()) {
			aDepartment = MapRowToDepartment(departmentById);
		}
		
		return aDepartment;

	}
	
	public Department MapRowToDepartment(SqlRowSet theRows) {
		
		Department aDepartment = new Department();
		
		aDepartment.setDepartmentId(theRows.getLong("department_id"));
		aDepartment.setName(theRows.getString("name"));
		
		return aDepartment;
	}
	
	public long GetNextDepartmentID() {
		
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		
		if(nextIdResult.next()) {               // if the SQLRowSet called nextIDResult has any data, move to the next line of data
			return nextIdResult.getLong(1);     // get the long value in column 1 of the line and return it
		} else {                                // if there is no data in nextIDResult, throw a RuntimeException
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}
	
}
