package com.bridgelabz.fellowship.datastructures;
/**
 * @author:Hemanth Kumar
 * @date: 2020/01/20
 * @version:1.0
 * Purpose:
 **/

/**
 * Here import the utility package  to use the Utility class in a program.
 **/
public class Deque<T>
{
	public T data;
	public Deque<T> next;
	public Deque<T> pre;

	public Deque() {
		this.next = null;
		this.pre = null;
	}

	public Deque(T val) {
		this.data = val;
		this.next = null;
		this.pre = null;
	}
}

