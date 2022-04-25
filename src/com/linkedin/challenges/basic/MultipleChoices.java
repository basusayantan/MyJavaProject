package com.linkedin.challenges.basic;

import java.util.Scanner;

public class MultipleChoices {
	private String question;
	private String choice1;
	private String choice2;
	private String choice3;
	private String answer;
	
	MultipleChoices() {
		this.question = "What is the largest planet ?";
		this.choice1 = "Earth";
		this.choice2 = "Jupiter";
		this.choice3 = "Saturn";
	}
	
	public void checkAnswer(String answer) {
		String correct = this.choice2;
		if(answer.toLowerCase().equals(correct.toLowerCase())) {
			System.out.println("Congratulations!");
		}else {
			System.out.println("Wrong Answer! Correct Answer: "+correct);
		}
		return;
	}
	
	public void run() {
		System.out.println("Question: "+question);
		System.out.println(choice1+", "+choice2+" OR "+choice3);
		System.out.println("Enter answer:");
		try (Scanner in = new Scanner(System.in)) {
			this.answer = in.next();
		} catch(Exception e) {
			return;
		}
		checkAnswer(answer);
	}
		
	public static void main(String[] args) {
		MultipleChoices obj = new MultipleChoices();
		obj.run();
	}
}