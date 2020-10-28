package com.lti.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.project.model.Questions;
import com.lti.project.model.User;

public class ProjectDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	public ProjectDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public void addUser(User user) {
		tx.begin();
		em.merge(user);
		tx.commit();
		System.out.println("User added..");
	}

	public void addQuestion(Questions questions) {
		tx.begin();
		em.merge(questions);
		tx.commit();
		System.out.println("Questions added..");
	}

}
