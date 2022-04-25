package com.linkedin.challenges.basic;

public class StudentProfile {
	
	private String firstName;
	private String lastName;
	private int expectedGraduationYear;
	private double gpa;
	private String major;
	
	public StudentProfile(String firstName, String lastName, int graduationYear, double gpa, String major) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.expectedGraduationYear = graduationYear;
		this.gpa = gpa;
		this.major = major;
	}
	
	public int incrementExpectedGraduationYear() {
		return ++this.expectedGraduationYear;
	}

	public static void main(String[] args) {
		StudentProfile student1 = new StudentProfile("Ram", "Sharma", 2021, 7.1, "Computer");
		StudentProfile student2 = new StudentProfile("Shyam", "Sharma", 2021, 7.8, "Mechanical");
		System.out.println("Expected Graduation Year: "+student2.incrementExpectedGraduationYear());
	}
}
