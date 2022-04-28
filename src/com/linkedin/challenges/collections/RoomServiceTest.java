package com.linkedin.challenges.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;

@SuppressWarnings("unused")
public class RoomServiceTest {
	
	RoomService service;
	
	@BeforeEach
	public void setUp(TestInfo info) throws Exception{
		this.service = new RoomService();
		this.service.createRoom("Cambridge", "Premier", 2, 4999.99);
		System.out.format("%nRunning %s%n", info.getTestMethod().get().getName());
	}
	
	@AfterEach
	public void tearDown() throws Exception{
		System.out.format("%nInventory%n");
		this.service.getInventory().stream()
			.map(e->String.format("%s %s %d %.2f", e.getName(), e.getType(), e.getCapacity(), e.getRate()))
			.forEach(e->System.out.println(e));
	}
	
	@Test
	public void testCreateRoom() {
		this.service.createRoom("Cambridge", "Premier", 2, 4999.99);
		assertEquals(this.service.getInventory().size(), 1);
	}
	@Test
	public void testCreateRooms() {
		Room mayfair, oxford;
		mayfair = new Room("Mayfair", "Suite", 4, 9999.99);
		oxford = new Room("Oxford", "Deluxe", 3, 5999.99);
		Room[] rooms = {mayfair, oxford};
		this.service.createRooms(rooms);
		assertEquals(this.service.getInventory().size(), 3);
	}
	@Test
	public void testRemoveRoom() {
		this.service.removeRoom(new Room("Cambridge", "Premier", 2, 4999.99));
	}
}
