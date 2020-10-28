package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.model.Account;
import com.lti.model.AccountType;
import com.lti.model.Customer;
import com.lti.model.Person;

public class BankDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	public BankDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public void addACustomer(Customer customer) {
		tx.begin();
		em.merge(customer);
		tx.commit();
		System.out.println("Object persisted (Customer added...)");
	}

	public void addAnAccountWithExistingCustomer(Account account) {
		tx.begin();
		em.merge(account);
		tx.commit();
		System.out.println("Object persisted (Account added...)");
	}

	public void addNewCustomerWithNewAccount(Customer customer) {
		tx.begin();
		em.merge(customer);
		tx.commit();
		System.out.println("Object persisted (Customer and Account added...)");
	}

	public Customer findACustomer(int customerId) {
		Customer customer123 = em.find(Customer.class, customerId);
		return customer123;
	}

	public Account findAnAccount(int accountNo) {

		return em.find(Account.class, accountNo);
	}

	public List<Customer> viewAllCustomers() {
		Query query = em.createQuery("select c from Customer c", Customer.class);
		return query.getResultList();
	}

	public List<Account> viewAllAccounts() {
		Query query = em.createQuery("select a from Account a", Account.class);
		return query.getResultList();
	}

	public boolean accountLogin(int accountNumber, String password) {
		String jpql = "select a from Account a where a.accountNumber=:acc and a.password=:pwd";
		Query query = em.createQuery(jpql, Account.class);
		query.setParameter("acc", accountNumber);
		query.setParameter("pwd", password);

		Account acc = (Account) query.getResultList().stream().findFirst().orElse(null);
		if (acc != null)
			return true;

		return false;
	}

	public List<Account> listAccountByType(AccountType accountType) {
		String jpql = "select a from Account a where a.accountType=:at";
		Query query = em.createQuery(jpql, Account.class);
		query.setParameter("at", accountType);
		return query.getResultList();
	}
}
