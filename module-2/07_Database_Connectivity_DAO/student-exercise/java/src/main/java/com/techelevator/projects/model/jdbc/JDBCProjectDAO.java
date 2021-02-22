package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		List<Project> listOfProjects = new ArrayList<Project>();
		
		String sqlGetAllActiveProjects = "select project_id, name, from_date, to_date " +
				                         "from project " +
				                         "where from_date is not null " +
				                         "and to_date is null";
		
		SqlRowSet projectsReturned = jdbcTemplate.queryForRowSet(sqlGetAllActiveProjects);
		
		while(projectsReturned.next()) {
			Project aProject = MapRowToProject(projectsReturned);
			listOfProjects.add(aProject);
		}
		
		return listOfProjects;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		
		String deleteEmployee = "delete from project_employee where project_id = ? and employee_id = ?";
		
		jdbcTemplate.update(deleteEmployee, projectId, employeeId);
		
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		
		String addEmployee = "INSERT into project_employee(project_id, employee_id) " +
						     "VALUES(?, ?)";
		
		jdbcTemplate.update(addEmployee, projectId, employeeId);
	}
	
	private Project MapRowToProject(SqlRowSet theRows) {
		Project aProject = new Project();
		
		aProject.setProjectId(theRows.getLong("project_id"));
		aProject.setName(theRows.getString("name"));
		aProject.setToDate(theRows.getDate("to_date"));
		aProject.setFromDate(theRows.getDate("from_date"));
		
		
		return aProject;
	}

}
