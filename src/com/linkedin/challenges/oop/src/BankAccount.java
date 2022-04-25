package com.linkedin.challenges.oop.src;

import com.linkedin.challenges.exceptions.InsufficientFundsException;

public class BankAccount {
	
	private String owner;
	private double balance;
	
	public BankAccount(String owner) {
		this.owner = owner;
		this.balance = 0;
	}
	
	public String getOwner() {
		return owner;
	}
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) throws IllegalArgumentException {
		if(amount <= 0) {
			throw new IllegalArgumentException("Cannot deposit: Ammount cannot be negative or zero.");
		} else {
			this.balance += amount;
		}
	}
	public void withdraw(double amount) throws IllegalArgumentException, InsufficientFundsException {
		if(amount <= 0) {
			throw new IllegalArgumentException("Cannot withdraw: Amount cannot be negative or zero.");
		} else if(this.balance - amount < 0) {
			throw new InsufficientFundsException("Insufficient Funds: Cannot withdraw "+amount);
		} else {
			this.balance -= amount;
		}
	}
}
