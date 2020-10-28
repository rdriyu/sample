package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_account")
public class Account {
	
	@Id
	@SequenceGenerator(name="accSeq", initialValue=5001, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="accSeq")
	@Column(name="account_number")
	int accountNumber;
	
	@Column(name="account_type")
	AccountType accountType;
	
	@Column(name="account_balance")
	double balance;
	
	@Column(name="account_ifsc_code")
	String ifscCode;
	
	@Column(name="account_password")
	String password;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
