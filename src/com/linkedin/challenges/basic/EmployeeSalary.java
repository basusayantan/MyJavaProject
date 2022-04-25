package com.linkedin.challenges.basic;

public class EmployeeSalary {
	
	private double hoursPerWeek;
	private double hourlyPay;
	private int vacationDays;
	
	EmployeeSalary(double hours, double pay, int vacation) throws IllegalArgumentException {
		if(hours < 0 || pay < 0 || vacation < 0) {
			throw new IllegalArgumentException("Cannot be less than 0");
		}
		this.hoursPerWeek = hours;
		this.hourlyPay = pay;
		this.vacationDays = vacation;
	}
	public double calculatePay() {
		return (52 * hoursPerWeek - vacationDays * 8) * hourlyPay;
	}

	public static void main(String[] args) {
		try {
			EmployeeSalary obj = new EmployeeSalary(-110, 1, 1);
			System.out.print(obj.calculatePay());
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
