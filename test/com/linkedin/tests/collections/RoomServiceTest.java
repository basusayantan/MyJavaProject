package com.linkedin.tests.collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;

import com.linkedin.challenges.collections.Room;
import com.linkedin.challenges.collections.RoomService;

@SuppressWarnings("unused")
public class RoomServiceTest {
	
	RoomService service;
	
	@BeforeEach
	public void setUp(TestInfo info) throws Exception{
		this.service = new RoomService();
		this.service.createRoom("Cambridge", "Premier", 2, 4999.99);
		this.service.createRoom("Sonata", "Suite", 4, 9999.99);
		this.service.createRoom("Piccadilly", "Deluxe", 3, 5999.99);
		System.out.format("%nRunning %s%n", info.getTestMethod().get().getName());
	}
	
	@AfterEach
	public void tearDown() throws Exception{
		System.out.format("%nInventory%n");
		this.service.getInventory().stream().forEach(System.out::println);
	}
	
	@Test
	public void testGetInventory() {
		assertNotNull(this.service.getInventory());
	}
	@Test
	public void testCreateRoom() {
		this.service.createRoom("Milton Keynes", "Premier", 2, 4999.99);
		assertEquals(this.service.getInventory().size(), 4);
		this.service.createRoom("Cambridge", "Premier", 2, 4999.99);
		assertEquals(this.service.getInventory().size(), 4);
	}
	@Test
	public void testCreateRooms() {
		Room mayfair, oxford, cambridge;
		mayfair = new Room("Mayfair", "Suite", 4, 9999.99);
		oxford = new Room("Oxford", "Deluxe", 3, 5999.99);
		cambridge = new Room("Cambridge", "Premier", 2, 4999.99);
		Room[] rooms = {mayfair, oxford, cambridge};
		this.service.createRooms(rooms);
		assertEquals(this.service.getInventory().size(), 5);
	}
	@Test
	public void testRemoveRoom() {
		this.service.removeRoom(new Room("Cambridge", "Premier", 2, 4999.99));
		assertEquals(this.service.getInventory().size(), 2);
		this.service.removeRoom(new Room("Ramada", "Suite", 4, 9999.99));
		assertEquals(this.service.getInventory().size(), 2);
	}
	@Test
	public void testHasRoom() {
		assertEquals(this.service.hasRoom(new Room("Sonata", "Suite", 4, 9999.99)), true);
		assertEquals(this.service.hasRoom(new Room("Ramada", "Suite", 4, 9999.99)), false);
	}
	@Test
	public void testAsArray() {
		Room[] rooms = this.service.asArray();
		assertEquals(rooms.length, 3);
		assertEquals(rooms[0].getName(), "Cambridge");
		assertEquals(rooms[1].getName(), "Sonata");
		assertEquals(rooms[2].getName(), "Piccadilly");
	}
	@Test
	public void testGetByType() {
		this.service.createRoom("Milton Keynes", "Premier", 2, 4999.99);
		assertEquals(this.service.getRoomsByType("Premier").size(), 2);
		assertEquals(this.service.getRoomsByType("Normal").size(), 0);
		assertEquals(this.service.getInventory().size(), 4);
	}
	@Test
	public void testApplyDiscount() {
		this.service.applyDiscount(50);
		Room[] rooms = this.service.asArray();
		assertEquals(rooms[0].getRate(), 4999.99/2);
		assertEquals(rooms[1].getRate(), 9999.99/2);
		assertEquals(rooms[2].getRate(), 5999.99/2);
	}
	@Test
	public void testApplyDiscountNew() {
		this.service.applyDiscountNew(50);
		Room[] rooms = this.service.asArray();
		assertEquals(rooms[0].getRate(), 4999.99/2);
		assertEquals(rooms[1].getRate(), 9999.99/2);
		assertEquals(rooms[2].getRate(), 5999.99/2);
	}
	@Test
	public void testGetRoomsByRateAndType() {
		this.service.createRoom("Milton Keynes", "Premier", 2, 5999.99);
		this.service.createRoom("Ramada", "Standard", 1, 1999.99);
		Room[] rooms = this.service.asArray();
		String[] types = {"Premier", "Standard"};
		Collection<Room> roomsList = this.service.getRoomsByTypeAndRate(types, 5000);
		assertEquals(roomsList.size(), 2);
		assertTrue(roomsList.containsAll(Arrays.asList(rooms[0], rooms[4])));
		roomsList = this.service.getRoomsByTypeAndRate(new String[] {}, 9999.99);
		assertTrue(roomsList.isEmpty());
	}
	@Test
	public void testGetRoomsByCapacity() {
		this.service.createRoom("Milton Keynes", "Premier", 2, 4999.99);
		this.service.createRoom("Ramada", "Suite", 4, 6999.99);
		Room[] rooms = this.service.asArray();
		Collection<Room> roomsList = this.service.getRoomsByCapacity(2);
		assertEquals(roomsList.size(), 2);
		assertTrue(roomsList.containsAll(Arrays.asList(rooms[0], rooms[3])));
		roomsList = this.service.getRoomsByCapacity(5);
		assertTrue(roomsList.isEmpty());
	}
}
