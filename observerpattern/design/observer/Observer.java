package com.bridgelabz.observerpattern.design.observer;

public interface Observer {
	public void update();

	public void setSubject(Subject sub);
}
