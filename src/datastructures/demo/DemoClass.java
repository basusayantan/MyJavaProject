package datastructures.demo;

import datastructures.implement.LinkedList;
import datastructures.implement.Stack;

public class DemoClass {

	public static void main(String[] args) {
		
		//Demo for Linked List
		LinkedList llist = new LinkedList();
		llist.add(3);
		llist.add(40);
		llist.add(50);
		llist.add(0);
		llist.add(60);
		llist.add(20, 2);
		llist.add(55, 25);
		llist.display();
		llist.delete(3);
		llist.display();
		llist.delete(1);
		llist.delete(20);
		llist.delete(1);
		llist.display();
		llist.delete(10);
		llist.delete(1);
		llist.delete(10);
		llist.delete(1);
		llist.display();
		
		//Demo for Stack
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.display();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		System.out.println(s.peek());
		System.out.println(s.peek());
	}
}
