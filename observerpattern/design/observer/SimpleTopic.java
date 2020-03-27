package com.bridgelabz.observerpattern.design.observer;

import java.util.ArrayList;
import java.util.List;


public class SimpleTopic implements Subject {
	private List<Observer> observers;
	private String message;
	private boolean changed;
	private final Object Main = new Object();

	public SimpleTopic() {
		super();
		this.observers = new ArrayList<>();
	}

	@Override
	public void register(Observer obj) {
		if (obj == null)
			throw new NullPointerException("Null Observer");
		synchronized (Main) {
			if (!observers.contains(obj))
				observers.add(obj);
		}
    }

	
	@Override
	public void unregister(Observer obj) {
		synchronized (Main) {
			observers.remove(obj);
			}
		
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		//synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (Main) {
			if (!changed)
				return;
			observersLocal = new ArrayList<>(this.observers);
			this.changed=false;
		}
		for (Observer obj : observersLocal) {
			obj.update();
		}
	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	
	
	public void postMessage(String msg){
		System.out.println("Message Posted to Topic:"+msg);
		this.message=msg;
		this.changed=true;
		notifyObservers();

}
}