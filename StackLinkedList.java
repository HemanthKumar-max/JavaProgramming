package com.bridgelabz.fellowship.datastructures;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:
 **/

/**
 * Here import the utility package to use the Utility class in a program.
 **/
public class StackLinkedList<T> 
{
	Node top;
    class Node
    {
		T data;
		Node next;
        Node(T data)
        {
			this.data = data;
			this.next = null;
		}
	}

	public void push(T data)
	{
		Node newnode = new Node(data);
		if (top == null)
			top = newnode;
		else 
		   {
			Node current = top;
			while (current.next != null) 
			 {
				current = current.next;
			 }
			current.next = newnode;
		   }
	}

	// /**
	// * Define the pop() for removing the elements from stack
	// *
	// * @return T
	// */
	public T pop() {
		T data = null;
		Node current = top;
		if (top == null) {
			System.out.println("Stack is Empty");
		} else if (current.next == null) {
			data = current.data;
			top = null;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			data = current.next.data;
			current.next = null;
		}
		return data;
	}

	// /**
	// * define the function peek() to peek the last element
	// *
	// * @return T
	// */
	public T peek() {
		T data = null;
		if (top == null)
			return data;
		else {
			Node current = top;
			Node previous = null;
			while (current != null)
			{
				previous = current;
				current = current.next;
			}
			data = previous.data;
		}
		return data;
	}

	// /**
	// * to get the size of the stack
	// *
	// * @return int
	// */
	public int size() {
		int size = 0;
		Node current = top;
		while (current != null) {
			current = current.next;
			size++;
		}
		return size;
	}

	// /**
	// * to check the stack is empty or not
	// *
	// * @return boolean
	// */
	public boolean isEmpty() {
		if (top == null)
			return true;
		else
			return false;
	}

	// // to print the elements of stack
	public void display() {
		Node current = top;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}
