package com.bridgelabz.fellowship.datastructures;

import java.util.ArrayList;

/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Linkedlist methods to add,pop,remove,search.
 **/

/**
 * Here import the utility package to use the Utility class in a program.
 **/

public class LinkedList<T> {
	Node head;

	// Inner class..
	public class Node {
		Node next;
		T data;

		// constructor
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * for adding the element in the linkedlist
	 * 
	 * @param data
	 *            ==>T
	 */
	public void add(T data) {
		Node node = new Node(data);
		Node current = head;

		if (head == null) {
			head = node;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}

	/**
	 * removing from end of linked list.
	 * 
	 * @return T
	 */
	public T pop() {
		Node current = head;
		T data = null;
		if (head == null) {
			System.out.println("List is Empty..!!");
		} else {
			while (current.next != null) {
				current = current.next;
			}
			System.out.println("Removed element :" + current.next.data);
			data = current.data;
			current.next = null;
		}
		return data;
	}

	/**
	 * Removing from list
	 */
	public void remove() {
		Node current = head;
		if (head == null) {
			System.out.println("List is Empty..!!");
		} 
		else
		{
			while (current.next != null) {
				current = current.next;
			}
			System.out.println("Removed element :" + current.next.data);
			current.next = null;
		}
	}

	/**
	 * searching the item
	 * 
	 * @param item
	 *            ==> T
	 * @return boolean
	 */
	public boolean search(T item) {
		Node current = head;
		while (current.next != null) {
			current = current.next;
			if (current.data == item || current.data.equals(item)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * remove a particular item
	 * 
	 * @param item
	 *            ==> T
	 */
	public T removeItem(T item) {
		Node current = head;
		Node prev = null;
		if (head == null) {
			System.out.println("List is empty..!!");
			return null;
		} else {
			while (current.next != null) {
				if (current.data.equals(item)) {
					System.out.println("Removed :" + current.data);
					prev.next = current.next;
					return current.data;
				}
				prev = current;
				current = current.next;
			}
		}
		return null;
	}

	// linkedlist is empty or not
	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	/**
	 * removing the item from particular position
	 * 
	 * @param pos
	 *            ==> int
	 * @return T
	 */
	public T pop(int pos) {
		Node current = head;
		Node prev = null;
		T data = null;
		if (pos == 0) {
			data = head.data;
			head = head.next;
			return data;
		}
		for (int i = 0; i < pos; i++) {
			prev = current;
			current = current.next;
		}
		prev.next = current.next.next;
		return current.data;

	}

	/**
	 * Size of the list
	 */
	public int size() {
		Node current = head;
		int size = 0;
		if (head == null) {
			System.out.println("list is empty");
		} else {
			while (current.next != null) {
				size++;
				current = current.next;
			}
		}
		return size;
	}

	/**
	 * Adding the node in last of list
	 * 
	 * @param data
	 *            ==> T
	 */
	public void append(T data) {
		Node node = new Node(data);
		Node current = head;
		if (head == null) {
			head = node;
		}
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;

	}

	/**
	 * Returns the position of item.
	 * 
	 * @param item
	 *            ==>T
	 * @return int
	 */
	public int index(T item) {
		int index = 0;
		Node current = head;
		if (head == item) {
			return index;
		}
		while (current.next != null) {
			index++;
			current = current.next;
			if (current.data == item || current.data.equals(item)) {
				return index;
			}
		}
		return -1;
	}

	/**
	 * insert item at particular position
	 * 
	 * @param pos
	 *            ==> int
	 * @param data
	 *            ==> T
	 */
	public void insert(int pos, T data) {
		Node node = new Node(data);
		Node current = head;
		if (pos == 0) {
			head = node;
		} else
			for (int i = 0; i < pos - 1; i++) {
				current = current.next;
			}
		node.next = current.next;
		current.next = node;
	}

	/**
	 * Displaying the output
	 */
	
	public ArrayList<String> display() 
	{
		ArrayList<String> al=new ArrayList<>();
		// Node current will point to head
		Node current = head;
		if (head == null) {
			System.out.println("List is empty");
		}
		while (current != null) {
			// Prints each node by incrementing pointer
			al.add(current.data + " ");
		
			
			current = current.next;
			
		}
		return al;

	}
	
	
	

	
	public String showListWithoutSpaces() 
	{
		String str = "";
		Node n = head;
		while (n.next != null) {
			str += n.data;
			n = n.next;
		}
		str += n.data;
		return str;
	}

	public String show() {
		String str = "";
		Node n = head;
		if (head == null) {
			return "no data";
		} else {
			while (n.next != null) {
				str += n.data + " ";
				n = n.next;
			}
			str += n.data;
		}

		return str;
		
	}

	public T get(int index) {
		if (index == 0)
			return head.data;
		else {
			Node n = head;
			for (int i = 0; i < index; i++) {
				if (n.next != null) {
					n = n.next;
				} else {
					return null;
				}

			}
//			n = n.next;
			return n.data;

		}

	}
	}


