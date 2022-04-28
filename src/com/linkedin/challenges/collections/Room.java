package com.linkedin.challenges.collections;

import java.util.Objects;

public class Room {
	
	private String name;
	private String type;
	private int capacity;
	private double rate;
	
	public Room(String name, String type, int capacity, double rate) {
		this.name = name;
		this.type = type;
		this.capacity = capacity;
		this.rate = rate;
	}
	
	public String getName() {
		return this.name;
	}
	public String getType() {
		return this.type;
	}
	public int getCapacity() {
		return this.capacity;
	}
	public double getRate() {
		return this.rate;
	}
	// This is to ensure that HashSet generates treats 2 objects with the 
	//same name as equal.
	@Override
	public int hashCode() {
		return Objects.hash(this.name);
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(this.name.equalsIgnoreCase(((Room) obj).getName())) {
			return true;
		}
		return false;
	}
}
