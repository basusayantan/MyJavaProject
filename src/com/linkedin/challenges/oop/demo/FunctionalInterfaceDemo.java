package com.linkedin.challenges.oop.demo;

import com.linkedin.challenges.oop.src.FunctionalInterfaces;

public class FunctionalInterfaceDemo {
	private static String add(FunctionalInterfaces f, String msg) {
		return f.run()+" "+msg;
	}
	public static void main(String[] args) {
		FunctionalInterfaces f = () -> "From Lambda";
/*		
		FunctionalInterfaces f = new FunctionalInterfaces() {
			@Override
			public String run() {
 				return "From Lambda";
			}
		};
*/
		System.out.println(FunctionalInterfaceDemo.add(f, "HIGH"));
		System.out.println(FunctionalInterfaceDemo.add(f::run, "HI"));
		System.out.println(FunctionalInterfaceDemo.add(FunctionalInterfaces::display, "HI"));
	}
}
