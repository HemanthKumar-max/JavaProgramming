package com.fundoonote.noteapi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fundoonote.noteapi.controller.NoteController;
import com.fundoonote.noteapi.model.Login;
import com.fundoonote.noteapi.model.Token;
import com.fundoonote.noteapi.model.UserLogin;
import com.fundoonote.noteapi.model.UserRegistration;

@Component
@Transactional
public class UserDao {

	private final String INDEX = "userdata";
	private final String TYPE = "Users";

	private RestHighLevelClient restHighLevelClient;

	private ObjectMapper objectMapper;

	public UserDao(ObjectMapper objectMapper, RestHighLevelClient restHighLevelClient) {
		this.objectMapper = objectMapper;
		this.restHighLevelClient = restHighLevelClient;
	}

	@Autowired
	private SessionFactory sessionFactory;

	public void addNewlogin(UserLogin login) {
		Session session = sessionFactory.getCurrentSession();
		session.save(login);

	}

	@SuppressWarnings("unchecked")
	public java.util.List<UserRegistration> findAllRegisters() {
		return sessionFactory.getCurrentSession().createSQLQuery("select * from userregistration;")
				.addEntity(UserRegistration.class).list();

	}

	public UserRegistration update(int userId, Token val) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		UserRegistration user = (UserRegistration) session.get(UserRegistration.class, userId);
		System.out.println("-->"+val.getPassword());
		user.setFirstname(val.getFirstname());
		user.setLastname(val.getLastname());
		user.setEmail(val.getEmail());
		user.setPassword(val.getPassword());
		session.update(user);
		return user;
	}

	public UserRegistration findById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		UserRegistration user = (UserRegistration) session.get(UserRegistration.class, id);
		return user;
	}

	public UserRegistration addNewRegistration(UserRegistration registration) {
		registration.setSid(UUID.randomUUID().toString());
		Map<String, Object> dataMap = objectMapper.convertValue(registration, Map.class);
		IndexRequest indexRequest = new IndexRequest(INDEX, TYPE, registration.getSid()).source(dataMap);
		try {
			IndexResponse response = restHighLevelClient.index(indexRequest);
		} catch (ElasticsearchException e) {
			e.getDetailedMessage();
		} catch (java.io.IOException ex) {
			ex.getLocalizedMessage();
		}
		Session session = sessionFactory.getCurrentSession();
		session.save(registration);
		System.out.println("data saved to database!!");
		return registration;
	}

	public void deleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		UserRegistration user = (UserRegistration) session.get(UserRegistration.class, id);
		if (user != null) {
			session.delete(user);
			System.out.println("user is deleted!!");
		}
		
		
		

	}

	public Map<String, Object> findByIdElastic(String id) {
		GetRequest getRequest = new GetRequest(INDEX, TYPE, id);
		GetResponse getResponse = null;
		try {
			getResponse = restHighLevelClient.get(getRequest);
		} catch (java.io.IOException e) {
			e.getLocalizedMessage();
		}
		Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
		return sourceAsMap;
	}

	public void checkLogin(Login log) {
		Session session = sessionFactory.getCurrentSession();
		session.save(log);
			
	}

	public UserRegistration findByemail(String email) {
		Session session = sessionFactory.getCurrentSession();
		UserRegistration user = (UserRegistration) session.get(UserRegistration.class, email);
		return user;
	}

}