package com.fundoonote.noteapi.service;


import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.fundoonote.noteapi.SpringRedisConfig;
import com.fundoonote.noteapi.dao.UserDao;
import com.fundoonote.noteapi.model.Login;
import com.fundoonote.noteapi.model.Token;
import com.fundoonote.noteapi.model.UserLogin;
import com.fundoonote.noteapi.model.UserRegistration;



@Service
public class UserServiceImple implements UserService
{


	
	private HashOperations hashOperations;

	private RedisTemplate<String, UserRegistration> redisTemplate;

	public UserServiceImple(RedisTemplate<String, UserRegistration> redisTemplate) {
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}
	
	
	
	
	@Autowired
	private UserDao userdao;
	


	


	@Override
	public void userLogin(UserLogin login) {
		userdao.addNewlogin(login);
		
	}




	@Override
	public List<UserRegistration> findAllRegisters() {
		return userdao.findAllRegisters();
		
	}



	@SuppressWarnings("unchecked")
	@Override
	public UserRegistration findById(int id) {
//	return (UserRegistration) hashOperations.get("User",id);// getting the data from redis-server.
		return userdao.findById(id);
	}







	@Override
	public UserRegistration update(int userId, Token storedDetails) {
		return userdao.update(userId,storedDetails );
				
	}



	



	@SuppressWarnings("unchecked")
	@Override
	public UserRegistration userRegistration(UserRegistration registration)  {
		UserRegistration user=userdao.addNewRegistration(registration);
		hashOperations.put("User", user.getId(), user);//storing the data to redis-server database.
		return user;
	}



	@SuppressWarnings("unchecked")
	@Override
	public void deleteById(int id) {
		// hashOperations.delete("User",id);
		userdao.deleteById(id);
		
	}




	@Override
	public Map<String, Object> findByIdElastic(String id) {
		return userdao.findByIdElastic(id);
	}




	@Override
	public void login(Login log) {
	         userdao.checkLogin(log);
		
	}




	@Override
	public UserRegistration findByemail(String email) {
		return userdao.findByemail(email);
	}



//
//	@Override
//	public UserRegistration collaborateUser(UserRegistration registration) {
//		return userdao.collaborateNewUser(registration);
//	}




	







	



	

}
