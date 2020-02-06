package com.linkedListImplementation.app;

public class Node {

	protected int value;
	protected Node next;

	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public int getValue() {
		return value;
	}
}