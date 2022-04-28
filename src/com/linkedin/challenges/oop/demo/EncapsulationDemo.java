package com.linkedin.challenges.oop.demo;

import com.linkedin.challenges.oop.src.BankAccount;
import com.linkedin.challenges.exceptions.InsufficientFundsException;

public class EncapsulationDemo {

	public static void main(String[] args) {
		BankAccount account = new BankAccount("Sayantan Basu");
		System.out.println("Account Owner: "+account.getOwner());
		try {
			account.deposit(100);
			System.out.println("Account Balance: "+account.getBalance());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			account.deposit(-100);
			System.out.println("Account Balance: "+account.getBalance());
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		try {
			account.withdraw(150);
			System.out.println("Account Balance: "+account.getBalance());
		} catch(InsufficientFundsException e) {
			System.out.println(e.getMessage());
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
