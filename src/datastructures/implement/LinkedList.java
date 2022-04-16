package datastructures.implement;

import datastructures.unit.Node;

public class LinkedList {
	
	private Node head;
	
	//constructor
	public LinkedList() {
		this.head = null;
	}
	
	//getter
	public Node getList() {
		return this.head;
	}
	
	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		return false;
	}
	//overloaded methods to add nodes
	public void add(int data) {
		
		Node temp = this.head;
		if(isEmpty()) {
			this.head = new Node(data);
		}
		else {
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(new Node(data));
		}
	}
	public void add(int data, int position) {
		Node temp = this.head;
		Node node = new Node(data);
		int i = 0;
		if(isEmpty() || position == 1) {
			node.setNext(temp);
			this.head = node;
		}
		else {
			while(i < position-2) {
				if(temp.getNext() == null) {
					temp.setNext(node);
					return;
				}
				temp = temp.getNext();
				i++;
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
	}
	
	//method to delete node by position
	public void delete(int position) {
		Node temp = this.head;
		int i = 0;
		if(isEmpty()) {
			return;
		}
		if(position == 1) {
			this.head = temp.getNext();
			return;
		}
		try {
			while(i < position-2) {
				if(temp.getNext().getNext() == null) {
					temp.setNext(null);
					return;
				}
				temp = temp.getNext();
				i++;
			}
			Node node = temp.getNext().getNext();
			temp.setNext(node);
		}
		catch(NullPointerException e) {
			this.head = null;
			return;
		}
	}
	
	//method for traversal
	public void display() {
		Node temp = this.head;
		if(isEmpty()) {
			System.out.println("Empty linked list.");
			return;
		}
		while(temp != null) {
			System.out.print(temp.getData());
			if(temp.getNext() != null) {
				System.out.print(" --> ");
			}
			temp = temp.getNext();
		}
		System.out.println();
	}
}
