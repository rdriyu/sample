package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.hibernate.tool.schema.extract.spi.ExtractionContext.DatabaseObjectAccess;
import org.junit.Test;

import com.lti.dao.PersonDao;
import com.lti.model.Passport;
import com.lti.model.Person;

public class PersonTest {

	PersonDao dao = new PersonDao();

	@Test
	public void findAPerson() {
		Person person = dao.findAPerson(3);
		System.out.println(person.getPersonId() + " " + person.getPersonName() + " " + person.getPersonCity());
	}

	@Test
	public void viewAllPersons() {
		List<Person> persons = dao.viewAllPersons();
		Iterator<Person> items = persons.iterator();
		while (items.hasNext()) {
			Person p = items.next();
			System.out.println(p.getPersonId() + " " + p.getPersonName() + " " + p.getPersonCity());
		}
	}

	@Test
	public void findByName() {
		Person pp = dao.findPersonByName("Jimothy");
		pp.getPassport();
		System.out.println(pp.getPersonId() + " " + pp.getPersonName() + " " + pp.getPersonCity());
	}

	@Test
	public void addAPassport() {
		Passport passport = new Passport();
		passport.setNationality("USA");
		passport.setValidFrom(LocalDate.of(2020, 10, 13));
		passport.setValidTill(LocalDate.of(2030, 10, 12));

		Person person111 = dao.findAPerson(3);
		passport.setPerson(person111);

		dao.addAPassport(passport);
	}

	@Test
	public void addPersonWithPassport() {
		Person person69 = new Person();
		person69.setPersonName("Kevin");
		person69.setPersonCity("Dublin");

		Passport passport69 = new Passport();
		passport69.setNationality("Ireland");
		passport69.setValidFrom(LocalDate.now());
		passport69.setValidTill(LocalDate.of(2030, 10, 20));

		person69.setPassport(passport69);
		passport69.setPerson(person69);

		dao.addAPersonWithANewPassport(person69);
	}

	@Test
	public void viewAllPersonsSortedByName() {
		List<Person> persons = dao.viewAllPersonsSortedByName();
		Iterator<Person> items = persons.iterator();
		while (items.hasNext()) {
			Person p = items.next();
			System.out.println(p.getPersonId() + " " + p.getPersonName() + " " + p.getPersonCity());
		}
	}

	@Test
	public void viewPersonsNameWithJ() {
		List<Person> persons = dao.viewAllEmployeesNamesStartWithS();
		Iterator<Person> items = persons.iterator();
		while (items.hasNext()) {
			Person p = items.next();
			System.out.println(p.getPersonId() + " " + p.getPersonName() + " " + p.getPersonCity());
		}
	}

	@Test
	public void countPersons() {
		int count = dao.countTotalEmployees();
		System.out.println("Total employees = " + count);
	}

	@Test
	public void fetchPersonWithPassport(){
		dao.fetchPersonAndPassport();
	}
	
}
