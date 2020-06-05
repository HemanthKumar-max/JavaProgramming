package com.fundoonote.noteapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fundoonote.noteapi.JmsClient;





@Service
public class JmsClientImpl implements JmsClient{

	@Autowired
	JmsConsumer jmsConsumer;
	
	@Autowired
	JmsProducer jmsProducer;
	
	@Override
	public void send(String msg) {
		jmsProducer.send(msg);
	}

	@Override
	public String receive() {
		return jmsConsumer.receive();
	}

}
