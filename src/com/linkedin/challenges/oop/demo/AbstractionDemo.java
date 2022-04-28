package com.linkedin.challenges.oop.demo;

import java.io.IOException;

import com.linkedin.challenges.oop.src.AlphabetsOnlyFileReader;

public class AbstractionDemo {
	
	public static void main(String[] args) {
		AlphabetsOnlyFileReader alphaFileReader = new AlphabetsOnlyFileReader("File");
		System.out.println(alphaFileReader.getPath());
		try {
			System.out.println(alphaFileReader.readFile());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
