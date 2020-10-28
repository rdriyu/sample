package com.lti.main;

import com.lti.dao.PersonDao;
import com.lti.model.Person;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person = new Person();

		/*
		 * person.setPersonName("Ryan"); person.setPersonCity("NewYork");
		 * 
		 * PersonDao dao = new PersonDao(); dao.addAPerson(person);
		 */

		// person.setPersonId(2);
		person.setPersonName("Pam");
		person.setPersonCity("Chicago");

		PersonDao dao = new PersonDao();
		dao.addOrUpdateAPerson(person);
		
	}

}
