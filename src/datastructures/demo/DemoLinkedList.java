package datastructures.demo;

import datastructures.implement.LinkedList;

public class DemoLinkedList {

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		llist.add(3);
		llist.add(40);
		llist.add(50);
		llist.add(0);
		llist.add(60);
		llist.add(20, 2);
		llist.add(55, 25);
		llist.traverse();
		llist.delete(3);
		llist.traverse();
		llist.delete(1);
		llist.delete(20);
		llist.traverse();
	}
}
