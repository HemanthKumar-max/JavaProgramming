package com.bridgelabz.observer.controller;

import com.bridgelabz.observerpattern.design.observer.Observer;
import com.bridgelabz.observerpattern.design.observer.SimpleTopic;
import com.bridgelabz.observerpattern.design.observer.SimpleTopicSubscriber;

public class Runner 
{
	public static void main(String[] args) {
		//create subject
		SimpleTopic topic = new SimpleTopic();
		
		//create observers
		Observer obj1 = new SimpleTopicSubscriber("Obj1");
		Observer obj2 = new SimpleTopicSubscriber("Obj2");
		Observer obj3 = new SimpleTopicSubscriber("Obj3");
		
		//register observers to the subject
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);
		
		//attach observer to subject
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);
		
		//check if any update is available
		obj1.update();
		
		//now send message to subject
		topic.postMessage("New Message");
	}

}
