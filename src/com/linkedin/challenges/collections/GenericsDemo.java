package com.linkedin.challenges.collections;

import java.util.ArrayList;
import java.util.Collection;

public class GenericsDemo {
/*
 * Raw types can store different
 * objects. Makes specifying generic parameters in instantiation moot.
 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void main(String[] args) {
		
		Collection c = new ArrayList<String>();
		c.add(10);
		c.add("String");
		c.add(new Room("Oxford", "Suite", 3, 500.50));
		
		//displays different object type of the elements
		c.stream().forEach(e->System.out.println(e.getClass()));
		
		//this line will throw a runtime exception as Integer cannot be cast into Room type
		c.stream().forEach(e->System.out.println(((Room) e).getName()));
	}
}
