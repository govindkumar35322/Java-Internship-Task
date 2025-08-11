package com.task5;

import java.security.SecureRandom;

public class Account {
	private Long accountNumber;
	private double balance;
	private Customer customer;

	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Long accountNumber,  Customer customer) {
		super();
		if (accountNumber == null) {
			this.accountNumber = genrateAccountNumber();
		} else {
			this.accountNumber = accountNumber;
		}
		this.balance = balance;
		this.customer = customer;
	}

	static Long genrateAccountNumber() {
		SecureRandom random = new SecureRandom();
		Long min = 100000000000L;
		Long max = 999999999999L;

		return min + (Math.abs(random.nextLong()) % (max - min + 1));
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", customer=" + customer + "]";
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposited: " + amount);
		} else {
			System.out.println("Invalid deposit amount!");
		}
	}

	public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawn: " + amount);
     } else {
         System.out.println("Invalid or insufficient funds!");
     }
 }
}
