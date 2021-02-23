package com.techelevator;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;


import com.techelevator.projects.model.Employee;

import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

public class TestJDBCEmployeeDAO {
	private static SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;
	private JDBCProjectDAO daoProject;
	private JDBCDepartmentDAO daoDepartment;
	private static final String TEST_EMPLOYEE_FIRST_NAME = "Greg";
	private static final String TEST_EMPLOYEE_LAST_NAME = "Gregerson";
	
	
	
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
		Date hire_date = Date.valueOf("2018-03-01");
		Date birth_date = Date.valueOf("2000-03-01");
		String sqlInsertDepartment = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) "
				+ "Values(100, 2, ?, ?, ?, ?, ? )";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertDepartment, TEST_EMPLOYEE_FIRST_NAME, TEST_EMPLOYEE_LAST_NAME, birth_date, "M", hire_date);
		dao = new JDBCEmployeeDAO(dataSource);
		daoProject = new JDBCProjectDAO(dataSource);
		daoDepartment = new JDBCDepartmentDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void testGetAllEmployee() {
		List<Employee> results = dao.getAllEmployees();
		Assert.assertNotNull(results);
		Assert.assertEquals(13, results.size());
	}
	
	@Test 
	public void testSearchEmployeesByName() {
		List<Employee> results = dao.searchEmployeesByName("Greg", "Gregerson");
		Assert.assertNotNull(results);
		Assert.assertEquals("Greg", results.get(0).getFirstName());
		Assert.assertEquals("Gregerson", results.get(0).getLastName());
	}
	
	@Test
	public void testGetEmployeesWithoutProject() {
		List<Employee> results = dao.getEmployeesWithoutProjects();
		Assert.assertNotNull(results);
		Assert.assertEquals(3, results.size());
	}
	
	@Test
	public void testGetEmployeeByDepartmentIds() {
		List<Employee> results = dao.getEmployeesByDepartmentId(dao.searchEmployeesByName("Greg", "Gregerson").get(0).getDepartmentId());
		Assert.assertNotNull(results);
		Assert.assertEquals(4, results.size());
	}
	
	@Test 
	public void testGetEmployeesByProjectId() {
		List<Employee> results = dao.getEmployeesByProjectId(daoProject.getAllActiveProjects().get(0).getProjectId());
		Assert.assertNotNull(results);
		Assert.assertEquals(3, results.size());
	}
	
	@Test
	public void testChangeEmployeeDepartment() {
	
	dao.changeEmployeeDepartment((dao.searchEmployeesByName("Greg", "Gregerson").get(0).getEmployeeId()), daoDepartment.getAllDepartments().get(0).getDepartmentId());
	
	Long gregDeptID = dao.searchEmployeesByName("Greg", "Gregerson").get(0).getDepartmentId();
	Long dep0ID = daoDepartment.getAllDepartments().get(0).getDepartmentId();
	Assert.assertEquals(gregDeptID, dep0ID);
		
	}
	
}

