package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.Account;
import com.lti.model.Department;
import com.lti.model.Employee;

public class CompanyDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	public CompanyDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public void addADepartment(Department department) {
		tx.begin();
		em.merge(department);
		tx.commit();
		System.out.println("Object persisted (Department added...)");
	}

	public void addAnEmployee(Employee employee) {
		tx.begin();
		em.merge(employee);
		tx.commit();
		System.out.println("Object persisted (Customer and Account added...)");
	}

	public void addADepartmentWithEmployee(Department department) {
		tx.begin();
		em.merge(department);
		tx.commit();
		System.out.println("Object persisted (Department and Employee added...)");
	}

	public Department findADepartment(int departmentId) {
		return em.find(Department.class, departmentId);
	}

	public void fetchDepartmentAndEmployee() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();

		String jpql = "select d from Department d join d.employees emp";
		// Query query = em.createQuery(jpql, Department.class);
		TypedQuery<Department> query = em.createQuery(jpql, Department.class);

		List<Department> depts = query.getResultList();

		for (Department d : depts) {
			System.out.println(d.getDepartmentId() + " " + d.getDepartmentName() + " " + d.getLocation());
			for (Employee e : d.getEmployees()) {
				System.out.println(e.getEmployeeCode() + e.getEmployeeName());
			}
		}
	}

	public static void findHighestSalaryDept() {
		System.out.println("-- Dept with max salary --");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		TypedQuery<String> query = em.createQuery(
				"SELECT d.name FROM Department d "
						+ " JOIN d.employees e where e.salary = (SELECT MAX(e2.salary) FROM Employee e2) ",
				String.class);
		String dept = query.getSingleResult();
		System.out.println(dept);
	}

	public void viewDepts() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Department> query = em.createNamedQuery("viewAllDept", Department.class);
		List<Department> departments = query.getResultList();
		for (Department d : departments) {
			System.out.println(d.getDepartmentId() + " " + d.getDepartmentName());
		}
	}

	public void findDeptById() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();

		TypedQuery<Department> query = em.createNamedQuery("findDeptById", Department.class);
		query.setParameter("deptId", 2006);

		Department dept = query.getSingleResult();
		System.out.println(dept.getDepartmentId() + " " + dept.getDepartmentName());
	}

}
