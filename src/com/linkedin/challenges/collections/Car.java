package com.linkedin.challenges.collections;

public class Car {
	private String make;
	private String model;
	private double mileage;
	
	public Car(String make, String model, double mileage) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
	}
	
	public String getMake() {
		return this.make;
	}
	public String getModel() {
		return this.model;
	}
	public double getMileage() {
		return this.mileage;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		Car other = (Car) obj;
		if(this.make.equals(other.getMake()) && this.model.equalsIgnoreCase(other.getModel())) {
			return true;
		}
		return false;
	}
}
