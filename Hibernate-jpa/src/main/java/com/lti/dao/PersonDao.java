package com.lti.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.model.Department;
import com.lti.model.Employee;
import com.lti.model.Passport;
import com.lti.model.Person;

import oracle.net.ns.NSProtocol;

public class PersonDao {

	/*
	 * public void addAPerson(Person person) { // provide entity manager
	 * insatnce EntityManagerFactory emf =
	 * Persistence.createEntityManagerFactory("pu");
	 * 
	 * // will perform all database operation like // persisting an object,
	 * detaching object, removing object EntityManager em =
	 * emf.createEntityManager();
	 * 
	 * EntityTransaction tx = em.getTransaction();
	 * 
	 * tx.begin(); em.persist(person); tx.commit();
	 * System.out.println("Object persisted (Employee added...)"); }
	 */

	public void addOrUpdateAPerson(Person person) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();
		// until the merge or persist method is called, object remains in
		// transient state
		em.merge(person); // persistent state
		// if we do person.setPersonCity("Ghatal"); it will reflect in the
		// database
		tx.commit();
		System.out.println("Object persisted (Employee updated...)");
	}

	public Person findAPerson(int personId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();

		return em.find(Person.class, personId);
	}

	public List<Person> viewAllPersons() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		// JPQL
		Query query = em.createQuery("select p from Person p", Person.class);
		return query.getResultList();
	}

	public Person findPersonByName(String personName) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		String jpql = "select p from Person p where p.personName=:pn";
		Query query = em.createQuery(jpql, Person.class);
		query.setParameter("pn", personName);

		// only one record expected
		return (Person) query.getSingleResult();
		// more than one record possible
		// query.getResultList();
	}

	public void addAPassport(Passport passport) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.merge(passport);
		tx.commit();
	}

	public void addAPersonWithANewPassport(Person person) {
		// When a person is added, a passport should also be added
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.merge(person);
		tx.commit();
	}

	public List<Person> viewAllPersonsSortedByName() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();

		String jpql = "select p from Person p order by p.personName asc";
		Query query = em.createQuery(jpql, Person.class);
		List<Person> persons = query.getResultList();
		return persons;
	}

	public List<Person> viewAllEmployeesNamesStartWithS() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();

		String jpql = "select p from Person p where p.personName like 'J%'";
		Query query = em.createQuery(jpql, Person.class);
		List<Person> persons = query.getResultList();
		return persons;
	}

	public int countTotalEmployees() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();

		String jpql = "select count(p) from Person p";
		Query query = em.createQuery(jpql);
		return Integer.parseInt(query.getSingleResult().toString());
	}

	public void fetchPersonAndPassport() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();

		// String jpql = "select p from Person p join p.passport pt";
		// String jpql = "select p from Person p left join p.passport pt";
		String jpql = "select p from Person p right join p.passport pt";
		Query query = em.createQuery(jpql, Person.class);
		List<Person> persons = query.getResultList();
		for (Person p : persons) {
			System.out.println(p.getPersonId() + " " + p.getPersonName());
			// the default join is inner join
			System.out.println(p.getPassport().getPassportNumber());
		}
	}

}
