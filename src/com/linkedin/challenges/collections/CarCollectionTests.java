package com.linkedin.challenges.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;

public class CarCollectionTests {
	
	Collection<Car> cars;
	Car ferrari, mercedes, lamborghini;
	
	@BeforeEach
	public void setUp(TestInfo info) throws Exception {
		System.out.format("%nPerforming %s%n%n", info.getTestMethod().get().getName());
		this.cars = new ArrayList<>();
		this.ferrari = new Car("Ferrari", "F430", 2.5);
		this.mercedes = new Car("Mercedes", "SL63AMG", 3.1);
		this.lamborghini = new Car("Lamborghini", "Huracan", 2.8);
		cars.addAll(List.of(ferrari, mercedes, lamborghini));
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		System.out.format("%nResults%n");
		this.cars.stream()
			.map(e->String.format("%s %s %.2f", e.getMake(), e.getModel(), e.getMileage()))
			.forEach(e->System.out.println(e));
	}
	
	@Test
	public void testRemove() {
		this.cars.remove(lamborghini);
		this.cars.remove(new Car("Mercedes", "SL63AMG", 2.33));
		assertEquals(this.cars.size(), 1);
	}
	
	
	
}
