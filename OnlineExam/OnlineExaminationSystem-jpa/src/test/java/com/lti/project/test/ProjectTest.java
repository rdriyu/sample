package com.lti.project.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.project.dao.ProjectDao;
import com.lti.project.model.Questions;
import com.lti.project.model.SubjectType;
import com.lti.project.model.User;

public class ProjectTest {

	ProjectDao dao = new ProjectDao();

	@Test
	public void addUser() {

		User user = new User();

		user.setFullName("Riya D");
		user.setEmail("rdrd@gmail.com");
		user.setMobile("9823456784");
		user.setState("Maharashtra");
		user.setCity("Mumbai");
		user.setDateOfBirth(LocalDate.of(1998, 9, 15));
		user.setQualification("B.Tech");
		user.setYearOfCompletion(LocalDate.of(2020, 7, 30));
		user.setPassword("rd@abc123");

		dao.addUser(user);
	}

	@Test
	public void addQuestion() {

		Questions qns = new Questions();

		qns.setLevelId(1);
		qns.setSubjecType(SubjectType.cCpp);
		qns.setQuestionStatement("Which of the following is not a valid C variable name");
		qns.setOptionA("int $main");
		qns.setOptionB("float rate");
		qns.setOptionC("int variable_count");
		qns.setOptionD("char option");
		qns.setCorrectOption('a');

		dao.addQuestion(qns);
	}
	
	
	
}
