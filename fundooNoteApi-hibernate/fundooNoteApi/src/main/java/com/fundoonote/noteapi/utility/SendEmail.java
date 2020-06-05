package com.fundoonote.noteapi.utility;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fundoonote.noteapi.model.MailMail;
import com.fundoonote.noteapi.model.Token;
import com.fundoonote.noteapi.model.UserRegistration;






@Service
public class SendEmail {

	@Autowired
	private JavaMailSender emailSender;

	public void sendSimpleMessage(MailMail mail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject(mail.getSubject());
		message.setText(mail.getDate());
		message.setTo(mail.getTo());
		message.setFrom(mail.getFrom());

		emailSender.send(message);
	}
	
	
	public void sendEmail(UserRegistration user) throws MailException {

	    SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("hemanthkumarpower@gmail.com");
		mail.setSubject("Testing Mail API");
		mail.setText("Hurray ! You have done that dude...");

		emailSender.send(mail);
	}
	
	
	public void sendEmail(SimpleMailMessage user) throws MailException {

	    SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("");
		mail.setFrom("hemanthkumarpower@gmail.com");
		mail.setSubject("Testing Mail API");
		mail.setText("Hurray ! You have done that dude...");

		emailSender.send(user);
	}
	
	
	
	
	
	
	
	
	
	
}