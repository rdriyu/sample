package com.lti.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity // mandatory annotation to make it JPA entity
@Table(name = "tbl_person")
public class Person {

	@Id // primary key
	@GeneratedValue
	// @GeneratedValue(generator=GenerationType.AUTO)
	@Column(name = "person_id")
	int personId;

	@Column(name = "person_name")
	String personName;

	@Column(name = "person_city")
	String personCity;

	@OneToOne(mappedBy="person", cascade=CascadeType.ALL /* fetch=FetchType.LAZY */) //prevent fk from being created in Person table
	Passport passport;
	
	

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonCity() {
		return personCity;
	}

	public void setPersonCity(String personCity) {
		this.personCity = personCity;
	}

}
