package com.bridgelabz.fellowship.datastructures;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:
 **/

/**
 * Here import the utility package  to use the Utility class in a program.
 **/
import java.util.NoSuchElementException;

public class Queue<T> {
	Node head;
   Object[] queue=new Object[10];
   int front;
	int rear;
	int size;
	class Node {// Inner Class
		T data;
		Node next;

		// constructor
		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * for adding the elements in the queue
	 * 
	 * @param data
	 *            ==>T
	 */
	public void enQueue(T data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	/**
	 * for removing the elements from the queue
	 * 
	 * @return T
	 */
	public T deQueue() {
		T data = null;
		if (head == null) {
			throw new NoSuchElementException("UnderFlow");
		} else {
			data = head.data;
			head = head.next;
		}
		return data;
	}

	/**
	 * to check the queue is empty or not
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * to calculate the size of the queue
	 * 
	 * @return int
	 */
	public int getSize() {
		int size = 0;
		if (head == null) {
			return 0 ;// 0
		} else {
			Node current = head;
			while (current != null) {
				current = current.next;
				size++;
			}
		}
		return size;
	}

	/**
	 * to get the last element from the queue
	 * 
	 * @return T
	 */
	public T peek() {
		T data = null;
		if (head == null)
			return data;
		else {
			Node current = head;
			Node previous = null;
			while (current != null) {
				previous = current;
				current = current.next;
			}
			data = previous.data;
		}
		return data;
	}

	// for printing the elements of the queue
	public void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	public boolean isFull() {
		return getSize() == 5;
	}

	
       
	
	
	
	
}