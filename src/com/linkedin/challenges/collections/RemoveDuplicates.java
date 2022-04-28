package com.linkedin.challenges.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class RemoveDuplicates  {
	
	private static void run() {
		Collection<Room> a = new ArrayList<>();
		a.add(new Room("Cambridge", "Premier", 2, 4999.99));
		a.add(new Room("Cambridge", "Premier", 2, 4999.99));
		a.add(new Room("Cambridge", "Premier", 2, 4999.99));
		Collection<Room> b = new HashSet<>(a);
		for(Room i : a) {
			System.out.println(i.getName());
		}
		for(Room i : b) {
			System.out.println(i.getName());
		}
	}
	
	public static void main(String[] args) {
		RemoveDuplicates.run();
	}
}
