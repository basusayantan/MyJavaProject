package datastructures.implement;

import datastructures.unit.Node;

public class Stack extends LinkedList {
	
	//constructor
	public Stack() {
		super();
	}
	
	//method for push
	public void push(int data) {
		add(data, 1);
	}
	
	//method for pop
	public void pop() {
		try {
			System.out.println("Popped Element: "+getList().getData());
		}
		catch(NullPointerException e) {
			display();
			return;
		}
		delete(1);
		display();
	}
	
	//method for peek
	public int peek() {
		if(isEmpty()) {
			return -1;
		}
		else return getList().getData();
	}
	
	//method to display
	@Override
	public void display() {
		Node temp = getList();
		if(isEmpty()) {
			System.out.println("Empty stack.");
			return;
		}
		while(temp != null) {
			System.out.print(temp.getData());
			if(temp.getNext() != null) {
				System.out.print(", ");
			}
			temp = temp.getNext();
		}
		System.out.println();
	}
}
