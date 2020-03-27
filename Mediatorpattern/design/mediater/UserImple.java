package com.bridgelabz.Mediatorpattern.design.mediater;

public class UserImple extends User
{

	public UserImple(ChatMediater med, String name) {
		super(med, name);
		

}

	@Override
	public void send(String msg) {
		System.out.println(this.name+": Sending Message="+msg);
		mediator.sendMessage(msg, this);		
		
	}

	@Override
	public void receive(String msg) {
		System.out.println(this.name+": Received Message:"+msg);
		
	}
}
