package com.fundoonote.noteapi.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fundoonote.noteapi.model.MailMail;
import com.fundoonote.noteapi.model.UserRegistration;

@Component
public class Producer {

	@Autowired
	private AmqpTemplate amqpTemplate;

	
	
	
	private String MessageName = "From-User";

	private String routingKey = "key-routingkey";

	public void sendMessageToQueue(MailMail msg)  {

		amqpTemplate.convertAndSend(MessageName, routingKey, msg);
		System.out.println("sent to rabbitmq message  queue sucessfully");
		
	}
	
	public void sendMessageToQueue( Map<String, Object> map)  {

		amqpTemplate.convertAndSend(MessageName, routingKey, map);
		System.out.println("sent to rabbitmq message  queue sucessfully");
		
	}
	
	
	
	
	
	public void sendMessageToQueue(UserRegistration user) throws InterruptedException{

		amqpTemplate.convertAndSend(MessageName, routingKey, user);
		System.out.println("sent to rabbitmq message  queue sucessfully");
		
	}
	
	public void sendMessageToQueue(List<UserRegistration> list) throws InterruptedException{

		amqpTemplate.convertAndSend(MessageName, routingKey, list);
		System.out.println("sent to rabbitmq message  queue sucessfully");
		
	}
	
	
	
	

	public void sendMessageToQueue(String msg) {

		amqpTemplate.convertAndSend(MessageName, routingKey, msg);
		System.out.println("sent to rabbitmq message  queue sucessfully!!");
	}

}