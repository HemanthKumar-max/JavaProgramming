package com.bridgelabz.fellowship.datastructures;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.2
 * Purpose:Methods of Dequeue<T> class,such as addFront,addrear,removeFront,removeRear,empty,size.
 **/

import org.apache.log4j.Logger;

import com.bridgelabz.fellowship.InputUtility.LogUtility;

/**
 * Here import the utility package  to use the Utility class in a program.
 **/


public class Dequeue<T> 
{
	static Logger log = LogUtility.getLog();
	public Dequeue() {
	}

	Deque<T> front;
	Deque<T> rear;
	int size = 0;

	// add front
	@SuppressWarnings("null")
	public void addFront(T c) {
		if (front == null) // if no element in list
		{
			front.data = c;
			rear = front;
		} else // if element in list
		{
			Deque<T> tNode = null;
			tNode.data = c;
			tNode.next = front;
			front.pre = tNode;
			front = tNode;
		}
		size++;
	}

	// add rear
	public void addRear(T c) {
		if (front == null) // if no element in list
		{
			Deque<T> tNode = new Deque<T>(c);
			front = tNode;
			rear = front;
		} else // if element in list
		{
			Deque<T> tNode = new Deque<T>(c);
			rear.next = tNode;
			tNode.pre = rear;
			rear = tNode;
		}
		size++;
	}

	// remove front
	public T removeFront() {
		T val = null;
		if (front == null) {
			System.out.println("No elements to delete");
		} else {
			val = front.data;
			front = front.next;
		}
		size--;
		return val;
	}

	// remove rear
	public T removeRear() {
		T val = null;
		if (front == null) {
			System.out.println("No element to delete");
		} else {
			val = rear.data;
			rear = rear.pre;
			rear.next = null;
		}
		size--;
		return val;
	}

	// to remove
	public boolean isEmpty() {
		if (front == null)
			return true;
		else
			return false;
	}

	// return size of deque
	public int size() {
		return size;
	}
}
