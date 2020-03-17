package com.bridgelabz.companyshares.model;

public class QNode 
{
	int key; 
    QNode next; 
  
    // constructor to create a new linked list node 
    public <T> QNode(T key2) 
    { 
        this.key = (int) key2; 
        this.next = null; 
    } 
} 
