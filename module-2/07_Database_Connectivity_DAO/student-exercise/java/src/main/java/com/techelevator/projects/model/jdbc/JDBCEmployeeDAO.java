package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		
		Employee anEmployee = null;
		
		String sqlGetAllEmployees = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date FROM Employee";
		
		SqlRowSet returnedListOfEmployees = jdbcTemplate.queryForRowSet(sqlGetAllEmployees);
		
		while(returnedListOfEmployees.next()) {
			anEmployee = MapRowToEmployee(returnedListOfEmployees);
			listOfEmployees.add(anEmployee);
		}

		return listOfEmployees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		
		ArrayList<Employee> listOfEmployees = new ArrayList<Employee>();
		
		String firstNameAdapted;
		String lastNameAdapted;
		
		if(firstNameSearch.equals("")) {
			firstNameAdapted = "";
		} else {
			firstNameAdapted = ("%" + firstNameSearch + "%");
		}
		
		if (lastNameSearch.equals("")) {
			lastNameAdapted = "";
			
		} else {
			lastNameAdapted = ("%" + lastNameSearch + "%");
		}
		
		String searchAllEmployeesSQL = ("select last_name, first_name, employee_id from employee where upper(first_name) like upper('"+firstNameAdapted+"') or upper(last_name) like upper('"+lastNameAdapted+"') order by last_name");

		SqlRowSet theEmployees = jdbcTemplate.queryForRowSet(searchAllEmployeesSQL);
		
		while(theEmployees.next()) {
			Employee anEmployee = MapRowToEmployee(theEmployees);
			listOfEmployees.add(anEmployee);
		}
		
		return listOfEmployees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		
		Employee anEmployee = null;
		
		String sqlGetEmployeesById = "SELECT employee.employee_id, employee.department_id, employee.first_name, employee.last_name, employee.birth_date, employee.gender, employee.hire_date FROM employee where employee.department_id = ?";
		
		SqlRowSet returnedListOfEmployees = jdbcTemplate.queryForRowSet(sqlGetEmployeesById, id);
		
		if(returnedListOfEmployees.next()) {
			anEmployee = MapRowToEmployee(returnedListOfEmployees);
			listOfEmployees.add(anEmployee);
		} else { 
			throw new RuntimeException("Something went wrong");
		}
		
		return listOfEmployees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		
		Employee anEmployee = null;
		
		String sqlGetListOfEmployees = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date FROM employee " +
				                       "left join project_employee " +
				                       "on employee.employee_id = project_employee.employee_id " +
				                       "where project_employee.employee_id is null";
		
		SqlRowSet listOfEmployeesReturned = jdbcTemplate.queryForRowSet(sqlGetListOfEmployees);
		
		while(listOfEmployeesReturned.next()) {
			anEmployee = MapRowToEmployee(listOfEmployeesReturned);
			listOfEmployees.add(anEmployee);
		}
		
		return listOfEmployees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		
		Employee anEmployee = null;
		
		String sqlGetListOfEmployees = "SELECT employee.employee_id, employee.department_id, employee.first_name, employee.last_name, employee.birth_date, employee.gender, employee.hire_date " +
		                               "FROM employee " +
				                       "inner join project_employee " +
				                       "on employee.department_id = project_employee.employee_id " +
				                       "inner join project " +
				                       "on project_employee.project_id = project.project_id " +
				                       "where project.project_id = ?";
		
		SqlRowSet returnedListOfEmployees = jdbcTemplate.queryForRowSet(sqlGetListOfEmployees, projectId);
		
		while(returnedListOfEmployees.next()) {
			anEmployee = MapRowToEmployee(returnedListOfEmployees);
			listOfEmployees.add(anEmployee);
		}
		
		return listOfEmployees;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		
		String sqlChangeEmployeeDepartment = "UPDATE employee set department_id = ? WHERE employee_id = ?";
		
		jdbcTemplate.update(sqlChangeEmployeeDepartment, departmentId, employeeId);
	}
	
	private Employee MapRowToEmployee(SqlRowSet theRows) {
		
		Employee anEmployee = new Employee();
		
		anEmployee.setEmployeeId(theRows.getLong("employee_id"));
		anEmployee.setDepartmentId(theRows.getLong("department_id"));
		anEmployee.setFirstName(theRows.getString("first_name"));
		anEmployee.setLastName(theRows.getString("last_name"));
		anEmployee.setBirthDate(theRows.getDate("birth_date"));
		anEmployee.setGender(theRows.getString("gender"));
		anEmployee.setHireDate(theRows.getDate("hire_date"));
		
		
		return anEmployee;
	}

}
