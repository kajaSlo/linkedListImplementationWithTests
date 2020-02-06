package com.linkedListImplementation.app;

import java.util.NoSuchElementException;

public class LinkedList {
	
	public Node beginning;
	public Node end;
	public int size;

	public LinkedList() {
		beginning = null;
		end = null;
		size = 0;
	}

	public boolean empty() {
		return beginning == null;
	}

	public int size() {
		return size;
	}

	public int get(int positionInArray) {		
		Node currentNode = beginning;

		if (positionInArray < 0 || positionInArray > size) throw new NoSuchElementException();

		positionInArray--;

		for (int j = 0; j <= positionInArray; j++) {
			currentNode = currentNode.getNext();
		}
		return currentNode.getValue();
	}

	public int popBack() {	
		if (size == 0) throw new IndexOutOfBoundsException();

		if (size == 1) {
			int value = end.getValue();
			beginning = null;
			end = null;
			size--;
			return value;
		} else {
			int value = end.getValue();
			Node oneBeforeLast = beginning;
			Node last = beginning.getNext();

			while (last.getNext() != null) {
				oneBeforeLast = last;
				end = oneBeforeLast;
			}
			oneBeforeLast.setNext(null);
			size--;
			return value;
		}
	}

	public int popFront() {		
		if (size == 0) throw new IndexOutOfBoundsException();

		if (size == 1) {
			int value = beginning.getValue();
			beginning = null;
			end = null;
			size--;
			return value;
		} else {
		int value = beginning.getValue();
		beginning = beginning.getNext();
		size--;
		return value;
		}
	}

	public int indexOf(int value) {	
		Node traversedNode = beginning;

		for (int i = 0; i < size; i++) {
			if (traversedNode.getValue() == value) return i;
			traversedNode = traversedNode.getNext();
		}
		return - 1;
	}

	public void pushFront(int value) {	
		Node newNode = new Node(value, null);
		size++;
		if (end == null) {
			end = newNode;
			beginning = end;
			newNode.setNext(null);
		}else {
			newNode.setNext(beginning);
			beginning = newNode;
		}
	}

	public void pushBack(int value) {
		Node newNode = new Node(value, null);
		size++;
		if (end == null) {
			beginning = newNode;
			end = beginning;
			end.setNext(null);
		}else {
			end.setNext(newNode);
			newNode.setNext(null);
			end = newNode;
		}
	}

	public void insert(int value, int position) {
		if (position < 0 || position > size) throw new IndexOutOfBoundsException();
		Node newNode = new Node(value, null);

		if (position == 0 && end == null) {
			end = newNode;
			beginning = end;
			newNode.setNext(null);
		} else if (position == 0 && end != null) {
			newNode.setNext(beginning);
			beginning = newNode;
		} else if (position == size) {
			end.setNext(newNode);
			newNode.setNext(null);
			end = newNode;
		} else {
			Node traversedNode = beginning;
			for (int i = 0; i < position; i++) {
				Node tmp = traversedNode.getNext();
				traversedNode.setNext(newNode);
				newNode.setNext(tmp);
				traversedNode = traversedNode.getNext();
			}
		}
		size++;
	}

	public void remove(int position) {
		if (position < 0 || position >= size) throw new IndexOutOfBoundsException();

		Node first = beginning;
		Node previous = null;

		while (position > 0) {
			position--;
			previous = first;
			first = first.getNext();
		}

		if (previous == null) {
			beginning = beginning.getNext();
		} else {
			previous.setNext(first.getNext());
		}
		if (first == end) {
			end = previous;
		}
		size--;
	}

	public void print() {
		System.out.print("\nLinked list = ");
		if (size == 0) {
			System.out.print("empty list\n");
			return;
		}
		if (beginning.getNext() == null) {
			System.out.println(beginning.getValue());
			return;
		}
		Node traversedNode = beginning;
		System.out.print(beginning.getValue() + "->");
		traversedNode = beginning.getNext();
		while (traversedNode.getNext() != null) {
			System.out.print(traversedNode.getValue() + "->");
			traversedNode = traversedNode.getNext();
		}
		System.out.print(traversedNode.getValue() + "\n");
	}
}