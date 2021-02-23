package com.techelevator;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;



public class TestJDBCProjectDAO {
	private static SingleConnectionDataSource dataSource;
	private JDBCProjectDAO dao;
	private JDBCEmployeeDAO daoEmployee;
	private static final String TEST_PROJECT = "Hang_Out";
	
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projectDAO");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		Date from_date = Date.valueOf("1433-03-01");
		Date to_date = Date.valueOf("2019-03-01");
		String sqlInsertProject = "INSERT INTO project (project_id, name, from_date, to_date) Values(100, ?, ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertProject, TEST_PROJECT, from_date, to_date);
		dao = new JDBCProjectDAO(dataSource);
		daoEmployee = new JDBCEmployeeDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void testGetAllActiveProjects() {
		List<Project> results = dao.getAllActiveProjects();
		Assert.assertNotNull(results);
		Assert.assertEquals(3, results.size());
		Assert.assertEquals("The Never-ending Project", results.get(0).getName());
	}
	
	
	@Test
	public void testAddAndRemoveEmployeeFromProject() {
		Long employeeID = daoEmployee.getAllEmployees().get(7).getEmployeeId();
		Long projectID = dao.getAllActiveProjects().get(0).getProjectId();
		int numBeforeAddingEmployee = daoEmployee.getEmployeesByProjectId(projectID).size();
		
		dao.addEmployeeToProject (projectID, employeeID);
		Assert.assertEquals(numBeforeAddingEmployee + 1, daoEmployee.getEmployeesByProjectId(projectID).size());
		dao.removeEmployeeFromProject(projectID, employeeID);
		Assert.assertEquals(numBeforeAddingEmployee, daoEmployee.getEmployeesByProjectId(projectID).size());
	}
}

