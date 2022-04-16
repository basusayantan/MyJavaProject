package datastructures.implement;

import datastructures.unit.Node;

public class LinkedList {
	
	private Node head;
	
	//constructor
	public LinkedList() {
		this.head = null;
	}
	
	//add methods overloaded
	public void add(int data) {
		
		Node temp = this.head;
		if(temp == null) {
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
		if(temp == null || position == 1) {
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
	
	//delete method
	public void delete(int position) {
		Node temp = this.head;
		int i = 0;
		if(position == 1) {
			this.head = temp.getNext();
		}
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
	
	//traverse method
	public void traverse() {
		Node temp = this.head;
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
