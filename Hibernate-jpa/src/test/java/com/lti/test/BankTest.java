package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.lti.dao.BankDao;
import com.lti.model.Account;
import com.lti.model.AccountType;
import com.lti.model.Customer;
import com.lti.model.Person;

public class BankTest {

	BankDao dao = new BankDao();

	@Test
	public void addACustomer() {
		Customer customer = new Customer();
		customer.setCustomerName("Rosa");
		customer.setDateOfBirth(LocalDate.of(1985, 11, 12));
		customer.setEmail("rosadiaz@gmail.com");
		customer.setMobileNumber("9999988888");

		dao.addACustomer(customer);
	}

	@Test
	public void addAnAccountWhereCustomerExists() {
		Customer customer = dao.findACustomer(1001);
		Account account = new Account();
		account.setAccountType(AccountType.savings);
		account.setBalance(20000.00);
		account.setIfscCode("1234567890");
		account.setPassword("RosaDiaz@123");
		account.setCustomer(customer);
		dao.addAnAccountWithExistingCustomer(account);
	}

	@Test
	public void addNewCustomerWithNewAccount() {
		Customer customer = new Customer();
		customer.setCustomerName("Michael");
		customer.setDateOfBirth(LocalDate.of(1968, 8, 11));
		customer.setEmail("michaelscarn@yahoo.com");
		customer.setMobileNumber("111111111");

		Account account = new Account();
		account.setAccountType(AccountType.corporate);
		account.setBalance(10000.00);
		account.setIfscCode("ER56Y76HL9");
		account.setPassword("mlkHitler@bestManager");

		customer.setAccount(account);
		account.setCustomer(customer);

		dao.addNewCustomerWithNewAccount(customer);
	}

	@Test
	public void findCustomer() {
		Customer customer69 = dao.findACustomer(1002);
		System.out.println(customer69.getCustomerId() + " " + customer69.getCustomerName() + " " + customer69.getEmail()
				+ " " + customer69.getDateOfBirth() + " " + customer69.getMobileNumber());
	}

	@Test
	public void findAcc() {
		Account acc = dao.findAnAccount(5001);
		System.out.println(
				acc.getAccountNumber() + " " + acc.getBalance() + " " + acc.getIfscCode() + " " + acc.getPassword());
	}

	@Test
	public void viewCustomer() {
		List<Customer> customers = dao.viewAllCustomers();
		Iterator<Customer> items = customers.iterator();
		while (items.hasNext()) {
			Customer customer69 = items.next();
			System.out.println(customer69.getCustomerId() + " " + customer69.getCustomerName() + " "
					+ customer69.getEmail() + " " + customer69.getDateOfBirth() + " " + customer69.getMobileNumber());
		}
	}

	@Test
	public void viewAcc() {
		List<Account> accounts = dao.viewAllAccounts();
		Iterator<Account> items = accounts.iterator();
		while (items.hasNext()) {
			Account acc = items.next();
			System.out.println(acc.getAccountNumber() + " " + acc.getBalance() + " " + acc.getIfscCode() + " "
					+ acc.getPassword());
		}
	}

	@Test
	public void loginAcc() {
		boolean res = dao.accountLogin(5006, "rosAdaddiaZ^123");
		if (res) {
			System.out.println("Login Successful.");
		} else {
			System.out.println("Login Failed.");
		}
	}

	@Test
	public void listAccountByType() {
		List<Account> account = dao.listAccountByType(AccountType.savings);
		for (Account a : account)
			System.out.println(a.getAccountNumber() + " " + a.getAccountType() + " " + a.getBalance() + " "
					+ a.getIfscCode() + " " + a.getPassword());
	}
}
