package com.linkedin.challenges.collections;

import java.util.Collection;
import java.util.List;

public class DemoCollections {

	public static void main(String[] args) {
		Room room1 = new Room("Cambridge", "Deluxe", 3, 200);
		Room room2 = new Room("Mayfair", "Suite", 5, 600);
		Collection<Room> rooms = List.of(room1, room2);
		double totalRevenue = calculateRevenue(rooms);
		System.out.println("Total Revenue: "+totalRevenue);
	}
	
	public static double calculateRevenue(Collection<Room> rooms) {
		return rooms.stream().mapToDouble(r -> r.getRate()).sum();
	}
}
