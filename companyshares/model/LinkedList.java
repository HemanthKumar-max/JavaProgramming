package com.bridgelabz.companyshares.model;

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

@SuppressWarnings("hiding")
public class LinkedList 
{
	Node head;  // head of list 
	  
    /* Linked list Node*/
    class Node<T> 
    { 
        T data; 
        Node next; 
        Node(T d) {
        	data = d;
        	next = null; 
        	} 
    } 
  
    /* Inserts a new Node at front of the list. */
    public <T> void push(T new_data) 
    { 
        /* 1 & 2: Allocate the Node & 
                  Put in the data*/
        Node new_node = new Node(new_data); 
  
        /* 3. Make next of new Node as head */
        new_node.next = head; 
  
        /* 4. Move the head to point to new Node */
        head = new_node; 
    } 
  
    /* Inserts a new node after the given prev_node. */
    public void insertAfter(Node prev_node, int new_data) 
    { 
        /* 1. Check if the given Node is null */
        if (prev_node == null) 
        { 
            System.out.println("The given previous node cannot be null"); 
            return; 
        } 
  
        /* 2 & 3: Allocate the Node & 
                  Put in the data*/
        Node new_node = new Node(new_data); 
  
        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next; 
  
        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node; 
    } 
     
    /* Appends a new node at the end.  This method is  
       defined inside LinkedList class shown above */
    public void append(int new_data) 
    { 
        /* 1. Allocate the Node & 
           2. Put in the data 
           3. Set next as null */
        Node new_node = new Node(new_data); 
  
        /* 4. If the Linked List is empty, then make the 
              new node as head */
        if (head == null) 
        { 
            head = new Node(new_data); 
            return; 
        } 
  
        /* 4. This new node is going to be the last node, so 
              make next of it as null */
        new_node.next = null; 
  
        /* 5. Else traverse till the last node */
        Node last = head;  
        while (last.next != null) 
            last = last.next; 
  
        /* 6. Change the next of last node */
        last.next = new_node; 
        return; 
    } 
  
    /* This function prints contents of linked list starting from 
        the given node */
    public void printList() 
    { 
        Node tnode = head; 
        while (tnode != null) 
        { 
            System.out.print(tnode.data+" "); 
            tnode = tnode.next; 
        } 
    } 
    
   public  <T> void deleteNode(T key) 
    { 
        // Store head node 
        Node temp = head, prev = null; 
  
        // If head node itself holds the key to be deleted 
        if (temp != null && temp.data == key) 
        { 
            head = temp.next; // Changed head 
            return; 
        } 
  
        // Search for the key to be deleted, keep track of the 
        // previous node as we need to change temp.next 
        while (temp != null && temp.data != key) 
        { 
            prev = temp; 
            temp = temp.next; 
        }     
  
        // If key was not present in linked list 
        if (temp == null) return; 
  
        // Unlink the node from linked list 
        prev.next = temp.next; 
    } 
    
  
    /* Driver program to test above functions. Ideally this function 
       should be in a separate user class.  It is kept here to keep 
       code compact */
}

