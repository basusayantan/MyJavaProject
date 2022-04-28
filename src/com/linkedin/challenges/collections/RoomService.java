package com.linkedin.challenges.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class RoomService {
	
	private Collection<Room> inventory;
	
	public RoomService() {
		this.inventory = new ArrayList<>();
	}
	public Collection<Room> getInventory() {
		return new HashSet<>(this.inventory);
	}
	public void createRoom(String name, String type, int capacity, double rate) {
		this.inventory.add(new Room(name, type, capacity, rate));
	}
	public void createRooms(Room[] rooms) {
		this.inventory.addAll(Arrays.asList(rooms));
	}
	public void removeRoom(Room room) {
		this.inventory.remove(room);
	}
}
