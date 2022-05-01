package com.linkedin.challenges.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
	public boolean hasRoom(Room room) {
		return this.inventory.contains(room);
	}
	public Room[] asArray() {
		return this.inventory.toArray(new Room[] {});
	}
	public void removeRoom(Room room) {
		this.inventory.remove(room);
	}
	public Collection<Room> getRoomsByType(String type) {
		Collection<Room> copy = this.getInventory();
		copy.removeIf(r -> !r.getType().equals(type));
		return copy;
	}
	public void applyDiscount(double discount) {
		Iterator<Room> iter = this.inventory.iterator();
		while(iter.hasNext()) {
			Room room = iter.next();
			room.setRate((1 - discount/100) * room.getRate());
		}
	}
	public void applyDiscountNew(double discount) {
		this.getInventory().stream()
			.forEach(r -> r.setRate((1 - discount/100)*r.getRate()));
	}
	public Collection<Room> getRoomsByTypeAndRate(String[] types, double rate) {
		return this.getInventory().stream()
			.filter(r -> List.of(types).contains(r.getType()) && r.getRate() <= rate)
			.collect(Collectors.toList());
	}
	public Collection<Room> getRoomsByCapacity(int capacity) {
		return this.getInventory().stream()
				.filter(r -> r.getCapacity() == capacity)
				.collect(Collectors.toList());
	}
}
