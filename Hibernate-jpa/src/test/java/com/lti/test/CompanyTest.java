package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.CompanyDao;
import com.lti.model.Department;
import com.lti.model.Employee;

public class CompanyTest {

	CompanyDao dao = new CompanyDao();

	@Test
	public void addADepartment() {
		Department department = new Department();
		department.setDepartmentName("Training");
		department.setLocation("Mahape");

		dao.addADepartment(department);
	}

	@Test
	public void addAnEmployee() {
		Employee emp = new Employee();
		emp.setEmployeeName("Simant");
		emp.setDesignation("Trainer");

		emp.setDepartment(dao.findADepartment(2003));
		dao.addAnEmployee(emp);
	}

	@Test
	public void addDeptwithEmp() {

		Department department = new Department();
		department.setDepartmentName("Finance");
		department.setLocation("Mumbai");

		List<Employee> employees = new ArrayList<Employee>();

		Employee emp1 = new Employee();
		emp1.setEmployeeName("Nikhil");
		emp1.setDesignation("ManagerManager");
		emp1.setDepartment(department);
		employees.add(emp1);

		Employee emp2 = new Employee();
		emp2.setEmployeeName("Majrul");
		emp2.setDesignation("AssistantManager");
		emp2.setDepartment(department);
		employees.add(emp2);

		Employee emp3 = new Employee();
		emp3.setEmployeeName("Dinesh");
		emp3.setDesignation("Manager");
		emp3.setDepartment(department);
		employees.add(emp3);

		department.setEmployees(employees);
		dao.addADepartmentWithEmployee(department);
	}

	@Test
	public void fetchDeptAndEmp() {
		dao.fetchDepartmentAndEmployee();
	}

	@Test
	public void namedQuerOne() {
		dao.viewDepts();
	}

	@Test
	public void findDeptById() {
		dao.findDeptById();
	}
}
