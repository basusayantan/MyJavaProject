package datastructures.unit;

public class Node {

	private int data;
	private Node next;
	
	//Constructor
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	//getter
	public int getData() {
		return this.data;
	}
	public Node getNext() {
		return this.next;
	}
	
	//setter
	public void setData(int data) {
		this.data = data;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
